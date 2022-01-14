#!/usr/bin/env bash

export APP_HOME=$(dirname $(realpath $0))

$APP_HOME/package.sh
$APP_HOME/run.sh