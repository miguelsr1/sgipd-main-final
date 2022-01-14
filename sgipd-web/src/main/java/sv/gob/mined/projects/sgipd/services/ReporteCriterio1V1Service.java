package sv.gob.mined.projects.sgipd.services;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio1V1;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio2V2;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;
import sv.gob.mined.projects.sgipd.services.enums.Criterio1ServiceEnum;
import sv.gob.mined.projects.sgipd.services.enums.Criterio2ServiceEnum;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ReporteCriterio1V1Service {
    private static Logger logger = Logger.getLogger(ReporteCriterio1V1Service.class);
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    public static Logger getLogger() {
        return logger;
    }

    public List<ReporteCriterio1V1> findByDepartamento(Long idDepartamento) {
        return  getEntityManager()
                .createNamedQuery("ReporteCriterio1V1.findByDepartamento")
                .setParameter("idDepartamento",idDepartamento).getResultList();
    }

    public List<ReporteCriterio1V1> findByMunicipio(Long idMunicipio) {
        return  getEntityManager()
                .createNamedQuery("ReporteCriterio1V1.findByMunicipio")
                .setParameter("idMunicipio",idMunicipio).getResultList();
    }

    public List<ReporteCriterio1V1> findByCentroEducativo(Long codInfra) {
        return  getEntityManager()
                .createNamedQuery("ReporteCriterio1V1.findByCentroEducativo")
                .setParameter("codInfra",codInfra).getResultList();
    }

    @Transactional
    public List<ReporteCriterio1V1> findByCriteriaReporteCriterio1V1(
            Criterio1ServiceEnum criteria, Long id) {
        List<ReporteCriterio1V1> out = new ArrayList<>();

        try {
            Method method = this.getClass().getMethod(criteria.toString(), Long.class);
            out = (List<ReporteCriterio1V1>) method.invoke(this, id);
        } catch (Exception ex) {
            getLogger().error("Error calling method: findByCriteriaReporteCriterio1V1: ", ex);
        }
        return out;
    }
}
