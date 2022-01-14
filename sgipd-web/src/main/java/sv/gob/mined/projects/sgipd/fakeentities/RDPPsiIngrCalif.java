package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@SqlResultSetMapping(name = "defaultMappingsRDPPsiIngrCalif",
        entities = @EntityResult(entityClass = RDPPsiIngrCalif.class))
public class RDPPsiIngrCalif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String nip;
    private String nombreCompleto;
    private BigDecimal calificacion;
    private String estatus;
    private String observacion;

    public RDPPsiIngrCalif() {
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RDPPsiIngrCalif that = (RDPPsiIngrCalif) o;

        return nip.equals(that.nip);
    }

    @Override
    public int hashCode() {
        return nip.hashCode();
    }

    @Override
    public String toString() {
        return "RDPPsiIngrCalif{" +
                "nip='" + nip + '\'' +
                '}';
    }
}
