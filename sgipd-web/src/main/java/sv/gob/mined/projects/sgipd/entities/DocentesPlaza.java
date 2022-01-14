package sv.gob.mined.projects.sgipd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Docentes_plaza")
public class DocentesPlaza {
    @Id
    @Column(name = "id_tramite_aplic", nullable = false)
    private Long id;

    @Column(name = "id_secuencial_plaza")
    private Long idSecuencialPlaza;

    @Column(name = "id_sigobsol_usuario")
    private Long idSigobsolUsuario;

    @Column(name = "nip", length = 100)
    private String nip;

    @Column(name = "dui", length = 100)
    private String dui;

    @Column(name = "nombre_completo", length = 250)
    private String nombreCompleto;

    @Column(name = "nota_1", precision = 10, scale = 2)
    private BigDecimal nota1;

    @Column(name = "ponderacion_1", precision = 10, scale = 2)
    private BigDecimal ponderacion1;

    @Column(name = "nota_2", precision = 10, scale = 2)
    private BigDecimal nota2;

    @Column(name = "ponderacion_2", precision = 10, scale = 2)
    private BigDecimal ponderacion2;

    @Column(name = "nota_3", precision = 10, scale = 2)
    private BigDecimal nota3;

    @Column(name = "ponderacion_3", precision = 10, scale = 2)
    private BigDecimal ponderacion3;

    @Column(name = "nota_4", precision = 10, scale = 2)
    private BigDecimal nota4;

    @Column(name = "ponderacion_4", precision = 10, scale = 2)
    private BigDecimal ponderacion4;

    @Column(name = "nota_5", precision = 10, scale = 2)
    private BigDecimal nota5;

    @Column(name = "ponderacion_5", precision = 10, scale = 2)
    private BigDecimal ponderacion5;

    @Column(name = "nota_final", precision = 10, scale = 2)
    private BigDecimal notaFinal;

    @Column(name = "aprobacion")
    private Boolean aprobacion;

    @Column(name = "observacion", length = 1000)
    private String observacion;

    @Column(name = "posicion")
    private Long posicion;

    @Column(name = "fecha_ingreso")
    private Timestamp fechaIngreso;

    @Column(name = "usuario_ingreso", length = 100)
    private String usuarioIngreso;

    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;

    @Column(name = "usuario_actualizacion", length = 100)
    private String usuarioActualizacion;

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Long getPosicion() {
        return posicion;
    }

    public void setPosicion(Long posicion) {
        this.posicion = posicion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public BigDecimal getPonderacion5() {
        return ponderacion5;
    }

    public void setPonderacion5(BigDecimal ponderacion5) {
        this.ponderacion5 = ponderacion5;
    }

    public BigDecimal getNota5() {
        return nota5;
    }

    public void setNota5(BigDecimal nota5) {
        this.nota5 = nota5;
    }

    public BigDecimal getPonderacion4() {
        return ponderacion4;
    }

    public void setPonderacion4(BigDecimal ponderacion4) {
        this.ponderacion4 = ponderacion4;
    }

    public BigDecimal getNota4() {
        return nota4;
    }

    public void setNota4(BigDecimal nota4) {
        this.nota4 = nota4;
    }

    public BigDecimal getPonderacion3() {
        return ponderacion3;
    }

    public void setPonderacion3(BigDecimal ponderacion3) {
        this.ponderacion3 = ponderacion3;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public BigDecimal getPonderacion2() {
        return ponderacion2;
    }

    public void setPonderacion2(BigDecimal ponderacion2) {
        this.ponderacion2 = ponderacion2;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getPonderacion1() {
        return ponderacion1;
    }

    public void setPonderacion1(BigDecimal ponderacion1) {
        this.ponderacion1 = ponderacion1;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}