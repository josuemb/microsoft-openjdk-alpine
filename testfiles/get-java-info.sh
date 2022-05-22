#!/bin/bash
TEST_FILE_NAME="GetJavaPropertiesAsJson.java"
TEST_FILE_URL="https://raw.githubusercontent.com/josuemb/microsoft-openjdk-alpine/main/testfiles/$TEST_FILE_NAME"
wget -q $TEST_FILE_URL -O $TEST_FILE_NAME
java $TEST_FILE_NAME