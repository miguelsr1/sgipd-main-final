package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteCapacitacion;
import sv.gob.mined.projects.sgipd.repositories.DocenteCapacitacionRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteCapacitacionWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(DocenteCapacitacionWriter.class);
    @Inject
    DocenteCapacitacionRepository docenteCapacitacionRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocenteCapacitacion> capacitaciones = (List<DocenteCapacitacion>) item;
            docenteCapacitacionRepository.mergeList(capacitaciones);
        });
    }
}
