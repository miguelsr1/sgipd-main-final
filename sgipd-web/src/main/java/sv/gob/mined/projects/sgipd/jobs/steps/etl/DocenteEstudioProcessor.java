package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteEstudio;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.repositories.DocenteEstudioRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteEstudioProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(DocenteEstudioProcessor.class);
    @Inject
    DocenteEstudioRepository docenteEstudioRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocenteEstudio> processItem(Object o) throws Exception {
        NuevosDatosExpediente p = (NuevosDatosExpediente) o;
        LOG.info("Processing: "+p.getCodigoDeTramite()+ " "+p.getNombreCompletoSegunRegistroPlataforma()+" NIP: "+p.getNip());
        return docenteEstudioRepository.fromNuevosDatosExpediente_2_DocenteEstudio(p,currentUser);
    }
}
