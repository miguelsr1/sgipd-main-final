package sv.gob.mined.projects.sgipd.jobs.steps.criterios;

import org.jboss.logging.Logger;

import javax.batch.api.chunk.listener.AbstractItemWriteListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class Criterio4bListener extends AbstractItemWriteListener {
    private static Logger LOG = Logger.getLogger(Criterio4bListener.class);
    @Inject
    private JobContext jobContext;

    @Override
    public void afterWrite(List<Object> items) throws Exception {
        LOG.info("Persisting " + items.size() + " Crtiterio4b");
    }

    @Override
    public void beforeWrite(List<Object> items) throws Exception {
        LOG.info("Preparing to persist " + items.size() + " Crtiterio4b");
    }

    // Write a custom Exit status
    @Override
    public void onWriteError(List<Object> items, Exception ex) throws Exception {
        LOG.info("Exception detected. Setting exit status");
        jobContext.setExitStatus("Error : " + ex.getMessage());
    }
}
