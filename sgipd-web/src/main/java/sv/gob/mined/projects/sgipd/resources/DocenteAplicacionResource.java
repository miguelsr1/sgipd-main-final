package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.dtos.IngresoCalificacionDTO;
import sv.gob.mined.projects.sgipd.entities.DocenteAplicacion;
import sv.gob.mined.projects.sgipd.repositories.DocenteAplicacionRepository;
import sv.gob.mined.projects.sgipd.repositories.enums.DocenteAplicacionCriteriaEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.IngresoCalificacionEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.TipoPrueba;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("docenteaplicacion")
@Produces(MediaType.APPLICATION_JSON)
public class DocenteAplicacionResource {
    @Inject
    private DocenteAplicacionRepository docenteAplicacionRepository;

    @GET
    @Path("/departamento/{idDepartamento}")
    public List<DocenteAplicacion> findByDepartamento(@PathParam("idDepartamento") long idDepartamento){
        return docenteAplicacionRepository.findByCriteria(DocenteAplicacionCriteriaEnum.findByDepartamento,idDepartamento);
    }

    @GET
    @Path("/municipio/{idMunicipio}")
    public List<DocenteAplicacion> findByMunicipio(@PathParam("idMunicipio") long idMunicipio){
        return docenteAplicacionRepository.findByCriteria(DocenteAplicacionCriteriaEnum.findByMunicipio,idMunicipio);
    }

    @GET
    @Path("/centroeducativo/{codinfra}")
    public List<DocenteAplicacion> findByCentroEducativo(@PathParam("codinfra") long codinfra){
        return docenteAplicacionRepository.findByCriteria(DocenteAplicacionCriteriaEnum.findByCentroEducativo,codinfra);
    }

    @GET
    @Path("/ce/{codinfra}")
    public List<IngresoCalificacionDTO> findByCentroEducativoDTO(@PathParam("codinfra") long codinfra){
        return docenteAplicacionRepository.findByCriteriaDTO(
                IngresoCalificacionEnum.findByCentroEducativoDTO,codinfra,
                TipoPrueba.Prueba_Conocimientos);
    }


}
