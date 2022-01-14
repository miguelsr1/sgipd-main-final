package sv.gob.mined.projects.sgipd.beans;

import org.keycloak.representations.AccessToken;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named
@ViewScoped
public class JobsBean extends XBaseBean {
    public static final String NUEVOS_EXPEDIENTES = "etl";

    List<SGIPDJobsEnum> jobs;

    private Integer jobId;

    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @Override
    @PostConstruct
    public void init() {
        this.jobs = new ArrayList<>();
        Arrays.stream(SGIPDJobsEnum.values()).forEach(c->jobs.add(c));
    }

    public void etl() {

        if (this.jobId != null) {

            Map<String, Object> out = new HashMap<>();
            JobOperator jobOperator = BatchRuntime.getJobOperator();
            Properties jobParameters = new Properties();
            jobParameters.setProperty("currentUser", getCurrentUser());
            String jobName = SGIPDJobsEnum.findById(this.jobId).getNombre();
            getLogger().info("Ejecutando JOB: "+jobName);
            long execID = jobOperator.start(jobName, jobParameters);
            out.put("JOBFile", jobName);
            out.put("JOBExecID", execID);
            out.put("JOBMethod", "etl");
            out.put("JOBExecutor", getCurrentUser());
            addMessage("Se ejecuto el job", out.toString());
        }else{
            addError("Error:","Seleccione un Job de la lista!");
        }

    }


    public List<SGIPDJobsEnum> getJobs() {
        return jobs;
    }

    public void setJobs(List<SGIPDJobsEnum> jobs) {
        this.jobs = jobs;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
