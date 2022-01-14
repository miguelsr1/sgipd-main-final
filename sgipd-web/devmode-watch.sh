#!/usr/bin/env bash

export APP_HOME=$(dirname $(realpath $0))
echo "Current Directory $APP_HOME"

export GC_MAX_METASPACE_SIZE=1024
export GC_METASPACE_SIZE=384
export MAVEN_OPTS="-Xms2G -Xmx4G -XX:MetaspaceSize=384M -XX:MaxMetaspaceSize=1024m -Djava.net.preferIPv4Stack=true"
export MAVEN_OPTS="$MAVEN_OPTS -Djava.awt.headless=true -XX:+CompactStrings"
echo "$MAVEN_OPTS"

$APP_HOME/mvnw wildfly-jar:dev-watch
