package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(name = "defaultMappingsTramiteAplicacionDocente",
        entities = @EntityResult(entityClass = TramiteAplicacionDocente.class))
public class TramiteAplicacionDocente implements Serializable {
    @Id
    private Long idTramiteAplic;
    private Long idSigobsolUsuario;
    private Long idSecuencialPlaza;

    public TramiteAplicacionDocente() {
    }

    public Long getIdTramiteAplic() {
        return idTramiteAplic;
    }

    public void setIdTramiteAplic(Long idTramiteAplic) {
        this.idTramiteAplic = idTramiteAplic;
    }

    public Long getIdSigobsolUsuario() {
        return idSigobsolUsuario;
    }

    public void setIdSigobsolUsuario(Long idSigobsolUsuario) {
        this.idSigobsolUsuario = idSigobsolUsuario;
    }

    public Long getIdSecuencialPlaza() {
        return idSecuencialPlaza;
    }

    public void setIdSecuencialPlaza(Long idSecuencialPlaza) {
        this.idSecuencialPlaza = idSecuencialPlaza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TramiteAplicacionDocente that = (TramiteAplicacionDocente) o;

        return idTramiteAplic != null ? idTramiteAplic.equals(that.idTramiteAplic) : that.idTramiteAplic == null;
    }

    @Override
    public int hashCode() {
        return idTramiteAplic != null ? idTramiteAplic.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TramiteAplicacionDocente{" +
                "idTramiteAplic=" + idTramiteAplic +
                '}';
    }
}
