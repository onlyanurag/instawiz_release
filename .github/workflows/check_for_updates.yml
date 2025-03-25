#!/bin/bash

# Check for the latest Instagram alpha version on APKMirror
latest_version=$(curl -s https://www.apkmirror.com/apk/instagram-alpha/ | grep -oP 'href="/apk/instagram-alpha/[^"]+/' | head -n 1)

# Get the current version from the repository
current_version=$(cat current_version.txt)

if [ "$latest_version" != "$current_version" ]; then
  echo "New version found: $latest_version"
  echo "$latest_version" > current_version.txt
  ./scripts/download_and_extract_apk.sh "$latest_version"
  git add .
  git commit -m "Update to Instagram alpha $latest_version"
  git push origin main
else
  echo "No new version found."
fi
