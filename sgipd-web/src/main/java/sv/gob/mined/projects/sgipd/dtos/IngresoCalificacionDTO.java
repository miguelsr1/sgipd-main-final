package sv.gob.mined.projects.sgipd.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class IngresoCalificacionDTO implements Serializable {
    
    private String departamento;
    private String municipio;
    private Long codigoSolicitante;
    private String dui;
    private String nip;
    private String ecorreo;
    private String especialidad;
    private String titulo;
    private String universidad;
    private Long annioGraduacion;
    private String nombreCompleto;
    private String nombres;
    private String apellidos;
    private Long idDePlazaVacante;
    private String nivelEducativo;
    private String centroEducativo;
    private String especialidadPlazaVacante;
    private String notaCognitiva;
    private String estatus;
    private String observacion;
    
    private Long codigoTransaccion;    
    private String tipoPrueba;
    private BigDecimal calificacion;
    
    public IngresoCalificacionDTO() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Long getCodigoSolicitante() {
        return codigoSolicitante;
    }

    public void setCodigoSolicitante(Long codigoSolicitante) {
        this.codigoSolicitante = codigoSolicitante;
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

    public String getEcorreo() {
        return ecorreo;
    }

    public void setEcorreo(String ecorreo) {
        this.ecorreo = ecorreo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public Long getAnnioGraduacion() {
        return annioGraduacion;
    }

    public void setAnnioGraduacion(Long annioGraduacion) {
        this.annioGraduacion = annioGraduacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getIdDePlazaVacante() {
        return idDePlazaVacante;
    }

    public void setIdDePlazaVacante(Long idDePlazaVacante) {
        this.idDePlazaVacante = idDePlazaVacante;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getEspecialidadPlazaVacante() {
        return especialidadPlazaVacante;
    }

    public void setEspecialidadPlazaVacante(String especialidadPlazaVacante) {
        this.especialidadPlazaVacante = especialidadPlazaVacante;
    }

    public String getNotaCognitiva() {
        return notaCognitiva;
    }

    public void setNotaCognitiva(String notaCognitiva) {
        this.notaCognitiva = notaCognitiva;
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

    public Long getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(Long codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngresoCalificacionDTO that = (IngresoCalificacionDTO) o;

        return codigoTransaccion.equals(that.codigoTransaccion);
    }

    @Override
    public int hashCode() {
        return codigoTransaccion.hashCode();
    }
}
