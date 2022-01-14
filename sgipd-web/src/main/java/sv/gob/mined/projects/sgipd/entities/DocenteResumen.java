package sv.gob.mined.projects.sgipd.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Docentes_resumen")
@NamedQueries({
        @NamedQuery(name="DocenteResumen.findByIdTramiteAplic",
        query="SELECT d FROM DocenteResumen d WHERE d.idTramiteAplic=:idTramiteAplic"),
        @NamedQuery(name="DocenteResumen.find",
                query="SELECT d FROM DocenteResumen d WHERE d.idTramiteAplic=:idTramiteAplic")
})
public class  DocenteResumen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_tramite_aplic")
    private Long idTramiteAplic;
    @Column(name = "id_sigobsol_usuario")
    private Long idSigobsolUsuario;
    @Column(name="nip")
    private String nip;
    @Column(name="nombre_completo")
    private String nombreCompleto;
    @Column(name="nota_1")
    private BigDecimal nota1;
    @Column(name = "ponderacion_1")
    private BigDecimal ponderacion1;
    @Column(name="nota_2")
    private BigDecimal nota2;
    @Column(name = "ponderacion_2")
    private BigDecimal ponderacion2;
    @Column(name="nota_3a")
    private BigDecimal nota3a;
    @Column(name = "ponderacion_3a")
    private BigDecimal ponderacion3a;
    @Column(name="nota_3b")
    private BigDecimal nota3b;
    @Column(name = "ponderacion_3b")
    private BigDecimal ponderacion3b;
    @Column(name="nota_4a")
    private BigDecimal nota4a;
    @Column(name = "ponderacion_4a")
    private BigDecimal ponderacion4a;
    @Column(name="nota_4b")
    private BigDecimal nota4b;
    @Column(name = "ponderacion_4b")
    private BigDecimal ponderacion4b;
    @Column(name="nota_5")
    private BigDecimal nota5;
    @Column(name = "ponderacion_5")
    private BigDecimal ponderacion5;
    @Column(name = "nota_final")
    private BigDecimal notaFinal;
    @Column(name = "aprobacion")
    private Boolean aprobacion;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "id_secuencial_plaza")
    private Long idSecuencialPlaza;
    @Column(name = "posicion")
    private Long posicion;
    @Column(name = "fecha_ingreso")
    private Timestamp fechaIngreso;
    @Column(name = "usuario_ingreso")
    private String usuarioIngreso;
    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;
    @Column(name = "usuario_actualizacion")
    private String usuarioActualizacion;

    public DocenteResumen(Long idTramiteAplic, Long idSigobsolUsuario,String nip) {
        this.idTramiteAplic = idTramiteAplic;
        this.idSigobsolUsuario = idSigobsolUsuario;
        this.nip = nip;
    }

    public DocenteResumen() {
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

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getPonderacion1() {
        return ponderacion1;
    }

    public void setPonderacion1(BigDecimal ponderacion1) {
        this.ponderacion1 = ponderacion1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getPonderacion2() {
        return ponderacion2;
    }

    public void setPonderacion2(BigDecimal ponderacion2) {
        this.ponderacion2 = ponderacion2;
    }

    public BigDecimal getNota3a() {
        return nota3a;
    }

    public void setNota3a(BigDecimal nota3a) {
        this.nota3a = nota3a;
    }

    public BigDecimal getPonderacion3a() {
        return ponderacion3a;
    }

    public void setPonderacion3a(BigDecimal ponderacion3a) {
        this.ponderacion3a = ponderacion3a;
    }

    public BigDecimal getNota3b() {
        return nota3b;
    }

    public void setNota3b(BigDecimal nota3b) {
        this.nota3b = nota3b;
    }

    public BigDecimal getPonderacion3b() {
        return ponderacion3b;
    }

    public void setPonderacion3b(BigDecimal ponderacion3b) {
        this.ponderacion3b = ponderacion3b;
    }

    public BigDecimal getNota4a() {
        return nota4a;
    }

    public void setNota4a(BigDecimal nota4a) {
        this.nota4a = nota4a;
    }

    public BigDecimal getPonderacion4a() {
        return ponderacion4a;
    }

    public void setPonderacion4a(BigDecimal ponderacion4a) {
        this.ponderacion4a = ponderacion4a;
    }

    public BigDecimal getNota4b() {
        return nota4b;
    }

    public void setNota4b(BigDecimal nota4b) {
        this.nota4b = nota4b;
    }

    public BigDecimal getPonderacion4b() {
        return ponderacion4b;
    }

    public void setPonderacion4b(BigDecimal ponderacion4b) {
        this.ponderacion4b = ponderacion4b;
    }

    public BigDecimal getNota5() {
        return nota5;
    }

    public void setNota5(BigDecimal nota5) {
        this.nota5 = nota5;
    }

    public BigDecimal getPonderacion5() {
        return ponderacion5;
    }

    public void setPonderacion5(BigDecimal ponderacion5) {
        this.ponderacion5 = ponderacion5;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Boolean getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getIdSecuencialPlaza() {
        return idSecuencialPlaza;
    }

    public void setIdSecuencialPlaza(Long idSecuencialPlaza) {
        this.idSecuencialPlaza = idSecuencialPlaza;
    }

    public Long getPosicion() {
        return posicion;
    }

    public void setPosicion(Long posicion) {
        this.posicion = posicion;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    @Override
    public String toString() {
        return "DocenteResumen{" +
                "idTramiteAplic=" + idTramiteAplic +
                ", idSigobsolUsuario=" + idSigobsolUsuario +
                ", nip='" + nip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocenteResumen that = (DocenteResumen) o;

        return idTramiteAplic.equals(that.idTramiteAplic);
    }

    @Override
    public int hashCode() {
        return idTramiteAplic.hashCode();
    }
}
