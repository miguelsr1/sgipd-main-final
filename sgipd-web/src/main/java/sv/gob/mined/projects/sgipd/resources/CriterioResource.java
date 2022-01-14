package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.entities.Criterio;
import sv.gob.mined.projects.sgipd.repositories.CriterioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import java.util.List;

@ApplicationScoped
@Path("criterio")
@Produces(MediaType.APPLICATION_JSON)
public class CriterioResource {

    @Inject
    private CriterioRepository criterioRepository;

    @GET
    public List<Criterio> findAll(){
        return criterioRepository.findAll();
    }

}
