package sv.gob.mined.projects.sgipd.jobs.steps.sigob;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocentesNoplaza;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.repositories.DocenteNoPlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class SIGOBSOLReprobadosReader extends AbstractItemReader {
    private static Logger LOG = Logger.getLogger(SIGOBSOLReprobadosReader.class);
    @Inject
    JobContext jobContext;

    @Inject
    DocenteNoPlazaRepository docenteNoPlazaRepository;

    private List<DocentesNoplaza> data;
    private Integer count;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        data = docenteNoPlazaRepository.findAll();
        LOG.info("Top 10 Plaza Reader Found: "+data.size()+" items!");
        count = 0;
    }

    @Override
    public DocentesNoplaza readItem() throws Exception {
        if (count >= data.size()) {
            return null;
        }
        jobContext.setTransientUserData(count);
        LOG.info("Docente Plaza Final Read Item: index: "+count);
        return data.get(count++);
    }
}
