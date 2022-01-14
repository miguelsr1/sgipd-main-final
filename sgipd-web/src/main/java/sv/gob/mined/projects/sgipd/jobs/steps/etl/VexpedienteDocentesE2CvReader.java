package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;
import sv.gob.mined.projects.sgipd.repositories.VexpedienteDocentesE2CvRepository;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class VexpedienteDocentesE2CvReader extends AbstractItemReader {
    private static Logger LOG = Logger.getLogger(VexpedienteDocentesE2CvReader.class);
    @Inject
    JobContext jobContext;

    @Inject
    VexpedienteDocentesE2CvRepository vexpedienteDocentesE2CvRepository;

    private List<VexpedienteDocentesE2Cv> data;
    private Integer count;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        data = vexpedienteDocentesE2CvRepository.findAll();
        LOG.info("Reader Found: "+data.size()+" items!");
        count = 0;
    }

    @Override
    public VexpedienteDocentesE2Cv readItem() throws Exception {
        if (count >= data.size()) {
            return null;
        }
        jobContext.setTransientUserData(count);
        LOG.info("Read Item: index: "+count);
        return data.get(count++);
    }
}
