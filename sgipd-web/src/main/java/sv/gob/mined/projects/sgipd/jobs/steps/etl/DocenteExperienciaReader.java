package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.repositories.NuevosDatosExpedienteRepository;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class DocenteExperienciaReader extends AbstractItemReader {
    private static Logger LOG = Logger.getLogger(DocenteExperienciaReader.class);
    @Inject
    JobContext jobContext;

    @Inject
    NuevosDatosExpedienteRepository nuevosDatosExpedienteRepository;

    private List<NuevosDatosExpediente> data;
    private Integer count;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        data = nuevosDatosExpedienteRepository.findAll();
        LOG.info("Reader Found: "+data.size()+" items!");
        count = 0;
    }

    @Override
    public NuevosDatosExpediente readItem() throws Exception {
        if (count >= data.size()) {
            return null;
        }
        jobContext.setTransientUserData(count);
        LOG.info("Read Item: index: "+count);
        return data.get(count++);
    }
}
