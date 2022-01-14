package sv.gob.mined.projects.sgipd.services;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.fakeentities.TramiteAplicacionDocente;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TramiteAplicacionDocenteService {
    private static Logger logger = Logger.getLogger(TramiteAplicacionDocenteService.class);
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    public static Logger getLogger() {
        return logger;
    }

    public List<TramiteAplicacionDocente> docentesQueHicieronPruebaPsicometrica(){
        return getEntityManager()
                .createNamedQuery("TramiteAplicacionDocente.docentesQueHicieronPruebaPsicometrica")
                .getResultList();
    }
}
