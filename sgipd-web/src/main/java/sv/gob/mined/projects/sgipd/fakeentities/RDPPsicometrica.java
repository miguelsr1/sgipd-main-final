package sv.gob.mined.projects.sgipd.fakeentities;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(name = "defaultMappingsRDPPsicometrica",
        entities = @EntityResult(entityClass = RDPPsicometrica.class))
public class RDPPsicometrica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String nip;

    private String dui;

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


    public RDPPsicometrica() {
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RDPPsicometrica that = (RDPPsicometrica) o;

        return nip != null ? nip.equals(that.nip) : that.nip == null;
    }

    @Override
    public int hashCode() {
        return nip != null ? nip.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RDPPsicometrica{" +
                "nip='" + nip + '\'' +
                '}';
    }
}
