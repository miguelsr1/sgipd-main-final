package sv.gob.mined.projects.sgipd.services;

import sv.gob.mined.projects.sgipd.fakeentities.ReporteDocentesAplicaciones;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ReporteDocentesAplicacionesService {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<ReporteDocentesAplicaciones> findAll() {
        return getEntityManager().createNamedQuery("ReporteDocentesAplicaciones.findAll").getResultList();
    }

    public ReporteDocentesAplicaciones findById(Long idDePlazaVacante) {
        List<ReporteDocentesAplicaciones> list = getEntityManager()
                .createNamedQuery("ReporteDocentesAplicaciones.findById")
                .setParameter("idDePlazaVacante", idDePlazaVacante).getResultList();
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public List<ReporteDocentesAplicaciones> findByCodigoDeSolicitante(Long codigoDeSolicitante) {
        return getEntityManager()
                .createNamedQuery("ReporteDocentesAplicaciones.findByCodigoDeSolicitante")
                .setParameter("codigoDeSolicitante", codigoDeSolicitante).getResultList();
    }

    public List<ReporteDocentesAplicaciones> findByDepartamento(Long idDepartamento) {
        return getEntityManager()
                .createNamedQuery("ReporteDocentesAplicaciones.findByDepartamento")
                .setParameter("idDepartamento", idDepartamento).getResultList();
    }

}
