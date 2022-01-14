@echo on

@FOR /f "delims=" %%i in ('chdir') DO set APP_HOME=%%i
echo "Current Directory %APP_HOME%"

%APP_HOME%\mvnw wildfly-jar:shutdown