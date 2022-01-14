package sv.gob.mined.projects.sgipd.jobs.steps.sigob;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.entities.PlazasAprobada;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.PlazasAprobadaRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class SIGOBSOLAprobadosWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(SIGOBSOLAprobadosWriter.class);
    @Inject
    PlazasAprobadaRepository plazasAprobadaRepository;

    private Boolean hasCheckPoint;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: PlazasAprobada Object "+items.size()+" Items!");
        items.stream().forEach(item ->{
            PlazasAprobada pa = (PlazasAprobada) item;
            plazasAprobadaRepository.merge(pa);
        });
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        if (checkpoint == null) {
            LOG.info("No checkpoint detected. Cleaning table DocentesPlaza");
            plazasAprobadaRepository.makeBackup();
            int result = plazasAprobadaRepository.deleteAll();
            LOG.info("result: "+result+" deleted!");
            hasCheckPoint = true;
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return hasCheckPoint;
    }
}
