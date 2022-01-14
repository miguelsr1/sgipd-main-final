package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * The persistent class for the Docentes_experiencia database table.
 */
/*@Audited*/
@Entity
@Table(name = "Docentes_experiencia")
@NamedQueries({
        @NamedQuery(name = "DocenteExperiencia.findAll", query = "SELECT d FROM DocenteExperiencia d"),
        @NamedQuery(name = "DocenteExperiencia.byIdSigobsolUsuarioAndIndiceExperiencia",
                query = "SELECT d FROM DocenteExperiencia d WHERE d.idSigobsolUsuario=:idSigobsolUsuario AND d.indiceExperiencia=:indiceExperiencia"),
        @NamedQuery(name="DocenteExperiencia.sumExperienciasValidas",
                query = "SELECT COALESCE(SUM(d.cantidadDeAnnios),0.00) FROM DocenteExperiencia d WHERE d.idSigobsolUsuario=:idSigobsolUsuario AND d.experienciaValida=true")
})

public class DocenteExperiencia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia")
    private long idExperiencia;

    @Column(name = "cantidad_de_annios")
    private BigDecimal cantidadDeAnnios;

    private String departamento;

    private Timestamp desde;

    private Timestamp hasta;

    @Column(name = "desde_corregido")
    private Timestamp desdeCorregido;

    @Column(name = "hasta_corregido")
    private Timestamp hastaCorregido;

    @Column(name = "id_sigobsol_usuario")
    private long idSigobsolUsuario;

    @Column(name = "indice_experiencia")
    private short indiceExperiencia;

    @Column(name = "institucion_educativa_extranjero")
    private String institucionEducativaExtranjero;

    @Column(name = "institucion_educativa_nacional")
    private String institucionEducativaNacional;

    private String municipio;

    private String nombramiento;

    private String sector;

    @Column(name = "experiencia_valida")
    private Boolean experienciaValida;

    @Column(name = "interino")
    private Boolean interino;

    @Column(name ="fecha_actualizacion")
    private Timestamp fechaActualizacion;

    @Column(name = "usuario_actualizacion")
    private String usuarioActualizacion;

    public DocenteExperiencia() {
    }

    public long getIdExperiencia() {
        return this.idExperiencia;
    }

    public void setIdExperiencia(long idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public BigDecimal getCantidadDeAnnios() {
        return this.cantidadDeAnnios;
    }

    public void setCantidadDeAnnios(BigDecimal cantidadDeAnnios) {
        this.cantidadDeAnnios = cantidadDeAnnios;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Timestamp getDesde() {
        return this.desde;
    }

    public void setDesde(Timestamp desde) {
        this.desde = desde;
    }

    public Timestamp getHasta() {
        return this.hasta;
    }

    public void setHasta(Timestamp hasta) {
        this.hasta = hasta;
    }

    public Timestamp getDesdeCorregido() {
        return desdeCorregido;
    }

    public void setDesdeCorregido(Timestamp desdeCorregido) {
        this.desdeCorregido = desdeCorregido;
    }

    public Timestamp getHastaCorregido() {
        return hastaCorregido;
    }

    public void setHastaCorregido(Timestamp hastaCorregido) {
        this.hastaCorregido = hastaCorregido;
    }

    public long getIdSigobsolUsuario() {
        return this.idSigobsolUsuario;
    }

    public void setIdSigobsolUsuario(long idSigobsolUsuario) {
        this.idSigobsolUsuario = idSigobsolUsuario;
    }

    public short getIndiceExperiencia() {
        return this.indiceExperiencia;
    }

    public void setIndiceExperiencia(short indiceExperiencia) {
        this.indiceExperiencia = indiceExperiencia;
    }

    public String getInstitucionEducativaExtranjero() {
        return this.institucionEducativaExtranjero;
    }

    public void setInstitucionEducativaExtranjero(String institucionEducativaExtranjero) {
        this.institucionEducativaExtranjero = institucionEducativaExtranjero;
    }

    public String getInstitucionEducativaNacional() {
        return this.institucionEducativaNacional;
    }

    public void setInstitucionEducativaNacional(String institucionEducativaNacional) {
        this.institucionEducativaNacional = institucionEducativaNacional;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNombramiento() {
        return this.nombramiento;
    }

    public void setNombramiento(String nombramiento) {
        this.nombramiento = nombramiento;
    }

    public String getSector() {
        return this.sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Boolean getExperienciaValida() {
        return experienciaValida;
    }

    public void setExperienciaValida(Boolean experienciaValida) {
        this.experienciaValida = experienciaValida;
    }

    public Boolean getInterino() {
        return interino;
    }

    public void setInterino(Boolean interino) {
        this.interino = interino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocenteExperiencia that = (DocenteExperiencia) o;

        return idExperiencia == that.idExperiencia;
    }

    @Override
    public int hashCode() {
        return (int) (idExperiencia ^ (idExperiencia >>> 32));
    }

    @Override
    public String toString() {
        return "DocenteExperiencia{" +
                "idExperiencia=" + idExperiencia +
                '}';
    }

    public Timestamp getDesdeActualizado() {
        if(this.getDesdeCorregido()!=null){
            return this.getDesdeCorregido();
        }else{
            return this.getDesde();
        }
    }

    public Timestamp getHastaActualizado() {
        if(this.getHastaCorregido()!=null){
            return this.getHastaCorregido();
        }else {
            return this.getHasta();
        }
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
}