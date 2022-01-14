package sv.gob.mined.projects.sgipd.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;

@ApplicationScoped
public class Criterio5Service {
    @Inject
    CalculateCriterio5Service calculateCriterio5Service;

    public Map<String, Long> saveCriterio5ResidenciaDocente(String usuario){
        return calculateCriterio5Service.saveCriterio5ResidenciaDocente(usuario);
    }

    public Map<String, Long> saveCriterio5ResidenciaDocente(String usuario,Integer pageSize,Integer from){
        return calculateCriterio5Service.saveCriterio5ResidenciaDocente(usuario,pageSize,from);
    }
}
