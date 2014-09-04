#!/bin/bash
mvn clean install
cd target
dx --dex --output=extension.dex extension-0.0.1-SNAPSHOT.jar
