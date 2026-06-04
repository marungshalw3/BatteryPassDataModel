#!/usr/bin/env node
import { readFileSync, writeFileSync, mkdirSync, existsSync } from 'node:fs';
import { resolve as resolvePath, join, dirname } from 'node:path';
import { fileURLToPath } from 'node:url';
import { load, toZod, toMongoose, toJsonSchema, type Node } from './convert.js';

/**
 * Generate Mongoose + Zod (+ JSON Schema) models from a composed schema.
 *
 * Usage:
 *   model-generator --version 1.3 [--out <dir>] [--name <ModelName>]
 *   model-generator --schema <path/to/composed-schema.json> [--out <dir>] [--name <ModelName>]
 *
 * Defaults:
 *   --schema   ../BatteryPass/composed-schema<version>.json   (when --version given)
 *   --out      ./generated/<version|name>
 *   --name     BatteryPassport
 */

const here = dirname(fileURLToPath(import.meta.url));
const lower = (s: string) => s.charAt(0).toLowerCase() + s.slice(1);

function flags(argv: string[]): Record<string, string> {
  const o: Record<string, string> = {};
  for (let i = 0; i < argv.length; i++) {
    if (argv[i].startsWith('--')) {
      const k = argv[i].slice(2);
      const v = argv[i + 1];
      if (v && !v.startsWith('--')) { o[k] = v; i++; } else o[k] = 'true';
    }
  }
  return o;
}

function main(): void {
  const f = flags(process.argv.slice(2));
  const version = f.version && f.version !== 'true' ? f.version : undefined;

  // Resolve the composed schema path.
  let schemaPath: string | undefined =
    f.schema && f.schema !== 'true' ? resolvePath(f.schema) : undefined;
  if (!schemaPath && version) {
    // Default: sibling BatteryPass/ folder (model-generator lives next to it).
    schemaPath = resolvePath(here, '..', '..', 'BatteryPass', `composed-schema${version}.json`);
  }
  if (!schemaPath) {
    console.error('Usage: model-generator --version <1.2|1.3>  (or --schema <composed-schema.json>)  [--out <dir>] [--name <ModelName>]');
    process.exitCode = 1;
    return;
  }
  if (!existsSync(schemaPath)) {
    console.error(`Composed schema not found: ${schemaPath}\nRun ../BatteryPass/make-composed-schema.sh ${version ?? '<version>'} first.`);
    process.exitCode = 1;
    return;
  }

  const schema = JSON.parse(readFileSync(schemaPath, 'utf8').replace(/^﻿/, ''));
  const node: Node = load(schema);
  if (node.k !== 'object') {
    console.error('Composed schema root is not an object schema.');
    process.exitCode = 1;
    return;
  }

  const name = f.name && f.name !== 'true' ? f.name : 'BatteryPassport';
  const constName = `${lower(name)}Schema`;
  const outDir = resolvePath(f.out ?? join('generated', version ?? name));
  mkdirSync(outDir, { recursive: true });

  const banner = `// AUTO-GENERATED from ${schemaPath.split('/').slice(-2).join('/')} — do not edit by hand.\n`;

  const zod = `${banner}import { z } from 'zod';

export const ${constName} = ${toZod(node, 1)};

export type ${name} = z.infer<typeof ${constName}>;
`;

  const mongoose = `${banner}import { Schema, model, type InferSchemaType } from 'mongoose';

export const ${constName} = new Schema(${toMongoose(node, 1)}, { timestamps: true });

export type ${name}Doc = InferSchemaType<typeof ${constName}>;
export const ${name} = model('${name}', ${constName});
`;

  const jsonSchema = JSON.stringify(
    { $schema: 'http://json-schema.org/draft-07/schema#', title: name, ...toJsonSchema(node) },
    null, 2,
  ) + '\n';

  const index = `export * as zod from './zod.js';\nexport * as mongoose from './mongoose.js';\nimport jsonSchema from './json-schema.json' with { type: 'json' };\nexport { jsonSchema };\n`;

  const files: [string, string][] = [
    ['zod.ts', zod],
    ['mongoose.ts', mongoose],
    ['json-schema.json', jsonSchema],
    ['index.ts', index],
  ];
  for (const [n, c] of files) writeFileSync(join(outDir, n), c, 'utf8');

  console.log(`Generated ${name} models → ${outDir}`);
  console.log(`  source: ${schemaPath}`);
  console.log(`  aspects: ${node.props.map((p) => p.key).join(', ')}`);
  for (const [n] of files) console.log(`  • ${n}`);
}

main();
