#!/bin/bash
mvn clean install
cd target
dx --dex --output=classes.dex extension-0.0.1-SNAPSHOT.jar
jar cvf extension.jar classes.dex
adb push extension.jar sdcard/
adb shell am instrument -e main_activity 'io.selendroid.testapp.HomeScreenActivity' io.selendroid/.ServerInstrumentation
adb forward tcp:4444 tcp:8080
cd ..
