package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteExperiencia;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.repositories.DocenteExperienciaRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteExperienciaProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(DocenteExperienciaProcessor.class);
    @Inject
    DocenteExperienciaRepository docenteExperienciaRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocenteExperiencia> processItem(Object o) throws Exception {
        NuevosDatosExpediente p = (NuevosDatosExpediente) o;
        LOG.info("Processing: "+p.getCodigoDeTramite()+ " "+p.getNombreCompletoSegunRegistroPlataforma()+" NIP: "+p.getNip());
        return docenteExperienciaRepository.fromNuevosDatosExpediente_2_DocenteExperiencia(p,currentUser);
    }
}
