package sv.gob.mined.projects.sgipd.jobs.steps.especiales;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Calificacion;
import sv.gob.mined.projects.sgipd.entities.DocentesRevint;
import sv.gob.mined.projects.sgipd.repositories.CalificacionRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteRevintRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class EncontrarWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(EncontrarWriter.class);
    @Inject
    DocenteRevintRepository docenteRevintRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocentesRevint> revs = (List<DocentesRevint>) item;
            docenteRevintRepository.mergeList(revs);
        });
    }
}
