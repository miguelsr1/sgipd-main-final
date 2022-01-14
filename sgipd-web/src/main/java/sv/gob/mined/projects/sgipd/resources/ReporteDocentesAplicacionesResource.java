package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteDocentesAplicaciones;
import sv.gob.mined.projects.sgipd.services.ReporteDocentesAplicacionesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("aplicacionesdocente")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteDocentesAplicacionesResource {
    @Inject
    ReporteDocentesAplicacionesService reporteDocentesAplicacionesService;

    @GET
    @Path("/idDePlazaVacante/{idDePlazaVacante}")
    public ReporteDocentesAplicaciones findById(
            @PathParam("idDePlazaVacante")Long idDePlazaVacante){
        return reporteDocentesAplicacionesService.findById(idDePlazaVacante);
    }
    @GET
    @Path("/codigoDeSolicitante/{codigoDeSolicitante}")
    public List<ReporteDocentesAplicaciones> findByCodigoDeSolicitante(
            @PathParam("codigoDeSolicitante") Long codigoDeSolicitante){
        return reporteDocentesAplicacionesService.findByCodigoDeSolicitante(codigoDeSolicitante);
    }

}
