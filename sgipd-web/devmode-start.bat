@echo on

@FOR /f "delims=" %%i in ('chdir') DO set APP_HOME=%%i
echo "Current Directory %APP_HOME%"

set "JAVA_OPTS=-Xms2048m -Xmx4096m"

%APP_HOME%\mvnw wildfly-jar:dev
