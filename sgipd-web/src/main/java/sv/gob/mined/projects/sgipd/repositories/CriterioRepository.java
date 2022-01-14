package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.Criterio;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CriterioRepository extends GenericRepository<Criterio>{


    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CriterioRepository(){
        super(Criterio.class);
    }
}
