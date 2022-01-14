package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.repositories.NuevosDatosExpedienteRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class VexpedienteDocentesE2CvWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(VexpedienteDocentesE2CvWriter.class);
    @Inject
    NuevosDatosExpedienteRepository nuevosDatosExpedienteRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().map(NuevosDatosExpediente.class::cast).forEach(nuevosDatosExpedienteRepository::merge);
    }
}
