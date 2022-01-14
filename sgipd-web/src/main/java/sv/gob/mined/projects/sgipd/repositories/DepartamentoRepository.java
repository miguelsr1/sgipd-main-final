package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.DocenteAplicacion;
import sv.gob.mined.projects.sgipd.fakeentities.CalculateCriterio5;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DepartamentoRepository extends GenericRepository<Departamento> {

    public static final String NO_DEFINIDO = "No Definido";
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoRepository() {
        super(Departamento.class);
    }

    public List<Departamento> findAllDepartamentos() {
        return findAll().stream().filter(depto -> !depto.getNombre().equals(NO_DEFINIDO)).collect(Collectors.toList());
    }

    public List<Departamento> findAllNoFilter() {
        return findAll();
    }

    @Transactional
    public Boolean compararDepResidenciaDocenteWithDeptoPlaza(DocenteAplicacion aplicacion) {
        boolean result = Boolean.valueOf(false);
        long idDeptoResidencia = aplicacion.getDocente().getMunicipioBean().getDepartamento().getId();
        long idDeptoPlaza = aplicacion.getPlaza().getCentrosEducativo().getMunicipioBean().getDepartamento().getId();
        result = idDeptoResidencia == idDeptoPlaza;
        return result;
    }

    @Transactional
    public Boolean compararDepResidenciaDocenteWithDeptoPlaza(CalculateCriterio5 aplicacion) {
        boolean result = Boolean.valueOf(false);
        String idDeptoResidencia = aplicacion.getIdDepResidencia();
        String idDeptoPlaza = aplicacion.getIdDepPlaza();
        result = Boolean.valueOf(idDeptoResidencia.equals(idDeptoPlaza));
        getLogger().info("result: " + result);
        return result;
    }

}
