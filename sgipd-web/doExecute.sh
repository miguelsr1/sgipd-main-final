#!/bin/bash

source ./package.sh

export GC_MAX_METASPACE_SIZE=256
export GC_METASPACE_SIZE=96


export JAVA_OPTS="-Xms2G -Xmx6G -XX:MetaspaceSize=192M -XX:MaxMetaspaceSize=512m -Djava.net.preferIPv4Stack=true"
export JAVA_OPTS="$JAVA_OPTS -Djava.awt.headless=true"
echo $JAVA_OPTS


java  $JAVA_OPTS  -jar target/sgipd-web-bootable.jar -bjboss.bind.address:0.0.0.0 -Djboss.socket.binding.port-offset=903
