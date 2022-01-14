package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class NuevosDatosExpedienteProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(NuevosDatosExpedienteProcessor.class);
    @Inject
    DocenteRepository docenteRepository;

    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public Docente processItem(Object o) throws Exception {
        NuevosDatosExpediente p = (NuevosDatosExpediente) o;
        LOG.info("Processing: "+p.getCodigoDeTramite()+ " "+p.getNombreCompletoSegunRegistroPlataforma()+" NIP: "+p.getNip());
        return docenteRepository.fromNuevosDatosExpediente_2_Docente(p,currentUser);
    }
}
