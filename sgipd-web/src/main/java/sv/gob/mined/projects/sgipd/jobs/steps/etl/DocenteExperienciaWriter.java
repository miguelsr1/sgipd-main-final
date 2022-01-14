package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteExperiencia;
import sv.gob.mined.projects.sgipd.repositories.DocenteExperienciaRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteExperienciaWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(DocenteExperienciaWriter.class);
    @Inject
    DocenteExperienciaRepository docenteExperienciaRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocenteExperiencia> experiencias = (List<DocenteExperiencia>) item;
            docenteExperienciaRepository.mergeList(experiencias);
        });
    }
}
