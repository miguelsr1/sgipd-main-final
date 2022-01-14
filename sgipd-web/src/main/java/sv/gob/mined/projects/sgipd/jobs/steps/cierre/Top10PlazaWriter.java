package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class Top10PlazaWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(Top10PlazaWriter.class);
    @Inject
    DocentePlazaRepository docentePlazaRepository;

    private Boolean hasCheckPoint;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: DocentePlaza List "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocentesPlaza> dpList = (List<DocentesPlaza>) item;
            docentePlazaRepository.mergeList(dpList);
        });
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        if (checkpoint == null) {
            LOG.info("No checkpoint detected. Cleaning table DocentesPlaza");
            docentePlazaRepository.makeBackup();
            int result = docentePlazaRepository.deleteAll();
            LOG.info("result: "+result+" deleted!");
            hasCheckPoint = true;
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return hasCheckPoint;
    }
}
