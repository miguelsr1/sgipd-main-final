package sv.gob.mined.projects.sgipd.jobs.steps.sigob;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.PlazasAprobada;
import sv.gob.mined.projects.sgipd.entities.PlazasReprobada;
import sv.gob.mined.projects.sgipd.repositories.PlazasAprobadaRepository;
import sv.gob.mined.projects.sgipd.repositories.PlazasReprobadaRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class SIGOBSOLReprobadosWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(SIGOBSOLReprobadosWriter.class);
    @Inject
    PlazasReprobadaRepository plazasReprobadaRepository;

    private Boolean hasCheckPoint;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: PlazasReprobada Object "+items.size()+" Items!");
        items.stream().forEach(item ->{
            PlazasReprobada pa = (PlazasReprobada) item;
            plazasReprobadaRepository.merge(pa);
        });
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        if (checkpoint == null) {
            LOG.info("No checkpoint detected. Cleaning table DocentesPlaza");
            plazasReprobadaRepository.makeBackup();
            int result = plazasReprobadaRepository.deleteAll();
            LOG.info("result: "+result+" deleted!");
            hasCheckPoint = true;
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return hasCheckPoint;
    }
}
