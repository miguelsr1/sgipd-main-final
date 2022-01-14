package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class VexpedienteDocentesE2CvRepository extends GenericRepositorySigobsol<VexpedienteDocentesE2Cv>{

    @PersistenceContext(unitName = GenericRepositorySigobsol.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VexpedienteDocentesE2CvRepository(){
        super(VexpedienteDocentesE2Cv.class);
    }

    public List<VexpedienteDocentesE2Cv> findAllWithExceptions(){
        return getEntityManager()
                .createNamedQuery("VexpedienteDocentesE2Cv.findAllWithExceptions")
                .getResultList();
    }

}
