package sv.gob.mined.projects.sgipd.jobs.steps.especiales;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.entities.DocentesRevint;
import sv.gob.mined.projects.sgipd.repositories.DocenteRevintRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Dependent
public class EncontrarCapacitacionesProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(EncontrarCapacitacionesProcessor.class);
    @Inject
    DocenteRevintRepository docenteRevintRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    @Transactional
    public List<DocentesRevint> processItem(Object o) throws Exception {
        Docente d = (Docente) o;
        LOG.info("Processing: ID SIGOBSOL "+d.getIdSigobsolUsuario());
        return docenteRevintRepository.fromDocente_2_DocenteRevintCapa(d,currentUser);
    }
}
