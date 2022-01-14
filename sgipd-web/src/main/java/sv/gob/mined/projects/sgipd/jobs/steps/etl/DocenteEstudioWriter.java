package sv.gob.mined.projects.sgipd.jobs.steps.etl;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteEstudio;
import sv.gob.mined.projects.sgipd.repositories.DocenteEstudioRepository;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class DocenteEstudioWriter extends AbstractItemWriter {
    private static Logger LOG = Logger.getLogger(DocenteEstudioWriter.class);
    @Inject
    DocenteEstudioRepository docenteEstudioRepository;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        LOG.info("Writing: "+items.size()+" Items!");
        items.stream().forEach(item ->{
            List<DocenteEstudio> estudios = (List<DocenteEstudio>) item;
            docenteEstudioRepository.mergeList(estudios);
        });
    }
}
