package sv.gob.mined.projects.sgipd.services;

import sv.gob.mined.projects.sgipd.fakeentities.RDPPsicometrica;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ReporteDocentesPruebaPsicometricaService {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<RDPPsicometrica> findAll(){
        return getEntityManager()
                .createNamedQuery("RDPPsicometrica.findAll")
                .getResultList();
    }
}
