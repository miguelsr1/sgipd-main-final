package sv.gob.mined.projects.sgipd.jobs.steps.criterios;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Calificacion;
import sv.gob.mined.projects.sgipd.repositories.CalificacionRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class Criterio3aWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(Criterio3aWriter.class);
    @Inject
    CalificacionRepository calificacionRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<Calificacion> calificaciones = (List<Calificacion>) item;
            calificacionRepository.mergeList(calificaciones);
        });
    }
}
