package sv.gob.mined.projects.sgipd.jobs.steps.cierre;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.Docente;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;
import sv.gob.mined.projects.sgipd.repositories.DocenteRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class NoElegiblesProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(NoElegiblesProcessor.class);
    @Inject
    DocenteRepository docenteRepository;
    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public Docente processItem(Object o) throws Exception {
        Docente d = (Docente) o;
        LOG.info("Processing Docente no elegible : "+d.getIdSigobsolUsuario()+ " "+d.getNombreCompleto()+
                " NIP: "+d.getNip());
        return docenteRepository.fromDocente_2_Docente(d,currentUser);
    }
}
