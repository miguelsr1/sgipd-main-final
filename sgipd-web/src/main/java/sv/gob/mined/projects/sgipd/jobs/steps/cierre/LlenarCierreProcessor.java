package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class LlenarCierreProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(LlenarCierreProcessor.class);
    @Inject
    DocenteResumenRepository docenteResumenRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocenteResumen> processItem(Object o) throws Exception {
        Docente d = (Docente) o;
        LOG.info("Processing Docente Resumen: "+d.getIdSigobsolUsuario()+ " "+d.getNombreCompleto()+" NIP: "+d.getNip());
        return docenteResumenRepository.fromDocente_2_DocenteResumenList(d,currentUser);
    }
}
