package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.dtos.IngresoCalificacionDTO;
import sv.gob.mined.projects.sgipd.entities.DocenteAplicacion;
import sv.gob.mined.projects.sgipd.fakeentities.CalculateCriterio5;
import sv.gob.mined.projects.sgipd.repositories.enums.DocenteAplicacionCriteriaEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.IngresoCalificacionEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.TipoPrueba;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DocenteAplicacionRepository extends GenericRepository<DocenteAplicacion> {

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public DocenteAplicacionRepository() {
        super(DocenteAplicacion.class);
    }

    public List<IngresoCalificacionDTO> findAllDTO(TipoPrueba tipoPrueba){
        List<IngresoCalificacionDTO> out = new ArrayList<>();
        this.findAll().stream().forEach(c->out.add(fromEntity2DTO(c,tipoPrueba)));
        return out;
    }

    public List<DocenteAplicacion> findByCentroEducativo(long codinfra) {
        Map<String, Object> params = new HashMap<>();
        params.put("codinfra", codinfra);
        return executeNamedQueryResultList("DocenteAplicacion.findByCentroEducativo", params);
    }

    @Transactional
    public List<IngresoCalificacionDTO> findByCentroEducativoDTO(long codinfra, TipoPrueba tipoPrueba) {
        List<IngresoCalificacionDTO> out = new ArrayList<>();
        this.findByCentroEducativo(codinfra).stream().forEach(c -> {
            out.add(fromEntity2DTO(c, tipoPrueba));
        });
        return out;
    }

    public List<DocenteAplicacion> findByMunicipio(long idMunicipio) {
        Map<String, Object> params = new HashMap<>();
        params.put("idMunicipio", idMunicipio);
        return executeNamedQueryResultList("DocenteAplicacion.findByMunicipio", params);
    }

    @Transactional
    public List<IngresoCalificacionDTO> findByMunicipioDTO(long idMunicipio, TipoPrueba tipoPrueba) {
        List<IngresoCalificacionDTO> out = new ArrayList<>();
        this.findByMunicipio(idMunicipio).stream().forEach(c -> {
            out.add(fromEntity2DTO(c, tipoPrueba));
        });
        return out;
    }

    public List<DocenteAplicacion> findByDepartamento(long idDepartamento) {
        Map<String, Object> params = new HashMap<>();
        params.put("idDepartamento", idDepartamento);
        return executeNamedQueryResultList("DocenteAplicacion.findByDepartamento", params);
    }

    @Transactional
    public List<IngresoCalificacionDTO> findByDepartamentoDTO(long idDepartamento, TipoPrueba tipoPrueba) {
        List<IngresoCalificacionDTO> out = new ArrayList<>();
        this.findByDepartamento(idDepartamento).stream().forEach(c -> {
            out.add(fromEntity2DTO(c, tipoPrueba));
        });
        return out;
    }

    public List<DocenteAplicacion> findByCriteria(DocenteAplicacionCriteriaEnum criteria, long id) {
        List<DocenteAplicacion> out = new ArrayList<>();
        try {
            Method method = this.getClass().getMethod(criteria.toString(), long.class);
            out = (List<DocenteAplicacion>) method.invoke(this, id);
        } catch (Exception ex) {
            getLogger().error("Error calling method: findByCriteria: ", ex);
        }
        return out;
    }

    @Transactional
    public List<IngresoCalificacionDTO> findByCriteriaDTO(IngresoCalificacionEnum criteria, long id, TipoPrueba tipoPrueba) {
        List<IngresoCalificacionDTO> out = new ArrayList<>();

        try {
            getLogger().info(criteria.toString());
            Method method = this.getClass().getMethod(criteria.toString(), long.class, TipoPrueba.class);
            out = (List<IngresoCalificacionDTO>) method.invoke(this, id, tipoPrueba);
        } catch (Exception ex) {
            getLogger().error("Error calling method: findByCriteria: ", ex);
        }
        return out;
    }

    @Transactional
    public IngresoCalificacionDTO fromEntity2DTO(DocenteAplicacion c, TipoPrueba tipoPrueba) {
        
        IngresoCalificacionDTO dto = new IngresoCalificacionDTO();
                
        dto.setDepartamento(c.getDocente().getDepartamento() );
        dto.setMunicipio(c.getDocente().getMunicipio());
        dto.setCodigoSolicitante(c.getDocente().getIdSigobsolUsuario());
        dto.setDui(c.getDocente().getDui() != null ? c.getDocente().getDui() : "");
        dto.setNip(c.getDocente().getNip() != null ? c.getDocente().getNip() : "");
        dto.setEcorreo(c.getDocente().getCorreoE() != null ? c.getDocente().getCorreoE() : "");
        
        dto.setEspecialidad( !c.getDocente().getDocentesEstudios().isEmpty() &&
                c.getDocente().getDocentesEstudios().get(0).getEspecialidad() != null ? 
                c.getDocente().getDocentesEstudios().get(0).getEspecialidad().getNombre() : "");
        
        dto.setTitulo(!c.getDocente().getDocentesEstudios().isEmpty() &&
                c.getDocente().getDocentesEstudios().get(0).getGradoAcademico().getNombre() != null ? 
                c.getDocente().getDocentesEstudios().get(0).getGradoAcademico().getNombre() : "");
        
        dto.setTitulo(!c.getDocente().getDocentesEstudios().isEmpty() &&
                c.getDocente().getDocentesEstudios().get(0).getInstitucionesEducativa().getNombre() != null ? 
                c.getDocente().getDocentesEstudios().get(0).getInstitucionesEducativa().getNombre() : "");
        
        dto.setAnnioGraduacion(!c.getDocente().getDocentesEstudios().isEmpty() &&
                c.getDocente().getDocentesEstudios().get(0).getAnnioGraduacion() != null ? 
                c.getDocente().getDocentesEstudios().get(0).getAnnioGraduacion() : null);
                
        dto.setNombreCompleto(c.getDocente().getNombreCompleto() != null ? c.getDocente().getNombreCompleto() : "");
        
        dto.setNombres(c.getDocente().getNombres() != null ? c.getDocente().getNombres() : "");
        dto.setApellidos(c.getDocente().getApellidos() != null ? c.getDocente().getApellidos() : "");
        
        dto.setIdDePlazaVacante(c.getPlaza().getIdSecuencial());
        dto.setNivelEducativo(c.getDocente().getNivelDocente() != null ? c.getDocente().getNivelDocente() : "");
        dto.setCentroEducativo(c.getPlaza().getCentrosEducativo().getNombrece() != null ? c.getPlaza().getCentrosEducativo().getNombrece() : "");
        dto.setEspecialidadPlazaVacante(c.getPlaza().getEspecialidad() != null ? c.getPlaza().getEspecialidad() : "");
        
        dto.setCalificacion(null);
        dto.setEstatus(null);
        dto.setObservacion(null);
        
        dto.setCodigoTransaccion(c.getIdTramiteAplic());
        dto.setTipoPrueba(tipoPrueba.toString());

        return dto;
    }

    public List<DocenteAplicacion> findAllNoRechazados(Integer pageSize,Integer from){
        if(pageSize!=null && from!=null){
            return getEntityManager()
                    .createNamedQuery("DocenteAplicacion.findAllNoRechazados")
                    .setMaxResults(pageSize)
                    .setFirstResult(from)
                    .getResultList();
        }else{
            return getEntityManager()
                    .createNamedQuery("DocenteAplicacion.findAllNoRechazados")
                    .getResultList();
        }
    }

    public CalculateCriterio5 fromDocenteAplicacion2CalculateCriterio5(Object[] da){
        CalculateCriterio5 c = new CalculateCriterio5();
        if(da!=null && da.length>0){
            c.setIdTramite((Long) da[0]);
            c.setIdMuniResidencia((String) da[1]);
            c.setIdDepResidencia((String) da[2]);
            c.setIdMuniPlaza((String) da[3]);
            c.setIdDepPlaza((String) da[4]);
        }
        return c;
    }

    @Transactional
    public List<CalculateCriterio5> findMunicipiosAndDeptosResidencia(Integer pageSize,Integer from){
         List<CalculateCriterio5> list = new ArrayList<>();
        ((List<Object[]>)getEntityManager()
                    .createNamedQuery("DocenteAplicacion.findMunicipiosAndDeptosResidencia")
                    .setMaxResults(pageSize)
                    .setFirstResult(from)
                    .getResultList()).stream().forEach(da->list.add(fromDocenteAplicacion2CalculateCriterio5(da)));
         return list;
    }

    @Transactional
    public Long countNoRechazados(){
        return (Long) getEntityManager()
                .createNamedQuery("DocenteAplicacion.CountMunicipiosAndDeptosResidencia")
                .getSingleResult();
    }

    @Transactional
    public List<DocenteAplicacion> findByIdSigobsolUsuarioNoRechazadas(long idSigobsolUsuario){
        return getEntityManager()
                .createNamedQuery("DocenteAplicacion.findByIdSigobsolUsuarioNoRechazadas")
                .setParameter("idSigobsolUsuario",idSigobsolUsuario)
                .getResultList();
    }

}
