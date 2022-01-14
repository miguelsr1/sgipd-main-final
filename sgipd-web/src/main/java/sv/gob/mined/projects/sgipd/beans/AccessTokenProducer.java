package sv.gob.mined.projects.sgipd.beans;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@RequestScoped
public class AccessTokenProducer {
    @Inject
    private HttpServletRequest request;

    @Produces
    public AccessToken getAccessToken() {
        return ((KeycloakPrincipal) request.getUserPrincipal()).getKeycloakSecurityContext().getToken();
    }
}
