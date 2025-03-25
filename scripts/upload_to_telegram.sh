#!/bin/bash

# Upload the new APK to Telegram using a bot
# Replace with your bot token and chat ID
BOT_TOKEN="7537145173:AAEMoB50_cxGnM-Ing_rRCAC7IFy0xfgwzU"
CHAT_ID="-1002552321923"
APK_PATH="app/build/outputs/apk/release/app-release.apk"

curl -F document=@"$APK_PATH" "https://api.telegram.org/bot${BOT_TOKEN}/sendDocument?chat_id=${CHAT_ID}&caption=New Instagram alpha release"
