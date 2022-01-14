package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(name = "defaultMappingsReporteDocentesAplicaciones",
        entities = @EntityResult(entityClass = ReporteDocentesAplicaciones.class))
public class ReporteDocentesAplicaciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long idTramite;

    private String departamento;

    private String municipio;

    private Long codigoDeSolicitante;

    private String dui;

    private String nip;

    private String ecorreo;

    private String especialidad;

    private String titulo;

    private String universidad;

    private Long annioGraduacion;

    private String nombreCompleto;

    private String nombre;

    private String apellido;

    private Long idDePlazaVacante;

    private String nivelEducativo;

    private String centroEducativoDePlaza;

    private String especialidadDePlazaVacantes;

    public ReporteDocentesAplicaciones() {
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
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

    public Long getCodigoDeSolicitante() {
        return codigoDeSolicitante;
    }

    public void setCodigoDeSolicitante(Long codigoDeSolicitante) {
        this.codigoDeSolicitante = codigoDeSolicitante;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCentroEducativoDePlaza() {
        return centroEducativoDePlaza;
    }

    public void setCentroEducativoDePlaza(String centroEducativoDePlaza) {
        this.centroEducativoDePlaza = centroEducativoDePlaza;
    }

    public String getEspecialidadDePlazaVacantes() {
        return especialidadDePlazaVacantes;
    }

    public void setEspecialidadDePlazaVacantes(String especialidadDePlazaVacantes) {
        this.especialidadDePlazaVacantes = especialidadDePlazaVacantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReporteDocentesAplicaciones that = (ReporteDocentesAplicaciones) o;

        return idTramite != null ? idTramite.equals(that.idTramite) : that.idTramite == null;
    }

    @Override
    public int hashCode() {
        return idTramite != null ? idTramite.hashCode() : 0;
    }
}
