@echo on

@FOR /f "delims=" %%i in ('chdir') DO set APP_HOME=%%i
echo "Current Directory %APP_HOME%"

call %APP_HOME%\package.bat
call %APP_HOME%\run.bat