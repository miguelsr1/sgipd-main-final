package sv.gob.mined.projects.sgipd.services;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.repositories.GenericRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;

@ApplicationScoped
public class Criterio4Service {
    private static Logger logger = Logger.getLogger(Criterio4Service.class);
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    public static Logger getLogger() {
        return logger;
    }

    /**
     * Obtener calificacion para el criterio 4a: Especialidad Docente
     * @param idTramiteAplic
     * @return
     */
    public BigDecimal getNotaEspecialidadByIdTramiteAplic(Long idTramiteAplic){
        StoredProcedureQuery query = getEntityManager()
                .createStoredProcedureQuery("p_getNotaEspecialidadByIdTramiteAplic")
                .registerStoredProcedureParameter(1, Long.class,
                        ParameterMode.IN)
                .registerStoredProcedureParameter(2, BigDecimal.class,
                        ParameterMode.OUT)
                .setParameter(1, idTramiteAplic);

        query.execute();

        BigDecimal nota = (BigDecimal) query.getOutputParameterValue(2);
        return nota;
    }

    /**
     * Obtener calificacion para el criterio 4b: Capacitaciones Docente
     * @param idSIGOBSOLUsuario
     * @return
     */
    public BigDecimal getNotaCapacitacionesByIdSIGOBSOLUsuario(Long idSIGOBSOLUsuario){
        StoredProcedureQuery query = getEntityManager()
                .createStoredProcedureQuery("p_getNotaCapacitacionesByIdSIGOBSOLUsuario")
                .registerStoredProcedureParameter(1, Long.class,
                        ParameterMode.IN)
                .registerStoredProcedureParameter(2, BigDecimal.class,
                        ParameterMode.OUT)
                .setParameter(1, idSIGOBSOLUsuario);

        query.execute();

        BigDecimal nota = (BigDecimal) query.getOutputParameterValue(2);
        return nota;
    }
}
