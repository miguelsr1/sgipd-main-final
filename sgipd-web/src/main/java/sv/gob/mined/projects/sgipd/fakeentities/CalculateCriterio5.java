package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(name = "defaultMappingsCalculateCriterio5",
        entities = @EntityResult(entityClass = CalculateCriterio5.class))
public class CalculateCriterio5 implements Serializable {

    @Id
    private Long idTramite;
    private String idMuniResidencia;
    private String idDepResidencia;
    private String idMuniPlaza;
    private String idDepPlaza;

    public CalculateCriterio5() {
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getIdMuniResidencia() {
        return idMuniResidencia;
    }

    public void setIdMuniResidencia(String idMuniResidencia) {
        this.idMuniResidencia = idMuniResidencia;
    }

    public String getIdDepResidencia() {
        return idDepResidencia;
    }

    public void setIdDepResidencia(String idDepResidencia) {
        this.idDepResidencia = idDepResidencia;
    }

    public String getIdMuniPlaza() {
        return idMuniPlaza;
    }

    public void setIdMuniPlaza(String idMuniPlaza) {
        this.idMuniPlaza = idMuniPlaza;
    }

    public String getIdDepPlaza() {
        return idDepPlaza;
    }

    public void setIdDepPlaza(String idDepPlaza) {
        this.idDepPlaza = idDepPlaza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalculateCriterio5 that = (CalculateCriterio5) o;

        return idTramite != null ? idTramite.equals(that.idTramite) : that.idTramite == null;
    }

    @Override
    public int hashCode() {
        return idTramite != null ? idTramite.hashCode() : 0;
    }
}
