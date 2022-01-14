package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.fakeentities.TramiteAplicacionDocente;
import sv.gob.mined.projects.sgipd.services.TramiteAplicacionDocenteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("tramites")
@Produces(MediaType.APPLICATION_JSON)
public class TramiteAplicacionDocenteResource {
    @Inject
    TramiteAplicacionDocenteService tramiteAplicacionDocenteService;

    @GET
    public List<TramiteAplicacionDocente> docentesQueHicieronPruebaPsicometrica(){
        return tramiteAplicacionDocenteService.docentesQueHicieronPruebaPsicometrica();
    }
}
