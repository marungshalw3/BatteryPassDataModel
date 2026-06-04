/**
 * Convert a composed JSON Schema (draft-07, self-contained with `$defs`) into
 * Mongoose + Zod + JSON-Schema outputs. Self-contained — no external deps.
 *
 * Input shape: the output of `../BatteryPass/make-composed-schema.sh`, i.e. a
 * single valid schema whose `$ref`s resolve against its own `$defs`.
 */

export type Node =
  | { k: 'object'; props: Field[]; desc?: string }
  | { k: 'array'; items: Node; desc?: string }
  | { k: 'string'; format?: string; enum?: string[]; desc?: string }
  | { k: 'number'; int?: boolean; desc?: string }
  | { k: 'boolean'; desc?: string }
  | { k: 'date'; desc?: string }
  | { k: 'any'; desc?: string };

export interface Field {
  key: string;
  node: Node;
  required: boolean;
}

type Defs = Record<string, any>;

/** Resolve a raw JSON-Schema node into the normalized IR, following $ref/allOf. */
export function resolve(raw: any, defs: Defs, seen: Set<string> = new Set()): Node {
  if (!raw || typeof raw !== 'object') return { k: 'any' };

  if (raw.$ref) {
    const name = String(raw.$ref).split('/').pop()!;
    if (seen.has(name)) return { k: 'any' };
    const target = defs[name];
    if (!target) return { k: 'any' };
    return resolve(target, defs, new Set([...seen, name]));
  }
  if (Array.isArray(raw.allOf) && raw.allOf.length === 1) {
    const n = resolve(raw.allOf[0], defs, seen);
    if (raw.description && !n.desc) n.desc = raw.description;
    return n;
  }

  const desc: string | undefined = raw.description || raw.title;

  if (Array.isArray(raw.enum)) return { k: 'string', enum: raw.enum.map(String), desc };

  const type = raw.type;
  if (type === 'object' || raw.properties) {
    const required: string[] = raw.required ?? [];
    const props: Field[] = Object.entries(raw.properties ?? {}).map(([key, child]) => ({
      key,
      node: resolve(child, defs, seen),
      required: required.includes(key),
    }));
    return { k: 'object', props, desc };
  }
  if (type === 'array') return { k: 'array', items: resolve(raw.items ?? {}, defs, seen), desc };
  if (type === 'string') {
    const f = raw.format as string | undefined;
    if (f === 'date-time' || f === 'date') return { k: 'date', desc };
    return { k: 'string', format: f, desc };
  }
  if (type === 'integer') return { k: 'number', int: true, desc };
  if (type === 'number') return { k: 'number', desc };
  if (type === 'boolean') return { k: 'boolean', desc };
  return { k: 'any', desc };
}

/** Load a composed schema file and resolve it to the root IR node. */
export function load(schema: any): Node {
  const defs: Defs = schema.$defs ?? schema.definitions ?? schema.components?.schemas ?? {};
  return resolve(schema, defs);
}

// ---- helpers ----
const jsdoc = (desc: string | undefined, pad: string): string =>
  desc ? `${pad}/** ${desc.replace(/\s+/g, ' ').replace(/\*\//g, '*\\/').slice(0, 160)} */\n` : '';

// ---- emitters ----
export function toJsonSchema(node: Node): any {
  switch (node.k) {
    case 'object': {
      const properties: Record<string, any> = {};
      const required: string[] = [];
      for (const p of node.props) {
        properties[p.key] = toJsonSchema(p.node);
        if (p.required) required.push(p.key);
      }
      return { type: 'object', ...(node.desc ? { description: node.desc } : {}), properties, ...(required.length ? { required } : {}) };
    }
    case 'array': return { type: 'array', items: toJsonSchema(node.items) };
    case 'string': return node.enum ? { type: 'string', enum: node.enum } : { type: 'string', ...(node.format ? { format: node.format } : {}) };
    case 'number': return { type: node.int ? 'integer' : 'number' };
    case 'boolean': return { type: 'boolean' };
    case 'date': return { type: 'string', format: 'date-time' };
    default: return {};
  }
}

export function toZod(node: Node, indent = 1): string {
  const pad = '  '.repeat(indent);
  switch (node.k) {
    case 'object': {
      const lines = node.props.map((p) => {
        let e = toZod(p.node, indent + 1);
        if (!p.required) e += '.optional()';
        return `${jsdoc(p.node.desc, pad)}${pad}${JSON.stringify(p.key)}: ${e},`;
      });
      return `z.object({\n${lines.join('\n')}\n${'  '.repeat(indent - 1)}})`;
    }
    case 'array': return `z.array(${toZod(node.items, indent)})`;
    case 'string':
      if (node.enum) return `z.enum([${node.enum.map((v) => JSON.stringify(v)).join(', ')}])`;
      return node.format === 'uri' ? 'z.string().url()' : 'z.string()';
    case 'number': return node.int ? 'z.number().int()' : 'z.number()';
    case 'boolean': return 'z.boolean()';
    case 'date': return 'z.coerce.date()';
    default: return 'z.any()';
  }
}

export function toMongoose(node: Node, indent = 1): string {
  const pad = '  '.repeat(indent);
  switch (node.k) {
    case 'object': {
      const lines = node.props.map((p) => {
        const child = p.node;
        let def: string;
        if (child.k === 'object' || child.k === 'array') def = toMongoose(child, indent + 1);
        else {
          const t = scalarType(child);
          const opts = [`type: ${t}`];
          if (p.required) opts.push('required: true');
          if (child.k === 'string' && child.enum) opts.push(`enum: [${child.enum.map((v) => JSON.stringify(v)).join(', ')}]`);
          def = `{ ${opts.join(', ')} }`;
        }
        return `${jsdoc(child.desc, pad)}${pad}${JSON.stringify(p.key)}: ${def},`;
      });
      return `{\n${lines.join('\n')}\n${'  '.repeat(indent - 1)}}`;
    }
    case 'array': {
      const it = node.items;
      const inner = it.k === 'object' || it.k === 'array' ? toMongoose(it, indent) : scalarType(it);
      return `[${inner}]`;
    }
    default: return scalarType(node);
  }
}

function scalarType(node: Node): string {
  switch (node.k) {
    case 'string': return 'String';
    case 'number': return 'Number';
    case 'boolean': return 'Boolean';
    case 'date': return 'Date';
    default: return 'Schema.Types.Mixed';
  }
}
