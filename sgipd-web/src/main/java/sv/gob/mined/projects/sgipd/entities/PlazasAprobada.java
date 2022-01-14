package sv.gob.mined.projects.sgipd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Plazas_Aprobadas")
public class PlazasAprobada {
    @Id
    @Column(name = "codigo_de_tramite", nullable = false)
    private Long id;

    @Column(name = "id_de_plaza")
    private Long idDePlaza;

    @Column(name = "codigo_de_solicitante")
    private Long codigoDeSolicitante;

    @Column(name = "NIP", length = 100)
    private String nip;

    @Column(name = "nip_corregido", length = 100)
    private String nipCorregido;

    @Column(name = "DUI_corregido", length = 100)
    private String duiCorregido;

    @Column(name = "nombre_completo_segun_registro_plataforma", length = 250)
    private String nombreCompletoSegunRegistroPlataforma;

    @Column(name = "resultadopruebapsicom_asp", precision = 10, scale = 2)
    private BigDecimal resultadopruebapsicomAsp;

    @Column(name = "puntajeppsicom_asp", precision = 10, scale = 2)
    private BigDecimal puntajeppsicomAsp;

    @Column(name = "resultadopct_asp", precision = 10, scale = 2)
    private BigDecimal resultadopctAsp;

    @Column(name = "puntajepct_asp", precision = 10, scale = 2)
    private BigDecimal puntajepctAsp;

    @Column(name = "notaexpcomprdoc_asp", precision = 10, scale = 2)
    private BigDecimal notaexpcomprdocAsp;

    @Column(name = "puntajeexpcompdoc_asp", precision = 10, scale = 2)
    private BigDecimal puntajeexpcompdocAsp;

    @Column(name = "notatitespecdoc_asp", precision = 10, scale = 2)
    private BigDecimal notatitespecdocAsp;

    @Column(name = "puntajetitespdoc_asp", precision = 10, scale = 2)
    private BigDecimal puntajetitespdocAsp;

    @Column(name = "notalugresidpers_asp", precision = 10, scale = 2)
    private BigDecimal notalugresidpersAsp;

    @Column(name = "puntajelugresidpers_asp", precision = 10, scale = 2)
    private BigDecimal puntajelugresidpersAsp;

    @Column(name = "notatotal_asp", precision = 10, scale = 2)
    private BigDecimal notatotalAsp;

    @Column(name = "numeroposicionenplaza_asp")
    private Long numeroposicionenplazaAsp;

    public Long getNumeroposicionenplazaAsp() {
        return numeroposicionenplazaAsp;
    }

    public void setNumeroposicionenplazaAsp(Long numeroposicionenplazaAsp) {
        this.numeroposicionenplazaAsp = numeroposicionenplazaAsp;
    }

    public BigDecimal getNotatotalAsp() {
        return notatotalAsp;
    }

    public void setNotatotalAsp(BigDecimal notatotalAsp) {
        this.notatotalAsp = notatotalAsp;
    }

    public BigDecimal getPuntajelugresidpersAsp() {
        return puntajelugresidpersAsp;
    }

    public void setPuntajelugresidpersAsp(BigDecimal puntajelugresidpersAsp) {
        this.puntajelugresidpersAsp = puntajelugresidpersAsp;
    }

    public BigDecimal getNotalugresidpersAsp() {
        return notalugresidpersAsp;
    }

    public void setNotalugresidpersAsp(BigDecimal notalugresidpersAsp) {
        this.notalugresidpersAsp = notalugresidpersAsp;
    }

    public BigDecimal getPuntajetitespdocAsp() {
        return puntajetitespdocAsp;
    }

    public void setPuntajetitespdocAsp(BigDecimal puntajetitespdocAsp) {
        this.puntajetitespdocAsp = puntajetitespdocAsp;
    }

    public BigDecimal getNotatitespecdocAsp() {
        return notatitespecdocAsp;
    }

    public void setNotatitespecdocAsp(BigDecimal notatitespecdocAsp) {
        this.notatitespecdocAsp = notatitespecdocAsp;
    }

    public BigDecimal getPuntajeexpcompdocAsp() {
        return puntajeexpcompdocAsp;
    }

    public void setPuntajeexpcompdocAsp(BigDecimal puntajeexpcompdocAsp) {
        this.puntajeexpcompdocAsp = puntajeexpcompdocAsp;
    }

    public BigDecimal getNotaexpcomprdocAsp() {
        return notaexpcomprdocAsp;
    }

    public void setNotaexpcomprdocAsp(BigDecimal notaexpcomprdocAsp) {
        this.notaexpcomprdocAsp = notaexpcomprdocAsp;
    }

    public BigDecimal getPuntajepctAsp() {
        return puntajepctAsp;
    }

    public void setPuntajepctAsp(BigDecimal puntajepctAsp) {
        this.puntajepctAsp = puntajepctAsp;
    }

    public BigDecimal getResultadopctAsp() {
        return resultadopctAsp;
    }

    public void setResultadopctAsp(BigDecimal resultadopctAsp) {
        this.resultadopctAsp = resultadopctAsp;
    }

    public BigDecimal getPuntajeppsicomAsp() {
        return puntajeppsicomAsp;
    }

    public void setPuntajeppsicomAsp(BigDecimal puntajeppsicomAsp) {
        this.puntajeppsicomAsp = puntajeppsicomAsp;
    }

    public BigDecimal getResultadopruebapsicomAsp() {
        return resultadopruebapsicomAsp;
    }

    public void setResultadopruebapsicomAsp(BigDecimal resultadopruebapsicomAsp) {
        this.resultadopruebapsicomAsp = resultadopruebapsicomAsp;
    }

    public String getNombreCompletoSegunRegistroPlataforma() {
        return nombreCompletoSegunRegistroPlataforma;
    }

    public void setNombreCompletoSegunRegistroPlataforma(String nombreCompletoSegunRegistroPlataforma) {
        this.nombreCompletoSegunRegistroPlataforma = nombreCompletoSegunRegistroPlataforma;
    }

    public String getDuiCorregido() {
        return duiCorregido;
    }

    public void setDuiCorregido(String duiCorregido) {
        this.duiCorregido = duiCorregido;
    }

    public String getNipCorregido() {
        return nipCorregido;
    }

    public void setNipCorregido(String nipCorregido) {
        this.nipCorregido = nipCorregido;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Long getCodigoDeSolicitante() {
        return codigoDeSolicitante;
    }

    public void setCodigoDeSolicitante(Long codigoDeSolicitante) {
        this.codigoDeSolicitante = codigoDeSolicitante;
    }

    public Long getIdDePlaza() {
        return idDePlaza;
    }

    public void setIdDePlaza(Long idDePlaza) {
        this.idDePlaza = idDePlaza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}