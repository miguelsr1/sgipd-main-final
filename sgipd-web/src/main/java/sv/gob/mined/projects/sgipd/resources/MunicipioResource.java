package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.repositories.MunicipioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("municipio")
@Produces(MediaType.APPLICATION_JSON)
public class MunicipioResource {
    @Inject
    private MunicipioRepository municipioRepository;

    @GET@Path("/departamento/{idDepartamento}")
    public List<Municipio> findAllMunicipiosByDepartamento(@PathParam("idDepartamento")long idDepartamento){
        return municipioRepository.findAllMunicipiosByDepartamento(idDepartamento);
    }
}
