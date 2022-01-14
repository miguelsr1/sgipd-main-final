package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Plaza;
import sv.gob.mined.projects.sgipd.repositories.PlazaRepository;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Dependent
public class Top10PlazaReader extends AbstractItemReader {
    private static Logger LOG = Logger.getLogger(Top10PlazaReader.class);
    @Inject
    JobContext jobContext;

    @Inject
    PlazaRepository plazaRepository;

    private List<Plaza> data;
    private Integer count;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        data = plazaRepository.findAll();
        LOG.info("Top 10 Plaza Reader Found: "+data.size()+" items!");
        count = 0;
    }

    @Override
    public Plaza readItem() throws Exception {
        if (count >= data.size()) {
            return null;
        }
        jobContext.setTransientUserData(count);
        LOG.info("Top 10 Plaza Read Item: index: "+count);
        return data.get(count++);
    }
}
