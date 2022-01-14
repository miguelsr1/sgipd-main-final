package sv.gob.mined.projects.sgipd.resources;

import org.keycloak.representations.AccessToken;
import sv.gob.mined.projects.sgipd.services.CalculateCriterio5Service;
import sv.gob.mined.projects.sgipd.services.Criterio4Service;
import sv.gob.mined.projects.sgipd.services.Criterio5Service;

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
@Path("criterio4")
@Produces(MediaType.APPLICATION_JSON)
public class Criterio4Resource {

    @Inject
    Criterio4Service criterio4Service;



    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @GET
    @Path("/especialidad/{idTramiteAplic}")
    public BigDecimal getNotaEspecialidadByIdTramiteAplic(@PathParam("idTramiteAplic") Long idTramiteAplic){
        return criterio4Service.getNotaEspecialidadByIdTramiteAplic(idTramiteAplic);
    }

    @GET
    @Path("/capacitaciones/{idSIGOBSOLUsuario}")
    public BigDecimal getNotaCapacitacionesByIdSIGOBSOLUsuario(@PathParam("idSIGOBSOLUsuario") Long idSIGOBSOLUsuario){
        return criterio4Service.getNotaCapacitacionesByIdSIGOBSOLUsuario(idSIGOBSOLUsuario);
    }

}
