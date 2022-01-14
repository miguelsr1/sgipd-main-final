package sv.gob.mined.projects.sgipd.jobs.steps.sigob;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocentesNoplaza;
import sv.gob.mined.projects.sgipd.entities.DocentesPlaza;
import sv.gob.mined.projects.sgipd.entities.PlazasReprobada;
import sv.gob.mined.projects.sgipd.repositories.PlazasReprobadaRepository;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class SIGOBSOLReprobadosProcessor implements ItemProcessor {
    private static Logger LOG = Logger.getLogger(SIGOBSOLReprobadosProcessor.class);
    @Inject
    PlazasReprobadaRepository plazasReprobadaRepository;

    @Inject
    @BatchProperty
    private String currentUser;

    @Override
    public PlazasReprobada processItem(Object o) throws Exception {
        DocentesNoplaza dp = (DocentesNoplaza) o;
        LOG.info("Processing Plaza  idSecuencial: " + dp.getIdSecuencialPlaza() + " idSigobsolUsuario: "+dp.getIdSigobsolUsuario());
        return plazasReprobadaRepository.fromDocentesPlaza_2_PlazasReprobada(dp,currentUser);
    }
}
