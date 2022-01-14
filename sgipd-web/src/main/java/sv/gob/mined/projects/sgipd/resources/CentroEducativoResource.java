package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.entities.CentroEducativo;
import sv.gob.mined.projects.sgipd.repositories.CentroEducativoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("centroeducativo")
@Produces(MediaType.APPLICATION_JSON)
public class CentroEducativoResource {
    @Inject
    private CentroEducativoRepository centroEducativoRepository;

    @GET
    @Path("/municipio/{idMunicipio}")
    public List<CentroEducativo> findByMunicipio(@PathParam("idMunicipio")long idMunicipio){
        return centroEducativoRepository.findByMunicipio(idMunicipio);
    }
}
