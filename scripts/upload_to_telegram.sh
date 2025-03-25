#!/bin/bash

# Upload the new APK to Telegram using a bot
# Replace with your bot token and chat ID
BOT_TOKEN="YOUR_BOT_TOKEN"
CHAT_ID="YOUR_CHAT_ID"
APK_PATH="app/build/outputs/apk/release/app-release.apk"

curl -F document=@"$APK_PATH" "https://api.telegram.org/bot${BOT_TOKEN}/sendDocument?chat_id=${CHAT_ID}&caption=New Instagram alpha release"
