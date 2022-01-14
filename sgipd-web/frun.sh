#!/usr/bin/env bash
export CONTAINER_NAME=sgipd-mined-dev
export CONTAINER_IMAGE=sgipd-mined-dev-image

export APP_HOME=$(dirname $(realpath $0))

docker run --restart unless-stopped  -d -p 8983:8080 -p 8444:8443 --name=$CONTAINER_NAME $CONTAINER_IMAGE
