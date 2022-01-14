#!/usr/bin/env bash

export APP_HOME=$(dirname $(realpath $0))

tail -f $APP_HOME/target/wildfly-jar-dev-stdout.log