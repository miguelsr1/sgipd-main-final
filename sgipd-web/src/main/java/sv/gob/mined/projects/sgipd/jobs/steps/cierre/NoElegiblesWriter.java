package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class NoElegiblesWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(NoElegiblesWriter.class);
    @Inject
    DocenteRepository docenteRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: DocenteResumen List "+items.size()+" Items!");
        items.stream().forEach(item ->{
            Docente docente = (Docente) item;
            docenteRepository.merge(docente);
        });
    }
}
