package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.CentroEducativo;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CentroEducativoRepository extends GenericRepository<CentroEducativo>{
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroEducativoRepository(){
        super(CentroEducativo.class);
    }

    public List<CentroEducativo> findByMunicipio(long idMunicipio){
        Map<String, Object> params = new HashMap<>();
        params.put("idMunicipio",idMunicipio);
        return executeNamedQueryResultList("CentroEducativo.findByMunicipio",params);
    }
}
