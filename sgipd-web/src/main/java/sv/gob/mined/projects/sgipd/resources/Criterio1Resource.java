package sv.gob.mined.projects.sgipd.resources;

import org.keycloak.representations.AccessToken;
import sv.gob.mined.projects.sgipd.services.Criterio1Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Map;

@ApplicationScoped
@Path("criterio1")
@Produces(MediaType.APPLICATION_JSON)
public class Criterio1Resource {

    @Inject
    Criterio1Service criterio1Service;


    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }


    @GET
    @Path("/saveCriterio1PruebaPsicometrica/pageSize/{pageSize}/from/{from}")
    public Map<String, Long> saveCriterio1PruebaPsicometricaPaginated(
            @PathParam("pageSize") Integer pageSize, @PathParam("from") Integer from) {
        return criterio1Service.saveExcelFileCriterio1V1PruebaPsicometricaNew(getCurrentUser(), pageSize, from);
    }

    @GET
    @Path("/saveCriterio1PruebaPsicometrica/nip/{nip}")
    public Map<String, Long> saveCriterio1PruebaPsicometricaPaginated(@PathParam("nip") String nip) {
        return criterio1Service.saveExcelFileCriterio1V1PruebaPsicometricaNew(getCurrentUser(), nip);
    }
}
