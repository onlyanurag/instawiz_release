# InstaWiz

InstaWiz is an Android app that automatically updates to the latest Instagram alpha version from APKMirror. This repository is structured to include automation for:

- Checking for new Instagram alpha releases.
- Downloading the latest APK and extracting necessary files.
- Updating the repository with the new version.
- Automatically building and releasing the latest APK using GitHub Actions.
- Uploading the new release to Telegram.

## Workflows

### Check for Updates
This workflow runs daily to check for new Instagram alpha releases on APKMirror. If a new version is found, it updates the repository and triggers the build and release workflow.

### Build and Release
This workflow builds the APK, creates a new release on GitHub, and uploads the APK to Telegram.

## Scripts

### `check_for_updates.sh`
This script checks for the latest Instagram alpha version on APKMirror and updates the repository if a new version is found.

### `download_and_extract_apk.sh`
This script downloads the latest Instagram alpha APK and extracts the necessary files.

### `upload_to_telegram.sh`
This script uploads the new APK to Telegram using a bot.

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/InstaWiz.git
   cd InstaWiz
   ```

2. Add your Telegram bot token and chat ID to `upload_to_telegram.sh`.

3. Push the changes to GitHub:
   ```bash
   git add .
   git commit -m "Initial commit"
   git push origin main
   ```

4. Enjoy the automated updates and releases!
