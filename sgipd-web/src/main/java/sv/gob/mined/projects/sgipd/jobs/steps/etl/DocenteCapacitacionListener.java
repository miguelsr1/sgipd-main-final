package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;

import javax.batch.api.chunk.listener.AbstractItemWriteListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteCapacitacionListener extends AbstractItemWriteListener {
    private static Logger LOG = Logger.getLogger(DocenteCapacitacionListener.class);
    @Inject
    private JobContext jobContext;

    @Override
    public void afterWrite(List<Object> items) throws Exception {
        LOG.info("Persisting " + items.size() + " DocenteCapacitacion");
    }

    @Override
    public void beforeWrite(List<Object> items) throws Exception {
        LOG.info("Preparing to persist " + items.size() + " DocenteCapacitacion");
    }

    // Write a custom Exit status
    @Override
    public void onWriteError(List<Object> items, Exception ex) throws Exception {
        LOG.info("Exception detected. Setting exit status");
        jobContext.setExitStatus("Error : " + ex.getMessage());
    }
}
