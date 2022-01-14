package sv.gob.mined.projects.sgipd.beans;

import org.keycloak.representations.AccessToken;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("parametrosSesionView")
@SessionScoped
public class ParametrosSesionView extends XBaseBean{

    @Inject
    AccessToken accessToken;
    private String usuario;
    private String nombreCompleto;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    public String getCompleteName(){return accessToken.getName();}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @PostConstruct
    @Override
    public void init() {
        this.usuario = getCurrentUser();
        this.nombreCompleto = getCompleteName();
    }

    public String paginaInicio(){
        return "/index"+JSF+FACES_REDIRECT;
    }
}
