package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.services.Criterio2Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("criterio2")
@Produces(MediaType.APPLICATION_JSON)
public class Criterio2Resource {
    @Inject
    private Criterio2Service criterio2Service;

    @GET
    @Path("/departamento")
    public List<Departamento> findAllDepartamentos(){
        return criterio2Service.findAllDepartamentos();
    }
    @GET
    @Path("/municipio/departamento/{idDepartamento}")
    public List<Municipio> findAllMunicipiosByDepartamento(@PathParam("idDepartamento")long idDepartamento){
        return criterio2Service.findAllMunicipiosByDepartamento(idDepartamento);
    }

    @GET
    @Path("grade_folders")
    public List<String> getFolders(){
        List<String> folders = new ArrayList<>();
        criterio2Service.getCarpetasFiltros().stream().forEach(c->folders.add(c.toString()));
        return folders;
    }

    @GET
    @Path("existeCalificacion/{idCriterio}/{idTramiteAplic}")
    public Long countByIdCriterioAndIdTramiteAplic(
            @PathParam("idCriterio")long idCriterio,
            @PathParam("idTramiteAplic") long idTramiteAplic
    ){
        return criterio2Service.countByIdCriterioAndIdTramiteAplic(idCriterio,idTramiteAplic);
    }
}
