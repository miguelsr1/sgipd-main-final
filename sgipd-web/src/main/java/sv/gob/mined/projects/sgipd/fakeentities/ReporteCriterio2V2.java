package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@SqlResultSetMapping(name = "defaultMappingsReporteCriterio2V2",
        entities = @EntityResult(entityClass = ReporteCriterio2V2.class))
public class ReporteCriterio2V2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long idTramite;
    private String nip;
    private Long idPlazaVacante;
    private String nombreCompleto;
    private BigDecimal calificacion;
    private String estatus;
    private String observacion;

    public ReporteCriterio2V2() {
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Long getIdPlazaVacante() {
        return idPlazaVacante;
    }

    public void setIdPlazaVacante(Long idPlazaVacante) {
        this.idPlazaVacante = idPlazaVacante;
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

        ReporteCriterio2V2 that = (ReporteCriterio2V2) o;

        return idTramite.equals(that.idTramite);
    }

    @Override
    public int hashCode() {
        return idTramite.hashCode();
    }
}
