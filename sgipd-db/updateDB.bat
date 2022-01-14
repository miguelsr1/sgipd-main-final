@echo on

@FOR /f "delims=" %%i in ('chdir') DO set APP_HOME=%%i
echo "Current Directory %APP_HOME%"

set JAVA_OPTS="-Dfile.encoding=UTF-8"

%APP_HOME%\mvnw liquibase:update
