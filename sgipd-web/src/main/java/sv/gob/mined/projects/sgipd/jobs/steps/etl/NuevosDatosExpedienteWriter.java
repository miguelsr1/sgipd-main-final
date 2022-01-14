package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class NuevosDatosExpedienteWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(NuevosDatosExpedienteWriter.class);
    @Inject
    DocenteRepository docenteRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().map(Docente.class::cast).forEach(docenteRepository::merge);
    }
}
