#!/bin/bash
export KAPP_HOME=$(dirname $(realpath $0))
export JAR_NAME=$KAPP_HOME/target/sgipd-web-bootable.jar
export DEST_NAME=w.jar
export TODAY=$(date +"%d-%m-%Y-%H-%M-%S")
export WF_DIR=/opt/wildfly
export WF_USER=wildfly


git pull
./mvnw clean
./package.sh
sudo systemctl stop wildfly.service

sudo mv ${WF_DIR}/${DEST_NAME} ${WF_DIR}/w-${TODAY}.bkp
sudo cp ${JAR_NAME} ${WF_DIR}/${DEST_NAME}
sudo chown "${WF_USER}:"  ${WF_DIR}/${DEST_NAME}
sudo systemctl start wildfly.service

sleep 25

./showLogs.sh

