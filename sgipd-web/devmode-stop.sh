#!/usr/bin/env bash

export APP_HOME=$(dirname $(realpath $0))

$APP_HOME/mvnw wildfly-jar:shutdown