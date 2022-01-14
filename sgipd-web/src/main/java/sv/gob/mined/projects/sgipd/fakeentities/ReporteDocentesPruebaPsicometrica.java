package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(name = "defaultMappingsReporteDocentesPruebaPsicometrica",
        entities = @EntityResult(entityClass = ReporteDocentesPruebaPsicometrica.class))
public class ReporteDocentesPruebaPsicometrica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long idTramite;

    private String dui;

    private String nip;

    private String correo;

    private String especialidad;

    private String titulo;

    private String nombreCompleto;

    private String nombres;

    private String apellidos;

    private String sexo;

    private String discapacidad;

    private Long codigoMunicipioResidencia;

    private String municipioderesidencia;

    private Long codigoDepartamentoResidencia;

    private String departamentoderesidencia;

    private String direccionResidencia;

    private Long idDePlazaVacante;

    private String nivelEducativo;

    private Long codigoinfracentroeducativo;

    private String centroEducativoDePlaza;

    private String especialidadDePlazaVacantes;

    private Long codigoDepartamentoPlaza;

    private String departamentodelaplaza;

    private Long codigomunicipio;

    private String municipiodelaplazas;

    private Double resultadospruebaconocimientos;

    private Integer aprobacion;

    private Integer docenteRechazado;

    private Integer docenteAplicacionRechazada;

    public ReporteDocentesPruebaPsicometrica() {
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Long getCodigoMunicipioResidencia() {
        return codigoMunicipioResidencia;
    }

    public void setCodigoMunicipioResidencia(Long codigoMunicipioResidencia) {
        this.codigoMunicipioResidencia = codigoMunicipioResidencia;
    }

    public String getMunicipioderesidencia() {
        return municipioderesidencia;
    }

    public void setMunicipioderesidencia(String municipioderesidencia) {
        this.municipioderesidencia = municipioderesidencia;
    }

    public Long getCodigoDepartamentoResidencia() {
        return codigoDepartamentoResidencia;
    }

    public void setCodigoDepartamentoResidencia(Long codigoDepartamentoResidencia) {
        this.codigoDepartamentoResidencia = codigoDepartamentoResidencia;
    }

    public String getDepartamentoderesidencia() {
        return departamentoderesidencia;
    }

    public void setDepartamentoderesidencia(String departamentoderesidencia) {
        this.departamentoderesidencia = departamentoderesidencia;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
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

    public Long getCodigoinfracentroeducativo() {
        return codigoinfracentroeducativo;
    }

    public void setCodigoinfracentroeducativo(Long codigoinfracentroeducativo) {
        this.codigoinfracentroeducativo = codigoinfracentroeducativo;
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

    public Long getCodigoDepartamentoPlaza() {
        return codigoDepartamentoPlaza;
    }

    public void setCodigoDepartamentoPlaza(Long codigoDepartamentoPlaza) {
        this.codigoDepartamentoPlaza = codigoDepartamentoPlaza;
    }

    public String getDepartamentodelaplaza() {
        return departamentodelaplaza;
    }

    public void setDepartamentodelaplaza(String departamentodelaplaza) {
        this.departamentodelaplaza = departamentodelaplaza;
    }

    public Long getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(Long codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public String getMunicipiodelaplazas() {
        return municipiodelaplazas;
    }

    public void setMunicipiodelaplazas(String municipiodelaplazas) {
        this.municipiodelaplazas = municipiodelaplazas;
    }

    public Double getResultadospruebaconocimientos() {
        return resultadospruebaconocimientos;
    }

    public void setResultadospruebaconocimientos(Double resultadospruebaconocimientos) {
        this.resultadospruebaconocimientos = resultadospruebaconocimientos;
    }

    public Integer getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Integer aprobacion) {
        this.aprobacion = aprobacion;
    }

    public Integer getDocenteRechazado() {
        return docenteRechazado;
    }

    public void setDocenteRechazado(Integer docenteRechazado) {
        this.docenteRechazado = docenteRechazado;
    }

    public Integer getDocenteAplicacionRechazada() {
        return docenteAplicacionRechazada;
    }

    public void setDocenteAplicacionRechazada(Integer docenteAplicacionRechazada) {
        this.docenteAplicacionRechazada = docenteAplicacionRechazada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReporteDocentesPruebaPsicometrica that = (ReporteDocentesPruebaPsicometrica) o;

        return idTramite != null ? idTramite.equals(that.idTramite) : that.idTramite == null;
    }

    @Override
    public int hashCode() {
        return idTramite != null ? idTramite.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ReporteDocentesPruebaPsicometrica{" +
                "idTramite=" + idTramite +
                '}';
    }
}
