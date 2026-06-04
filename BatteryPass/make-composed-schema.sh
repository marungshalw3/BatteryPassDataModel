#!/usr/bin/env bash
#
# make-composed-schema.sh — compose the seven aspect JSON Schemas for a version
# into ONE valid, self-contained JSON Schema (draft-07) that can validate a
# whole passport document of the shape produced by make-passport.sh:
#
#     { "<Aspect>": { ...aspect data... }, ... }
#
# Unlike make-schema.sh (a *bundle* of per-aspect schemas whose internal $refs
# dangle once nested), this RELOCATES every aspect's `components/schemas` defs
# into a shared root `$defs` (namespaced `<Aspect>__<Name>`) and rewrites the
# $ref pointers, so the result is a single resolvable schema.
#
# Usage:
#   ./make-composed-schema.sh <version> [OUTPUT]
#     <version>  1.2 | 1.3 | 1.2.0 | 1.3.0
#     OUTPUT     default: ./composed-schema<version>.json
#
set -uo pipefail
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
VER="${1:?usage: ./make-composed-schema.sh <version e.g. 1.2 or 1.3> [output]}"
OUT="${2:-$SCRIPT_DIR/composed-schema${VER}.json}"

python3 - "$SCRIPT_DIR" "$VER" "$OUT" <<'PY'
import json, sys, os, glob, re

root, ver, out = sys.argv[1], sys.argv[2], sys.argv[3]

def read_json(path):
    raw = open(path, 'rb').read()
    text = raw.decode('utf-16') if raw[:2] in (b'\xff\xfe', b'\xfe\xff') else raw.decode('utf-8', 'replace')
    return json.loads(text.lstrip('﻿'))

def vkey(v): return tuple(int(x) for x in re.findall(r'\d+', v))

def resolve_version_dir(aspect_dir, ver):
    pref = ver if ver.count('.') == 2 else None
    matches = [d for d in os.listdir(aspect_dir)
               if os.path.isdir(os.path.join(aspect_dir, d))
               and (d == pref if pref else (d == ver or d.startswith(ver + '.')))]
    return max(matches, key=vkey) if matches else None

def find_schema(gendir, base):
    for c in (base + '.schema', base + '-schema.json'):
        p = os.path.join(gendir, c)
        if os.path.isfile(p): return p
    return None

def normalize_draft04(out):
    """Convert draft-04 boolean exclusiveMin/Max to draft-07 numeric form."""
    for kind in ('Maximum', 'Minimum'):
        excl, bound = 'exclusive' + kind, kind.lower()
        if isinstance(out.get(excl), bool):
            if out[excl] is True and bound in out:
                out[excl] = out.pop(bound)      # exclusive bound -> numeric exclusive*
            else:
                out.pop(excl)                    # inclusive (false) or orphan -> drop, keep `maximum`/`minimum`
    return out

def rewrite_refs(node, aspect):
    """Recursively rewrite #/components/schemas/X -> #/$defs/<aspect>__X and
    normalize draft-04 constructs to draft-07."""
    if isinstance(node, dict):
        out = {}
        for k, v in node.items():
            if k == '$ref' and isinstance(v, str):
                m = re.match(r'#/(?:components/schemas|\$defs|definitions)/(.+)', v)
                out[k] = f'#/$defs/{aspect}__{m.group(1)}' if m else v
            else:
                out[k] = rewrite_refs(v, aspect)
        return normalize_draft04(out)
    if isinstance(node, list):
        return [rewrite_refs(x, aspect) for x in node]
    return node

properties, defs, required, report, missing = {}, {}, [], [], []
for aspect_dir in sorted(glob.glob(os.path.join(root, 'io.BatteryPass.*'))):
    aspect = os.path.basename(aspect_dir).replace('io.BatteryPass.', '')
    vdir = resolve_version_dir(aspect_dir, ver)
    if not vdir: missing.append(f"{aspect}: no {ver} folder"); continue
    ttls = glob.glob(os.path.join(aspect_dir, vdir, '*.ttl'))
    if not ttls: missing.append(f"{aspect}: no .ttl in {vdir}"); continue
    base = os.path.splitext(os.path.basename(ttls[0]))[0]
    schp = find_schema(os.path.join(aspect_dir, vdir, 'gen'), base)
    if not schp: missing.append(f"{aspect}: no schema in {vdir}/gen"); continue

    s = read_json(schp)
    aspect_defs = (s.get('components', {}) or {}).get('schemas') or s.get('$defs') or s.get('definitions') or {}
    # Relocate defs into the shared root $defs, namespaced and ref-rewritten.
    for name, dnode in aspect_defs.items():
        defs[f'{aspect}__{name}'] = rewrite_refs(dnode, aspect)
    # The aspect's own object schema (strip components/$schema, rewrite refs).
    obj = {k: v for k, v in s.items() if k not in ('components', '$schema', 'definitions')}
    properties[aspect] = rewrite_refs(obj, aspect)
    required.append(aspect)
    report.append(f"  {aspect:28} <- {vdir}/gen/{os.path.basename(schp)}")

if not properties:
    print("ERROR: no aspect schemas found for version " + ver, file=sys.stderr)
    for m in missing: print("  " + m, file=sys.stderr)
    sys.exit(1)

composed = {
    "$schema": "http://json-schema.org/draft-07/schema#",
    "$id": f"battery-passport-eu-{ver}",
    "title": f"EU Battery Passport composed schema (v{ver})",
    "type": "object",
    "properties": dict(sorted(properties.items())),
    "required": sorted(required),
    "$defs": dict(sorted(defs.items())),
    "additionalProperties": False,
}

with open(out, 'w', encoding='utf-8') as fh:
    json.dump(composed, fh, indent=2, ensure_ascii=False)
    fh.write("\n")

# --- self-check: schema validity + every $ref resolves ---
note = ""
try:
    from jsonschema import Draft7Validator
    Draft7Validator.check_schema(composed)
    note = "valid draft-07 schema"
except Exception as e:
    note = f"WARNING: schema validity check failed: {e}"

blob = json.dumps(composed)
unresolved = [r for r in set(re.findall(r'"\$ref":\s*"#/\$defs/([^"]+)"', blob)) if r not in composed["$defs"]]

print(f"Wrote {out}")
print(f"  {len(properties)} aspects, {len(defs)} relocated defs — {note}")
print(f"  dangling $refs: {len(unresolved)}" + (": " + ", ".join(unresolved[:5]) if unresolved else " (none)"))
for r in report: print(r)
if missing:
    print("WARN — skipped:"); [print("  " + m) for m in missing]
PY
