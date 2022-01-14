# sgipd-main
SGIPD (WildFly Bootable JAR)

## Building the project

* Clone this repository project.
* Do: `mvn clean install -DskipTests`

## Running the project

* Do: `cd tcd-web`
* Run: `pack-run.sh` or `pack-run.bat`


## Development mode (watch of your source files)
* Do: `cd tcd-web`
* mvn wildfly-jar:dev-watch (this goal builds your application, build an hollow bootable JAR and start it)
* Do changes in your sources, your application is rebuilt and redeployed.
* When done: Ctrl-C in the console to kill the running goal and bootable JAR.



## Developer Mode  (with re-packaging)
* Do: `cd tcd-web`
* Start devmode: `devmode-start.sh` or `devmode-start.bat`
* Make some code changes
* Publish changes: `devmode-publish.sh` or `devmode-publish.bat`
* Stop devmode: `devmode-stop.sh` or `devmode-stop.bat`
* Access devmode logs: `devmode-logs.sh` or `devmode-logs.bat`
