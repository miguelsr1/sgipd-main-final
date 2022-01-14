package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteCapacitacion;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.repositories.DocenteCapacitacionRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteCapacitacionProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(DocenteCapacitacionProcessor.class);
    @Inject
    DocenteCapacitacionRepository docenteCapacitacionRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocenteCapacitacion> processItem(Object o) throws Exception {
        NuevosDatosExpediente p = (NuevosDatosExpediente) o;
        LOG.info("Processing: "+p.getCodigoDeSolicitante()+ " "+p.getNombreCompletoSegunRegistroPlataforma()+" NIP: "+p.getNip());
        return docenteCapacitacionRepository.fromNuevosDatosExpediente_2_DocenteCapacitacion(p,currentUser);
    }
}
