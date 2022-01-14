@echo on

@FOR /f "delims=" %%i in ('chdir') DO set APP_HOME=%%i
echo "Current Directory %APP_HOME%"

type %APP_HOME%\target\wildfly-jar-dev-stdout.log