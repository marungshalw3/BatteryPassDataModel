#!/usr/bin/env bash
#
# make-schema.sh — concatenate the seven aspect JSON Schemas for a given
# data-model version into a single document:
#
#     schema<version>.json   =>   { "<Aspect>": <aspect JSON Schema>, ... }
#
# Unlike make-passport.sh (which bundles sample payloads), this bundles the
# JSON *schemas*, so a downstream diff reflects real structure, types and
# required/optional — with no sample-value noise.
#
# Usage:
#   ./make-schema.sh <version> [OUTPUT]
#
#   <version>   1.2 | 1.3 | 1.2.0 | 1.3.0 (minor prefixes resolve to highest patch per aspect).
#   OUTPUT      output path (default: ./schema<version>.json next to this script).
#
set -uo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
VER="${1:?usage: ./make-schema.sh <version e.g. 1.2 or 1.3> [output]}"
OUT="${2:-$SCRIPT_DIR/schema${VER}.json}"

python3 - "$SCRIPT_DIR" "$VER" "$OUT" <<'PY'
import json, sys, os, glob, re

root, ver, out = sys.argv[1], sys.argv[2], sys.argv[3]

def read_json(path):
    raw = open(path, 'rb').read()
    if raw[:2] in (b'\xff\xfe', b'\xfe\xff'):
        text = raw.decode('utf-16')
    else:
        text = raw.decode('utf-8', errors='replace')
    return json.loads(text.lstrip('﻿'))

def vkey(v):
    return tuple(int(x) for x in re.findall(r'\d+', v))

def resolve_version_dir(aspect_dir, ver):
    pref = ver if ver.count('.') == 2 else None
    matches = []
    for d in os.listdir(aspect_dir):
        if not os.path.isdir(os.path.join(aspect_dir, d)): continue
        if pref:
            if d == pref: matches.append(d)
        elif d == ver or d.startswith(ver + '.'):
            matches.append(d)
    return max(matches, key=vkey) if matches else None

def find_schema(gendir, base):
    # Prefer convert.sh naming <base>.schema, else consortium <base>-schema.json
    for cand in (base + '.schema', base + '-schema.json'):
        p = os.path.join(gendir, cand)
        if os.path.isfile(p): return p
    for f in sorted(glob.glob(os.path.join(gendir, '*schema*'))):
        if f.endswith(('.schema', '-schema.json')): return f
    return None

bundle, report, missing = {}, [], []
for aspect_dir in sorted(glob.glob(os.path.join(root, 'io.BatteryPass.*'))):
    aspect = os.path.basename(aspect_dir).replace('io.BatteryPass.', '')
    vdir = resolve_version_dir(aspect_dir, ver)
    if not vdir:
        missing.append(f"{aspect}: no {ver} version folder"); continue
    ttls = glob.glob(os.path.join(aspect_dir, vdir, '*.ttl'))
    if not ttls:
        missing.append(f"{aspect}: no .ttl in {vdir}"); continue
    base = os.path.splitext(os.path.basename(ttls[0]))[0]
    sch = find_schema(os.path.join(aspect_dir, vdir, 'gen'), base)
    if not sch:
        missing.append(f"{aspect}: no schema in {vdir}/gen (run convert.sh)"); continue
    bundle[aspect] = read_json(sch)
    report.append(f"  {aspect:28} <- {vdir}/gen/{os.path.basename(sch)}")

if not bundle:
    print("ERROR: no aspect schemas found for version " + ver, file=sys.stderr)
    for m in missing: print("  " + m, file=sys.stderr)
    sys.exit(1)

with open(out, 'w', encoding='utf-8') as fh:
    json.dump(bundle, fh, indent=2, ensure_ascii=False, sort_keys=True)
    fh.write("\n")

print(f"Wrote {out} with {len(bundle)} aspect schema(s):")
print("\n".join(report))
if missing:
    print("\nWARN — skipped:")
    print("\n".join("  " + m for m in missing))
PY
