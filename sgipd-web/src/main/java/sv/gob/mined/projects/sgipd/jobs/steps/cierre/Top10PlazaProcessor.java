package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.entities.Plaza;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class Top10PlazaProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(Top10PlazaProcessor.class);
    @Inject
    DocentePlazaRepository docentePlazaRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public List<DocentesPlaza> processItem(Object o) throws Exception {
        Plaza plaza = (Plaza) o;
        LOG.info("Processing Plaza  idSecuencial: " + plaza.getIdSecuencial() + " Especialidad: " + plaza.getEspecialidad());
        return docentePlazaRepository.fromPlaza_2_DocentePlazaList(plaza, currentUser);
    }
}
