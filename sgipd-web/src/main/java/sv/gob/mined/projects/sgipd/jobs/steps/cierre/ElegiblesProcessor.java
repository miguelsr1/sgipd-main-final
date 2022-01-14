package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteResumenRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class ElegiblesProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(ElegiblesProcessor.class);
    @Inject
    DocenteRepository docenteRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public Docente processItem(Object o) throws Exception {
        VexpedienteDocentesE2Cv d = (VexpedienteDocentesE2Cv) o;
        LOG.info("Processing VexpedienteDocentesE2Cv : "+d.getCodigoDeSolicitante()+ " "+d.getNombreCompletoSegunRegistroPlataforma()+
                " NIP: "+d.getNip());
        return docenteRepository.fromVexpedienteDocentesE2Cv_2_Docente(d,currentUser);
    }
}
