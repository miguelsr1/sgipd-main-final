package sv.gob.mined.projects.sgipd.services;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.fakeentities.CalculateCriterio5;
import sv.gob.mined.projects.sgipd.repositories.CalificacionRepository;
import sv.gob.mined.projects.sgipd.repositories.DocenteAplicacionRepository;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CalculateCriterio5Service {
    private static Logger logger = Logger.getLogger(CalculateCriterio5Service.class);
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    public static Logger getLogger() {
        return logger;
    }
    @Inject
    CalificacionRepository calificacionRepository;

    @Inject
    TramiteAplicacionDocenteService tramiteAplicacionDocenteService;

    @Inject
    DocenteAplicacionRepository docenteAplicacionRepository;

    public List<CalculateCriterio5> findAllCriterio1y2Aprobados(){
        return getEntityManager()
                .createNamedQuery("CalculateCriterio5.findAllCriterio1y2Aprobados")
                .getResultList();
    }

    public List<CalculateCriterio5> findAllCriterio1y2Aprobados(Integer pageSize,Integer from){
        return getEntityManager()
                .createNamedQuery("CalculateCriterio5.findAllCriterio1y2Aprobados")
                .setMaxResults(pageSize)
                .setFirstResult(from)
                .getResultList();
    }

    public BigDecimal getNotaResidenciaDocenteByIdTramiteAplic(Long idTramiteAplic){

        StoredProcedureQuery query = getEntityManager()
                .createStoredProcedureQuery("p_getNotaResidenciaDocenteByIdTramiteAplic")
                .registerStoredProcedureParameter(1, Long.class,
                        ParameterMode.IN)
                .registerStoredProcedureParameter(2, BigDecimal.class,
                        ParameterMode.OUT)
                .setParameter(1, idTramiteAplic);

        query.execute();

        BigDecimal nota = (BigDecimal) query.getOutputParameterValue(2);
        return nota;
    }




    public Map<String, Long> saveCriterio5ResidenciaDocente(String usuario){
        return calificacionRepository.saveCriterio5ResidenciaDocente(this.findAllCriterio1y2Aprobados(),usuario);
    }


    public Map<String, Long> saveCriterio5ResidenciaDocente(String usuario,Integer pageSize,Integer from){
        return calificacionRepository.saveCriterio5ResidenciaDocente(docenteAplicacionRepository.findMunicipiosAndDeptosResidencia(pageSize,from),usuario);
    }
}
