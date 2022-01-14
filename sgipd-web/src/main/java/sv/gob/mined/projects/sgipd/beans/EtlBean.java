package sv.gob.mined.projects.sgipd.beans;

import org.keycloak.representations.AccessToken;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Named
@ViewScoped
public class EtlBean extends XBaseBean{
    public static final String NUEVOS_EXPEDIENTES = "etl";

    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }
    @Override
    @PostConstruct
    public void init() {

    }

    public void etl() {
        Map<String, Object> out = new HashMap<>();
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobParameters = new Properties();
        jobParameters.setProperty("currentUser", getCurrentUser());
        long execID = jobOperator.start(NUEVOS_EXPEDIENTES, jobParameters);
        out.put("JOBFile", NUEVOS_EXPEDIENTES);
        out.put("JOBExecID", execID);
        out.put("JOBMethod", "etl");
        out.put("JOBExecutor", getCurrentUser());
        addMessage("Se ejecuto el job",out.toString());
    }


}
