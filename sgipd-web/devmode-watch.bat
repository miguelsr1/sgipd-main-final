@echo on

@FOR /f "delims=" %%i in ('chdir') DO set APP_HOME=%%i
echo "Current Directory %APP_HOME%"

set GC_MAX_METASPACE_SIZE=1024
set GC_METASPACE_SIZE=384
set MAVEN_OPTS="-Xms4G -Xmx10G -XX:MetaspaceSize=384M -XX:MaxMetaspaceSize=1024m -Djava.net.preferIPv4Stack=true"
set MAVEN_OPTS="%MAVEN_OPTS% -Djava.awt.headless=true -XX:+CompactStrings"
echo %MAVEN_OPTS%

REM set "exceltemplates=C:/Users/xtecuan/Documents/MINED/SGIPD/codigo/sgipd-main/sgipd-web/exceltemplates/"
REM set "grade_folder=C:/Users/xtecuan/Documents/MINED/SGIPD/grades_xlsx/"
REM  set "grade_folder_filters=departamento,municipio,centroeducativo"
REM set "MSSQLSERVER_URL=jdbc:sqlserver://localhost:1433;databaseName=SGIDTPVD"
REM set "MSSQLSERVER_PASSWORD=jup1t3r*2021"
REM set "MSSQLSERVER_USER=JulianRivera"
REM set "MSSQLSERVER_DATASOURCE=java:jboss/datasources/sgipdDS"

%APP_HOME%\mvnw clean wildfly-jar:dev-watch