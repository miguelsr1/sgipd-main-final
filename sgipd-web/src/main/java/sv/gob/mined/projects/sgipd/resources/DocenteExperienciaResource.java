package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.repositories.DocenteExperienciaRepository;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ApplicationScoped
@Path("docenteexperiencia")
@Produces(MediaType.APPLICATION_JSON)
public class DocenteExperienciaResource {

    @Inject
    DocenteExperienciaRepository docenteExperienciaRepository;

    @GET
    @Path("annios/usuario/{usuario}/indice/{indice}")
    public BigDecimal getAnnios(@PathParam("usuario") long idSigobsolUsuario,@PathParam("indice") short indiceExperiencia){
        return docenteExperienciaRepository.getAnnios(idSigobsolUsuario,indiceExperiencia);
    }
}
