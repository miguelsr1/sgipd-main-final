#!/usr/bin/env bash
export CONTAINER_NAME=sgipd-mined-dev
export CONTAINER_IMAGE=sgipd-mined-dev-image

export APP_HOME=$(dirname $(realpath $0))

source $APP_HOME/build.sh

docker build --force-rm=true --no-cache=true  -t=$CONTAINER_IMAGE .