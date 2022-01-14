package sv.gob.mined.projects.sgipd.resources;

import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.repositories.DepartamentoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("departamento")
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentoResource {
    @Inject
    private DepartamentoRepository departamentoRepository;

    @GET
    public List<Departamento> findAll(){
        return departamentoRepository.findAllDepartamentos();
    }
}
