package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Docentes database table.
 */
/*@Audited*/
@Entity
@Table(name = "Docentes")
@NamedQueries({
        @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
        @NamedQuery(name = "Docente.findAllNoRechazados", query = "SELECT d FROM Docente d WHERE d.rechazado='No Rechazado'")
})

public class Docente implements Serializable {
    public static final String NO_RECHAZADO = "No Rechazado";
    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sigobsol_usuario")
    private long idSigobsolUsuario;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "correo_e")
    private String correoE;

    private String departamento;

    @Column(name = "direccion_postal")
    private String direccionPostal;

    private String discapacidad;

    private String dui;

    @Column(name = "id_tramite")
    private long idTramite;

    private String municipio;

    private String nip;

    @Column(name = "nivel_docente")
    private String nivelDocente;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "tel_celular")
    private String telCelular;

    @Column(name = "tel_fijo")
    private String telFijo;

    //bi-directional many-to-one association to Municipio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio")
    private Municipio municipioBean;

    //bi-directional many-to-one association to TipoTramite
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_tramite")
    private TipoTramite tipoTramiteBean;

    //bi-directional many-to-one association to DocenteAplicacion
    @OneToMany(mappedBy = "docente")
    private List<DocenteAplicacion> docentesAplicaciones;

    //bi-directional many-to-one association to DocenteEstudio
    @OneToMany(mappedBy = "docente")
    private List<DocenteEstudio> docentesEstudios;

    private String rechazado;

    @Column(name = "nip_verificado")
    private String nipVerificado;

    @Column(name = "dui_verificado")
    private String duiVerificado;

    @Column(name = "interino")
    private Boolean interino;

    @Column(name = "validacion_de_interino")
    private Boolean validacionDeInterino;

    @Column(name = "fase_actual_SIGOB")
    private Integer faseActualSIGOB;

    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;

    @Column(name = "usuario_actualizacion")
    private String usuarioActualizacion;

    @Column(name = "elegible")
    private Boolean elegible;

    @Column(name = "obs_elegible")
    private String observacionElegible;

    public Docente() {
    }

    public long getIdSigobsolUsuario() {
        return this.idSigobsolUsuario;
    }

    public void setIdSigobsolUsuario(long idSigobsolUsuario) {
        this.idSigobsolUsuario = idSigobsolUsuario;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoE() {
        return this.correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccionPostal() {
        return this.direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getDiscapacidad() {
        return this.discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getDui() {
        return this.dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public long getIdTramite() {
        return this.idTramite;
    }

    public void setIdTramite(long idTramite) {
        this.idTramite = idTramite;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNivelDocente() {
        return this.nivelDocente;
    }

    public void setNivelDocente(String nivelDocente) {
        this.nivelDocente = nivelDocente;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelCelular() {
        return this.telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getTelFijo() {
        return this.telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public Municipio getMunicipioBean() {
        return this.municipioBean;
    }

    public void setMunicipioBean(Municipio municipioBean) {
        this.municipioBean = municipioBean;
    }

    public TipoTramite getTipoTramiteBean() {
        return this.tipoTramiteBean;
    }

    public void setTipoTramiteBean(TipoTramite tipoTramiteBean) {
        this.tipoTramiteBean = tipoTramiteBean;
    }

    public List<DocenteAplicacion> getDocentesAplicaciones() {
        return this.docentesAplicaciones;
    }

    public void setDocentesAplicaciones(List<DocenteAplicacion> docentesAplicaciones) {
        this.docentesAplicaciones = docentesAplicaciones;
    }

    public DocenteAplicacion addDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
        getDocentesAplicaciones().add(docentesAplicacione);
        docentesAplicacione.setDocente(this);

        return docentesAplicacione;
    }

    public DocenteAplicacion removeDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
        getDocentesAplicaciones().remove(docentesAplicacione);
        docentesAplicacione.setDocente(null);

        return docentesAplicacione;
    }

    public List<DocenteEstudio> getDocentesEstudios() {
        return this.docentesEstudios;
    }

    public void setDocentesEstudios(List<DocenteEstudio> docentesEstudios) {
        this.docentesEstudios = docentesEstudios;
    }

    public DocenteEstudio addDocentesEstudio(DocenteEstudio docentesEstudio) {
        getDocentesEstudios().add(docentesEstudio);
        docentesEstudio.setDocente(this);

        return docentesEstudio;
    }

    public DocenteEstudio removeDocentesEstudio(DocenteEstudio docentesEstudio) {
        getDocentesEstudios().remove(docentesEstudio);
        docentesEstudio.setDocente(null);

        return docentesEstudio;
    }

    public String getNombreCompleto() {
        return this.nombres!=null ? (this.nombres + " " + this.apellidos) : this.apellidos;
    }

    public String getRechazado() {
        return rechazado;
    }

    public void setRechazado(String rechazado) {
        this.rechazado = rechazado;
    }

    public String getNipVerificado() {
        return nipVerificado;
    }

    public void setNipVerificado(String nipVerificado) {
        this.nipVerificado = nipVerificado;
    }

    public String getDuiVerificado() {
        return duiVerificado;
    }

    public void setDuiVerificado(String duiVerificado) {
        this.duiVerificado = duiVerificado;
    }

    public Boolean getInterino() {
        return interino;
    }

    public void setInterino(Boolean interino) {
        this.interino = interino;
    }

    public Boolean getValidacionDeInterino() {
        return validacionDeInterino;
    }

    public void setValidacionDeInterino(Boolean validacionDeInterino) {
        this.validacionDeInterino = validacionDeInterino;
    }

    public Boolean getInterinoActualizado() {
        if (getValidacionDeInterino()) {
            return getValidacionDeInterino();
        } else {
            return getInterino();
        }
    }

    public Integer getFaseActualSIGOB() {
        return faseActualSIGOB;
    }

    public void setFaseActualSIGOB(Integer faseActualSIGOB) {
        this.faseActualSIGOB = faseActualSIGOB;
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

    public Boolean getElegible() {
        return elegible;
    }

    public void setElegible(Boolean elegible) {
        this.elegible = elegible;
    }

    public String getObservacionElegible() {
        return observacionElegible;
    }

    public void setObservacionElegible(String observacionElegible) {
        this.observacionElegible = observacionElegible;
    }
}
