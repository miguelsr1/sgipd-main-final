#!/bin/bash

export JAVA_HOME=/opt/wildfly/jdk

export PATH=$JAVA_HOME/bin:$PATH

export GC_MAX_METASPACE_SIZE=256
export GC_METASPACE_SIZE=96
export JAVA_OPTS="-Xms4G -Xmx10G -XX:MetaspaceSize=384M -XX:MaxMetaspaceSize=1024m -Djava.net.preferIPv4Stack=true"
export JAVA_OPTS="$JAVA_OPTS -Djava.awt.headless=true -XX:+CompactStrings"
echo $JAVA_OPTS

FILENAME_TODAY=$(date +"%d_%m_%Y_%H_%M_%S")
SERVER_LOG=/opt/wildfly/server.log


if [ -f "$SERVER_LOG"  ]
then
    mv $SERVER_LOG $SERVER_LOG-${FILENAME_TODAY}
else
    echo "No log at the first time"
fi


$JAVA_HOME/bin/java  $JAVA_OPTS  -jar /opt/wildfly/w.jar -b=0.0.0.0 -Djboss.socket.binding.port-offset=903 --install-dir=/deployments/wildfly >> $SERVER_LOG



