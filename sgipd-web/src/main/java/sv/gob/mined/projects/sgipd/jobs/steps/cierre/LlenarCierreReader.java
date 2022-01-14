package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class LlenarCierreReader extends AbstractItemReader {
    private static Logger LOG = Logger.getLogger(LlenarCierreReader.class);
    @Inject
    JobContext jobContext;

    @Inject
    DocenteRepository docenteRepository;

    private List<Docente> data;
    private Integer count;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        data = docenteRepository.findAllNoRechazados();
        LOG.info("Llenar Cierre Reader Found: "+data.size()+" items!");
        count = 0;
    }

    @Override
    public Docente readItem() throws Exception {
        if (count >= data.size()) {
            return null;
        }
        jobContext.setTransientUserData(count);
        LOG.info("Llenar Cierre Read Item: index: "+count);
        return data.get(count++);
    }
}
