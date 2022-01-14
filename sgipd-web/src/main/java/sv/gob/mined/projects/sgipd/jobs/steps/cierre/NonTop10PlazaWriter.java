package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocentesNoplaza;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.repositories.DocenteNoPlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class NonTop10PlazaWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(NonTop10PlazaWriter.class);
    @Inject
    DocenteNoPlazaRepository docenteNoPlazaRepository;

    private Boolean hasCheckPoint;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: DocenteNoplaza List "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocentesNoplaza> dpList = (List<DocentesNoplaza>) item;
            docenteNoPlazaRepository.mergeList(dpList);
        });
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        if (checkpoint == null) {
            LOG.info("No checkpoint detected. Cleaning table DocentesPlaza");
            docenteNoPlazaRepository.makeBackup();
            int result = docenteNoPlazaRepository.deleteAll();
            LOG.info("result: "+result+" deleted!");
            hasCheckPoint = true;
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return hasCheckPoint;
    }
}
