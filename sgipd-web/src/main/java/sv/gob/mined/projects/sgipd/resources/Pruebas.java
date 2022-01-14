package sv.gob.mined.projects.sgipd.resources;

import org.keycloak.representations.AccessToken;
import sv.gob.mined.projects.sgipd.repositories.CalificacionRepository;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@ApplicationScoped
@Path("pruebas")
@Produces(MediaType.APPLICATION_JSON)
public class Pruebas {

    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @Inject
    CalificacionRepository calificacionRepository;

    @GET
    @Path("listado/{usuario}")
    public List<List<Integer>> getListadoPlazasHomologadasCapacitaciones(@PathParam("usuario") Long usuario){
        return calificacionRepository.getIdPlazasDBByIdSigobsolUsuarioFromCapacitaciones(usuario);
    }


}
