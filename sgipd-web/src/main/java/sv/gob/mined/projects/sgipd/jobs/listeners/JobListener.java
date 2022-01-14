package sv.gob.mined.projects.sgipd.jobs.listeners;

import org.jboss.logging.Logger;

import javax.batch.api.listener.AbstractJobListener;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Properties;


@Named("jobListener")
@Dependent
public class JobListener extends AbstractJobListener {

    private Logger log = Logger.getLogger(JobListener.class);

    @Inject
    private JobContext jobContext;

    @Override
    public void beforeJob() throws Exception {
        log.info(String.format("Job %s - Execution #%d starting.", jobContext.getJobName(), jobContext.getExecutionId()));
    }

    @Override
    public void afterJob() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobParameters = jobOperator.getParameters(jobContext.getExecutionId());
        //If the JOB was already restarted once, mark it as abandoned
        if (jobParameters.get("restartedOnce") != null && jobContext.getBatchStatus().equals(BatchStatus.FAILED)) {
            log.info("Job already restarted once! Abandoning it forever");
            jobOperator.abandon(jobContext.getExecutionId());
        }
        log.info(String.format("Job %s - Execution #%d finished. Status: %s", jobContext.getJobName(), jobContext.getExecutionId(), jobContext.getBatchStatus()));
    }
}
