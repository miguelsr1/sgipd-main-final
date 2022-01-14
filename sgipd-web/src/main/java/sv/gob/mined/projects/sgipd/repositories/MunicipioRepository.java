package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.DocenteAplicacion;
import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.fakeentities.CalculateCriterio5;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MunicipioRepository extends GenericRepository<Municipio> {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioRepository() {
        super(Municipio.class);
    }

    public List<Municipio> findAllMunicipiosByDepartamento(long idDepartamento) {
        Map<String, Object> params = new HashMap<>();
        params.put("idDepartamento", idDepartamento);
        return executeNamedQueryResultList("Municipio.findAllMunicipiosByDepartamento", params);
    }

    @Transactional
    public Boolean compararMuniResidenciaDocenteWithMuniPlaza(DocenteAplicacion aplicacion) {
        boolean result = Boolean.valueOf(false);
        long idMuniResidencia = aplicacion.getDocente().getMunicipioBean().getId();
        long idMuniPlaza = aplicacion.getPlaza().getCentrosEducativo().getMunicipioBean().getId();
        result = idMuniResidencia == idMuniPlaza;
        return result;
    }

    @Transactional
    public Boolean compararMuniResidenciaDocenteWithMuniPlaza(CalculateCriterio5 aplicacion) {
        boolean result = Boolean.valueOf(false);
        String idMuniResidencia = aplicacion.getIdMuniResidencia();
        String idMuniPlaza = aplicacion.getIdMuniPlaza();
        result = Boolean.valueOf(idMuniResidencia.equals(idMuniPlaza));
        getLogger().info("result: " + result);
        return result;
    }

    @Transactional
    public Municipio findByNombreMuniAndNobreDepto(String nombreMuni, String nombreDepto){
        Municipio m = getEntityManager()
                .createNamedQuery("Municipio.findByNombreMuniAndNobreDepto",Municipio.class)
                .setParameter("nombreMuni",nombreMuni)
                .setParameter("nombreDepto",nombreDepto)
                .getSingleResult();
        if(m!=null){
            return m;
        }else{
            return this.find(Municipio.NO_DEFINIDO);
        }
    }


}
