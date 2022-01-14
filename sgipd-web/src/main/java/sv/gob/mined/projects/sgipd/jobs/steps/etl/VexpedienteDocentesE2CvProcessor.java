package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;
import sv.gob.mined.projects.sgipd.repositories.NuevosDatosExpedienteRepository;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class VexpedienteDocentesE2CvProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(VexpedienteDocentesE2CvProcessor.class);
    @Inject
    NuevosDatosExpedienteRepository nuevosDatosExpedienteRepository;

    @Override
    public NuevosDatosExpediente processItem(Object o) throws Exception {
        VexpedienteDocentesE2Cv p = (VexpedienteDocentesE2Cv) o;
        LOG.info("Processing: "+p.getCodigoDeTramite()+ " "+p.getNombreCompletoSegunRegistroPlataforma()+" NIP: "+p.getNip());
        return nuevosDatosExpedienteRepository.fromVexpedienteDocentesE2Cv_2_NuevosDatosExpediente(p);
    }
}
