package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class ClasificadorPlazaWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(ClasificadorPlazaWriter.class);
    @Inject
    DocenteResumenRepository docenteResumenRepository;
    private Boolean hasCheckPoint;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: DocenteResumen List "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocenteResumen> drList = (List<DocenteResumen>) item;
            docenteResumenRepository.mergeList(drList);
        });
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        if (checkpoint == null) {
            LOG.info("No checkpoint detected. Cleaning the Position in table DocenteResumen");
            //entityManager.createQuery("DELETE FROM Contact c").executeUpdate();
            int result = docenteResumenRepository.updatePosicion();
            LOG.info("result: "+result+" updated!");
            hasCheckPoint = true;
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return hasCheckPoint;
    }
}
