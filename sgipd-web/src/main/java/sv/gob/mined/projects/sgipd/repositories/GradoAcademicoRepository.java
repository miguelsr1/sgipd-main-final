package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.Especialidad;
import sv.gob.mined.projects.sgipd.entities.GradoAcademico;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class GradoAcademicoRepository extends GenericRepository<GradoAcademico> {

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradoAcademicoRepository() {
        super(GradoAcademico.class);
    }

    public GradoAcademico findByNombre(String nombre){
        List<GradoAcademico> espe = getEntityManager()
                .createNamedQuery("GradoAcademico.findByNombre")
                .setParameter("nombre",nombre)
                .getResultList();
        if(espe.isEmpty()){
            return null;
        }else {
            return espe.get(0);
        }
    }

}
