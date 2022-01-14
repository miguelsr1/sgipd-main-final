package sv.gob.mined.projects.sgipd.services;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio2;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;
import sv.gob.mined.projects.sgipd.services.enums.Criterio2ServiceEnum;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ReporteCriterio2Service {
    private static Logger logger = Logger.getLogger(ReporteCriterio2Service.class);
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    public static Logger getLogger() {
        return logger;
    }

    public List<ReporteCriterio2> findByDepartamento(Long idDepartamento) {
        return  getEntityManager()
                .createNamedQuery("ReporteCriterio2.findByDepartamento")
                .setParameter("idDepartamento",idDepartamento).getResultList();
    }

    public List<ReporteCriterio2> findByMunicipio(Long idMunicipio) {
        return  getEntityManager()
                .createNamedQuery("ReporteCriterio2.findByMunicipio")
                .setParameter("idMunicipio",idMunicipio).getResultList();
    }

    public List<ReporteCriterio2> findByCentroEducativo(Long codInfra) {
        return  getEntityManager()
                .createNamedQuery("ReporteCriterio2.findByCentroEducativo")
                .setParameter("codInfra",codInfra).getResultList();
    }

    @Transactional
    public List<ReporteCriterio2> findByCriteriaReporteCriterio2(
            Criterio2ServiceEnum criteria, Long id) {
        List<ReporteCriterio2> out = new ArrayList<>();

        try {
            Method method = this.getClass().getMethod(criteria.toString(), Long.class);
            out = (List<ReporteCriterio2>) method.invoke(this, id);
        } catch (Exception ex) {
            getLogger().error("Error calling method: findByCriteria: ", ex);
        }
        return out;
    }
}
