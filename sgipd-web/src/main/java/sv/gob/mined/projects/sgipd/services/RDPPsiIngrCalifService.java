package sv.gob.mined.projects.sgipd.services;

import sv.gob.mined.projects.sgipd.fakeentities.RDPPsiIngrCalif;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RDPPsiIngrCalifService {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<RDPPsiIngrCalif> findAll(){
        return getEntityManager()
                .createNamedQuery("RDPPsiIngrCalif.findAll")
                .getResultList();
    }

    public List<RDPPsiIngrCalif> readTableCalificacionFileV1_RDPPsiIngrCalif(){
        return getEntityManager()
                .createNamedQuery("RDPPsiIngrCalif.fromCARGA_SIGOB_PSICOMETRICA_PLAZAS_DOCENTES")
                .getResultList();
    }

    public List<RDPPsiIngrCalif> readTableCalificacionFileV1_RDPPsiIngrCalif(Integer pageSize,Integer from){
        return getEntityManager()
                .createNamedQuery("RDPPsiIngrCalif.fromCARGA_SIGOB_PSICOMETRICA_PLAZAS_DOCENTES")
                .setMaxResults(pageSize)
                .setFirstResult(from)
               // .setLockMode(LockModeType.OPTIMISTIC)
                .getResultList();
    }

    public List<RDPPsiIngrCalif> readTableCalificacionFileV1_RDPPsiIngrCalif(String nip){
        return getEntityManager()
                .createNamedQuery("RDPPsiIngrCalif.fromCARGA_SIGOB_PSICOMETRICA_PLAZAS_DOCENTES_ByNip")
                .setParameter("nip",nip)
                .getResultList();
    }
}
