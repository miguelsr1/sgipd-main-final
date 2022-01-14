@echo on

java  -Xms2G -Xmx5G  -XX:+UseGCOverheadLimit  -jar target\sgipd-web-bootable.jar -bjboss.bind.address:0.0.0.0 
rem -Djboss.socket.binding.port-offset=903
