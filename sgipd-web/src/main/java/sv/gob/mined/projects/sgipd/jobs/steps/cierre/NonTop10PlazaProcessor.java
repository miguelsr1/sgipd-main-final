package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocentesNoplaza;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.entities.Plaza;
import sv.gob.mined.projects.sgipd.repositories.DocenteNoPlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class NonTop10PlazaProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(NonTop10PlazaProcessor.class);
    @Inject
    DocenteNoPlazaRepository docenteNoPlazaRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocentesNoplaza> processItem(Object o) throws Exception {
        Plaza plaza = (Plaza) o;
        LOG.info("Processing Plaza  idSecuencial: " + plaza.getIdSecuencial() + " Especialidad: " + plaza.getEspecialidad());
        return docenteNoPlazaRepository.fromPlaza_2_DocenteNoplazaList(plaza, currentUser);
    }
}
