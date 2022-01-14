package sv.gob.mined.projects.sgipd.resources;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Path("jobs")
@Produces(MediaType.APPLICATION_JSON)
public class Jobs {

    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @Inject
    CalificacionRepository calificacionRepository;

    public static final String NUEVOS_EXPEDIENTES = "etl";
    public static final String CRITERIOS = "criterios";
    public static final String CIERRE = "cierre";

    @GET
    @Path("plazashomologadas/usuario/{idSigobsolUsuario}")
    public List<Integer> plazas(@PathParam("idSigobsolUsuario") Long idSigobsolUsuario) {
        return calificacionRepository.getIdPlazasDBByIdSigobsolUsuarioFromEstudios(idSigobsolUsuario.longValue());
    }

    @GET
    @Path("etl")
    public Map<String, Object> etl() {
        Map<String, Object> out = new HashMap<>();
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobParameters = new Properties();
        jobParameters.setProperty("currentUser", getCurrentUser());
        long execID = jobOperator.start(NUEVOS_EXPEDIENTES, jobParameters);
        out.put("JOBFile", NUEVOS_EXPEDIENTES);
        out.put("JOBExecID", execID);
        out.put("JOBMethod", "etl");
        out.put("JOBExecutor", getCurrentUser());
        return out;
    }

    @GET
    @Path("criterios")
    public Map<String, Object> criterios() {
        Map<String, Object> out = new HashMap<>();
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobParameters = new Properties();
        jobParameters.setProperty("currentUser", getCurrentUser());
        long execID = jobOperator.start(CRITERIOS, jobParameters);
        out.put("JOBFile", CRITERIOS);
        out.put("JOBExecID", execID);
        out.put("JOBMethod", "criterios");
        out.put("JOBExecutor", getCurrentUser());
        return out;
    }
    @GET
    @Path("cierre")
    public Map<String, Object> cierre() {
        Map<String, Object> out = new HashMap<>();
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobParameters = new Properties();
        jobParameters.setProperty("currentUser", getCurrentUser());
        long execID = jobOperator.start(CIERRE, jobParameters);
        out.put("JOBFile", CIERRE);
        out.put("JOBExecID", execID);
        out.put("JOBMethod", "cierre");
        out.put("JOBExecutor", getCurrentUser());
        return out;
    }

    @GET
    @Path("etl/proceso/{nombreArchivo}")
    public Map<String, Object> etl(@PathParam("nombreArchivo") String nombreArchivo) {
        Map<String, Object> out = new HashMap<>();
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobParameters = new Properties();
        jobParameters.setProperty("currentUser", getCurrentUser());
        long execID = jobOperator.start(nombreArchivo, jobParameters);
        out.put("JOBFile", nombreArchivo);
        out.put("JOBExecID", execID);
        out.put("JOBMethod", "etl");
        out.put("JOBExecutor", getCurrentUser());
        return out;
    }
}
