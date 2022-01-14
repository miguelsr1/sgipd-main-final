#!/bin/bash

java -jar ./target/sgipd-web-bootable.jar -bjboss.bind.address:0.0.0.0 -Djboss.socket.binding.port-offset=903
