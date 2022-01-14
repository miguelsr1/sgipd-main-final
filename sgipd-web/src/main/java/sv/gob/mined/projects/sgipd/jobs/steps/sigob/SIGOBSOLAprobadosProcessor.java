package sv.gob.mined.projects.sgipd.jobs.steps.sigob;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.entities.Plaza;
import sv.gob.mined.projects.sgipd.entities.PlazasAprobada;
import sv.gob.mined.projects.sgipd.repositories.DocentePlazaRepository;
import sv.gob.mined.projects.sgipd.repositories.PlazasAprobadaRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Dependent
public class SIGOBSOLAprobadosProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(SIGOBSOLAprobadosProcessor.class);
    @Inject
    PlazasAprobadaRepository plazasAprobadaRepository;

    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public PlazasAprobada processItem(Object o) throws Exception {
        DocentesPlaza dp = (DocentesPlaza) o;
        LOG.info("Processing Plaza  idSecuencial: " + dp.getIdSecuencialPlaza() + " idSigobsolUsuario: "+dp.getIdSigobsolUsuario());
        return plazasAprobadaRepository.fromDocentesPlaza_2_PlazasAprobada(dp,currentUser);
    }
}
