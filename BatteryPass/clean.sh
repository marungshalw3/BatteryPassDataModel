#!/usr/bin/env bash
#
# clean.sh — recursively delete every generated `gen/` folder under a root.
#
# The `gen/` folders hold SAMM-generated artifacts (see convert.sh); they are
# fully reproducible from the `.ttl` sources, so they are safe to remove.
# `genold/` backup folders are NEVER touched.
#
# Usage:
#   ./clean.sh [ROOT_DIR] [-n|--dry-run]
#
#   ROOT_DIR    Directory searched recursively (default: script's own folder).
#   -n, --dry-run   List what would be removed without deleting.
#
# Examples:
#   ./clean.sh                       # remove all gen/ under BatteryPass/
#   ./clean.sh -n                    # preview only
#   ./clean.sh io.BatteryPass.Labels # only under one aspect
#
set -uo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Parse args (ROOT and/or dry-run flag, in any order)
ROOT="$SCRIPT_DIR"
DRY=0
for a in "$@"; do
  case "$a" in
    -n|--dry-run) DRY=1 ;;
    -h|--help) sed -n '2,18p' "$0" | sed 's/^# \{0,1\}//'; exit 0 ;;
    -*) echo "Unknown option: $a" >&2; exit 2 ;;
    *)  ROOT="$a" ;;
  esac
done

[[ -d "$ROOT" ]] || { echo "ERROR: root dir '$ROOT' does not exist"; exit 1; }

# Collect gen/ dirs (excluding any nested under genold/)
DIRS=()
while IFS= read -r -d '' d; do DIRS+=("$d"); done \
  < <(find "$ROOT" -type d -name gen -not -path '*/genold/*' -print0 | sort -z)

if [[ ${#DIRS[@]} -eq 0 ]]; then
  echo "No gen/ folders found under $ROOT"
  exit 0
fi

echo "Found ${#DIRS[@]} gen/ folder(s) under $ROOT"
[[ $DRY -eq 1 ]] && echo "(dry run — nothing will be deleted)"
echo

removed=0
for d in "${DIRS[@]}"; do
  if [[ $DRY -eq 1 ]]; then
    echo "   would remove  $d"
  else
    rm -rf "$d" && { echo "   removed  $d"; removed=$((removed+1)); } \
                || echo "   FAILED   $d"
  fi
done

echo
if [[ $DRY -eq 1 ]]; then
  echo "Dry run: ${#DIRS[@]} folder(s) would be removed."
else
  echo "Done. Removed $removed of ${#DIRS[@]} gen/ folder(s)."
fi
