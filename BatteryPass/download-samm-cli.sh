#!/usr/bin/env bash
#
# download-samm-cli.sh — fetch the Eclipse ESMF SAMM CLI jar into this folder.
#
# The jar (~178 MB) is intentionally NOT committed to git. Run this once after
# cloning to install it locally so convert.sh / clean.sh can find it.
#
# Usage:
#   ./download-samm-cli.sh [VERSION]
#
#   VERSION   esmf-sdk release to fetch (default below). Example: 2.14.3
#
set -euo pipefail

VERSION="${1:-2.14.3}"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
DEST="$SCRIPT_DIR/samm-cli.jar"
URL="https://github.com/eclipse-esmf/esmf-sdk/releases/download/v${VERSION}/samm-cli-${VERSION}.jar"

if [[ -f "$DEST" ]]; then
  echo "samm-cli.jar already present at $DEST"
  echo "Delete it first to re-download, or pass a version to overwrite."
  exit 0
fi

echo "Downloading SAMM CLI v${VERSION} ..."
echo "  from $URL"
curl -fL --progress-bar -o "$DEST" "$URL"

# Sanity check: must be a real jar (zip archive), not an HTML error page.
if ! unzip -l "$DEST" >/dev/null 2>&1 && ! file "$DEST" | grep -qi 'archive\|jar'; then
  echo "ERROR: downloaded file is not a valid jar — removing." >&2
  rm -f "$DEST"
  exit 1
fi

echo "Done → $DEST ($(du -h "$DEST" | cut -f1))"
echo "Verify with: \"\$(/usr/libexec/java_home)/bin/java\" -jar \"$DEST\" --version"
