package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.DocenteCapacitacion;
import sv.gob.mined.projects.sgipd.entities.Especialidad;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EspecialidadRepository extends GenericRepository<Especialidad> {

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialidadRepository() {
        super(Especialidad.class);
    }

    public Especialidad findByNombre(String nombre){
        List<Especialidad> espe = getEntityManager()
                .createNamedQuery("Especialidad.findByNombre")
                .setParameter("nombre",nombre)
                .getResultList();
        if(espe.isEmpty()){
            return null;
        }else {
            return espe.get(0);
        }
    }

}
