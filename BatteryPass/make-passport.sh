#!/usr/bin/env bash
#
# make-passport.sh — concatenate the seven aspect JSON sample payloads for a
# given data-model version into a single passport sample document:
#
#     passport<version>.json   =>   { "<Aspect>": <aspect sample json>, ... }
#
# Usage:
#   ./make-passport.sh <version> [OUTPUT]
#
#   <version>   1.2 | 1.3 | 1.2.0 | 1.3.0 (minor prefixes resolve to the highest
#               matching patch per aspect, e.g. Performance 1.2 -> 1.2.1).
#   OUTPUT      output path (default: ./passport<version>.json next to this script).
#
# Examples:
#   ./make-passport.sh 1.3
#   ./make-passport.sh 1.2 /tmp/passport12.json
#
set -uo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
VER="${1:?usage: ./make-passport.sh <version e.g. 1.2 or 1.3> [output]}"
OUT="${2:-$SCRIPT_DIR/passport${VER}.json}"

python3 - "$SCRIPT_DIR" "$VER" "$OUT" <<'PY'
import json, sys, os, glob, re

root, ver, out = sys.argv[1], sys.argv[2], sys.argv[3]

def read_json(path):
    raw = open(path, 'rb').read()
    if raw[:2] in (b'\xff\xfe', b'\xfe\xff'):
        text = raw.decode('utf-16')          # auto-detects BOM endianness
    else:
        text = raw.decode('utf-8', errors='replace')
    return json.loads(text.lstrip('﻿'))  # strip any residual BOM char

def vkey(v):  # sortable version tuple
    return tuple(int(x) for x in re.findall(r'\d+', v))

def resolve_version_dir(aspect_dir, ver):
    cands = [d for d in os.listdir(aspect_dir)
             if os.path.isdir(os.path.join(aspect_dir, d))
             and (d == ver or d.startswith(ver + '.') or d.split('.')[:2] == ver.split('.')[:2] and d.startswith(ver.split('.')[0]))]
    # strict: exact match, else same major.minor prefix
    pref = ver if ver.count('.') == 2 else None
    matches = []
    for d in os.listdir(aspect_dir):
        full = os.path.join(aspect_dir, d)
        if not os.path.isdir(full): continue
        if pref:
            if d == pref: matches.append(d)
        else:
            if d == ver or d.startswith(ver + '.'): matches.append(d)
    if not matches: return None
    return max(matches, key=vkey)

def find_sample(gendir, base):
    # Prefer our convert.sh naming <base>.json (exclude openapi), else consortium <base>-payload.json
    c1 = os.path.join(gendir, base + '.json')
    if os.path.isfile(c1): return c1
    c2 = os.path.join(gendir, base + '-payload.json')
    if os.path.isfile(c2): return c2
    # last resort: any *-payload.json / *.json that isn't openapi/ld/schema
    for f in sorted(glob.glob(os.path.join(gendir, '*.json'))):
        n = os.path.basename(f).lower()
        if 'openapi' in n or n.endswith('-ld.json') or n.endswith('-schema.json'): continue
        return f
    return None

passport, report, missing = {}, [], []
for aspect_dir in sorted(glob.glob(os.path.join(root, 'io.BatteryPass.*'))):
    aspect = os.path.basename(aspect_dir).replace('io.BatteryPass.', '')
    vdir = resolve_version_dir(aspect_dir, ver)
    if not vdir:
        missing.append(f"{aspect}: no {ver} version folder"); continue
    ttls = glob.glob(os.path.join(aspect_dir, vdir, '*.ttl'))
    if not ttls:
        missing.append(f"{aspect}: no .ttl in {vdir}"); continue
    base = os.path.splitext(os.path.basename(ttls[0]))[0]
    sample = find_sample(os.path.join(aspect_dir, vdir, 'gen'), base)
    if not sample:
        missing.append(f"{aspect}: no sample json in {vdir}/gen (run convert.sh)"); continue
    passport[aspect] = read_json(sample)
    report.append(f"  {aspect:28} <- {vdir}/gen/{os.path.basename(sample)}")

if not passport:
    print("ERROR: no aspect samples found for version " + ver, file=sys.stderr)
    if missing: print("\n".join("  " + m for m in missing), file=sys.stderr)
    sys.exit(1)

with open(out, 'w', encoding='utf-8') as fh:
    json.dump(passport, fh, indent=2, ensure_ascii=False, sort_keys=True)
    fh.write("\n")

print(f"Wrote {out} with {len(passport)} aspect(s):")
print("\n".join(report))
if missing:
    print("\nWARN — skipped:")
    print("\n".join("  " + m for m in missing))
PY
