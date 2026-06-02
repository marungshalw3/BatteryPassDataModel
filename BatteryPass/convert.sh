#!/usr/bin/env bash
#
# convert.sh — recursively find every *.ttl under a root and generate all
# SAMM artifacts for each, writing into a `gen/` folder beside the .ttl.
#
# Usage:
#   ./convert.sh [ROOT_DIR] [-- FORMAT ...]
#
#   ROOT_DIR   Directory to search recursively (default: script's own dir).
#   FORMAT...  Override the format list (default: all formats below).
#              Pass `--` with no formats to run openapi only.
#
# Examples:
#   ./convert.sh                            # everything under BatteryPass/
#   ./convert.sh io.BatteryPass.Labels      # one aspect (all its versions)
#   ./convert.sh . -- schema sql            # only JSON Schema + SQL, everywhere
#   ./convert.sh . --                       # only openapi, everywhere
#
# Env overrides: SAMM_JAR, JAVA, OPENAPI_BASE
#
set -uo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
# Find the jar: explicit SAMM_JAR, else next to the script, else one level up.
JAR="${SAMM_JAR:-}"
if [[ -z "$JAR" ]]; then
  for cand in "$SCRIPT_DIR/samm-cli.jar" "$SCRIPT_DIR/../samm-cli.jar"; do
    [[ -f "$cand" ]] && { JAR="$cand"; break; }
  done
fi
JAVA="${JAVA:-$(/usr/libexec/java_home 2>/dev/null)/bin/java}"
OPENAPI_BASE="${OPENAPI_BASE:-https://thebatterypass.io}"

# Parse args: ROOT then optional `-- fmt fmt ...`
ROOT="$SCRIPT_DIR"
FORMATS=(html java json jsonld png schema svg aas sql)
if [[ $# -gt 0 && "$1" != "--" ]]; then ROOT="$1"; shift; fi
if [[ "${1:-}" == "--" ]]; then shift; FORMATS=("$@"); fi

# Sanity checks
[[ -n "$JAR" && -f "$JAR" ]] || { echo "ERROR: samm jar not found (looked next to script / one level up; set SAMM_JAR=...)"; exit 1; }
[[ -x "$JAVA" ]]            || { echo "ERROR: java not found at '$JAVA' (install a JRE, or set JAVA=...)"; exit 1; }
[[ -d "$ROOT" ]]           || { echo "ERROR: root dir '$ROOT' does not exist"; exit 1; }

run_samm() { "$JAVA" -jar "$JAR" "$@" 2>/dev/null; }

total=0 ok=0 fail=0
TTLS=()
while IFS= read -r -d '' f; do TTLS+=("$f"); done \
  < <(find "$ROOT" -name '*.ttl' -not -path '*/gen/*' -not -path '*/genold/*' -print0 | sort -z)

echo "Found ${#TTLS[@]} .ttl file(s) under $ROOT"
echo "Formats: ${FORMATS[*]:-(none)} + openapi"
echo

for ttl in "${TTLS[@]}"; do
  dir="$(dirname "$ttl")"
  base="$(basename "${ttl%.ttl}")"
  out="$dir/gen"
  mkdir -p "$out"
  echo "▶ $ttl"
  # `${FORMATS[@]+...}` guards empty-array expansion under `set -u` (bash 3.2 safe).
  for fmt in ${FORMATS[@]+"${FORMATS[@]}"}; do
    total=$((total+1))
    if [[ "$fmt" == "java" ]]; then
      # `to java` emits a package tree, not a single file → use --output-directory
      cmd_ok=$(run_samm aspect "$ttl" to java --output-directory "$out/java" && echo y)
    else
      cmd_ok=$(run_samm aspect "$ttl" to "$fmt" -o "$out/$base.$fmt" && echo y)
    fi
    if [[ "$cmd_ok" == "y" ]]; then
      ok=$((ok+1));   echo "   ✓ $fmt"
    else
      fail=$((fail+1)); echo "   ✗ $fmt"
    fi
  done
  # openapi takes a base URL; -j/--json emits JSON (default would be YAML)
  total=$((total+1))
  if run_samm aspect "$ttl" to openapi --json -b "$OPENAPI_BASE" -o "$out/$base.openapi.json"; then
    ok=$((ok+1));   echo "   ✓ openapi"
  else
    fail=$((fail+1)); echo "   ✗ openapi"
  fi
done

echo
echo "Done. $ok ok, $fail failed (of $total) across ${#TTLS[@]} aspect file(s)."
[[ $fail -eq 0 ]]
