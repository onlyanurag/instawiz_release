name: Check for Updates

on:
  schedule:
    - cron: '0 0 * * *'  # Runs every day at midnight
  push:
    branches:
      - main

jobs:
  check_for_updates:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Make scripts executable
        run: chmod +x scripts/*.sh

      - name: Run update check script
        run: ./scripts/check_for_updates.sh
