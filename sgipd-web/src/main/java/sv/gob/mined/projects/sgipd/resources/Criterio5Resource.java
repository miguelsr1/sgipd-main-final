package sv.gob.mined.projects.sgipd.resources;

import org.keycloak.representations.AccessToken;
import sv.gob.mined.projects.sgipd.fakeentities.CalculateCriterio5;
import sv.gob.mined.projects.sgipd.repositories.DocenteAplicacionRepository;
import sv.gob.mined.projects.sgipd.services.CalculateCriterio5Service;
import sv.gob.mined.projects.sgipd.services.Criterio5Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Path("criterio5")
@Produces(MediaType.APPLICATION_JSON)
public class Criterio5Resource {

    @Inject
    Criterio5Service criterio5Service;

    @Inject
    CalculateCriterio5Service calculateCriterio5Service;

    @Inject
    AccessToken accessToken;

    @Inject
    DocenteAplicacionRepository docenteAplicacionRepository;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @GET
    @Path("/saveCriterio5ResidenciaDocente")
    public Map<String, Long> saveCriterio5ResidenciaDocente(){
        return criterio5Service.saveCriterio5ResidenciaDocente(getCurrentUser());
    }

    @GET
    @Path("/saveCriterio5ResidenciaDocente/pageSize/{pageSize}/from/{from}")
    public Map<String, Long> saveCriterio5ResidenciaDocentePaginated(
            @PathParam("pageSize") Integer pageSize,@PathParam("from") Integer from){
        return criterio5Service.saveCriterio5ResidenciaDocente(getCurrentUser(),pageSize,from);
    }

    @GET
    @Path("/residenciadocente/{idTramiteAplic}")
    public BigDecimal getNotaResidenciaDocenteByIdTramiteAplic(@PathParam("idTramiteAplic") Long idTramiteAplic){
        return calculateCriterio5Service.getNotaResidenciaDocenteByIdTramiteAplic(idTramiteAplic);
    }

    @GET
    @Path("/probarCalculate5/pageSize/{pageSize}/from/{from}")
    public List<CalculateCriterio5> findMunicipiosAndDeptosResidencia(@PathParam("pageSize") Integer pageSize, @PathParam("from") Integer from){
        return docenteAplicacionRepository.findMunicipiosAndDeptosResidencia(pageSize,from);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Long count(){
        return docenteAplicacionRepository.countNoRechazados();
    }

}
