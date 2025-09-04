#!/bin/bash
set -euo pipefail

# bump_sdk.sh — detect latest stable Android SDK and update gradle.properties

LATEST=$(sdkmanager --list | grep "platforms;android-" | tail -n 1 | sed 's/.*-//')

if [ -z "$LATEST" ]; then
  echo "❌ Could not detect latest SDK."
  exit 1
fi

echo "➡️ Latest detected SDK: $LATEST"

# Update gradle.properties in place
sed -i "s/android.targetSdk=.*/android.targetSdk=$LATEST/" gradle.properties
sed -i "s/android.compileSdk=.*/android.compileSdk=$LATEST/" gradle.properties

echo "✅ gradle.properties updated to target/compileSdk=$LATEST"