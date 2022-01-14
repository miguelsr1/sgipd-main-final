package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.entities.Plaza;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class ClasificadorPlazaProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(ClasificadorPlazaProcessor.class);
    @Inject
    DocenteResumenRepository docenteResumenRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocenteResumen> processItem(Object o) throws Exception {
        Plaza plaza = (Plaza) o;
        LOG.info("Processing Plaza  idSecuencial: " + plaza.getIdSecuencial() + " Especialidad: " + plaza.getEspecialidad()
        );
        return docenteResumenRepository.fromPlaza_2_DocenteResumenList(plaza, currentUser);
    }
}
