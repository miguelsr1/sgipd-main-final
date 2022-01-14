## SGIPD WildFly JSF with CDI, JAX-RS, Microprofile-config and persistence bootable JAR project

This Project shows how to combine JSF, CDI, JAX-RS, Microprofile-config  and JPA. 

## Running the project
* Run: `pack-run.sh` or `pack-run.bat`


## Development mode (watch of your source files)
* Run: `devmode-watch.sh` or `devmode-watch.bat` (this goal builds your application, build an hollow bootable JAR and start it)
* Do changes in your sources, your application is rebuilt and redeployed.
* When done: Ctrl-C in the console to kill the running goal and bootable JAR.



## Developer Mode  (with re-packaging)
* Start devmode: `devmode-start.sh` or `devmode-start.bat`
* Make some code changes
* Publish changes: `devmode-publish.sh` or `devmode-publish.bat`
* Stop devmode: `devmode-stop.sh` or `devmode-stop.bat`
* Access devmode logs: `devmode-logs.sh` or `devmode-logs.bat`