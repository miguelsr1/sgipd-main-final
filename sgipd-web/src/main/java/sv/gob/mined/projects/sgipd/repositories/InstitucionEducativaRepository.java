package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.Especialidad;
import sv.gob.mined.projects.sgipd.entities.InstitucionEducativa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class InstitucionEducativaRepository extends GenericRepository<InstitucionEducativa> {

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstitucionEducativaRepository() {
        super(InstitucionEducativa.class);
    }

    public InstitucionEducativa findByNombre(String nombre){
        List<InstitucionEducativa> espe = getEntityManager()
                .createNamedQuery("InstitucionEducativa.findByNombre")
                .setParameter("nombre",nombre)
                .getResultList();
        if(espe.isEmpty()){
            return null;
        }else {
            return espe.get(0);
        }
    }

}
