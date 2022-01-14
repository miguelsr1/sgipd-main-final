package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Docentes_aplicaciones database table.
 * 
 */
/*@Audited*/
@Entity
@Table(name="Docentes_aplicaciones")
@NamedQueries({
		@NamedQuery(name="DocenteAplicacion.findAll", query="SELECT d FROM DocenteAplicacion d"),
		@NamedQuery(name="DocenteAplicacion.findByCentroEducativo", query="SELECT d FROM DocenteAplicacion d WHERE d.plaza.centrosEducativo.codinfra=:codinfra"),
		@NamedQuery(name="DocenteAplicacion.findByMunicipio", query="SELECT d FROM DocenteAplicacion d WHERE d.plaza.centrosEducativo.municipioBean.id=:idMunicipio"),
		@NamedQuery(name="DocenteAplicacion.findByDepartamento", query="SELECT d FROM DocenteAplicacion d WHERE d.plaza.centrosEducativo.municipioBean.departamento.id=:idDepartamento"),
		@NamedQuery(name = "DocenteAplicacion.findIdsTramiteAplicForIngrPruebaPsiByNip",
				query = "SELECT d.idTramiteAplic FROM DocenteAplicacion d WHERE d.rechazado='No Rechazado' AND d.docente.rechazado='No Rechazado' and TRIM(d.docente.nip) = TRIM(:nip) order by d.idTramiteAplic",
				lockMode = LockModeType.OPTIMISTIC
		),
		@NamedQuery(name = "DocenteAplicacion.findAllNoRechazados",
				lockMode = LockModeType.PESSIMISTIC_WRITE,
				query = "SELECT da FROM DocenteAplicacion da WHERE da.rechazado='No Rechazado' AND da.docente.rechazado='No Rechazado'"
		),
		@NamedQuery(
				name = "DocenteAplicacion.findMunicipiosAndDeptosResidencia",
				query="SELECT da.idTramiteAplic as idTramite, da.docente.municipioBean.codInstitucional as idMuniResidencia, da.docente.municipioBean.departamento.codInstitucional as idDepResidencia, da.plaza.centrosEducativo.municipioBean.codInstitucional as idMuniPlaza, da.plaza.centrosEducativo.municipioBean.departamento.codInstitucional as idDepPlaza  FROM DocenteAplicacion da WHERE da.rechazado='No Rechazado' and da.docente.rechazado='No Rechazado' order by da.idTramiteAplic",
				lockMode = LockModeType.PESSIMISTIC_WRITE
		),
		@NamedQuery(
				name = "DocenteAplicacion.CountMunicipiosAndDeptosResidencia",
				query="SELECT count(da.idTramiteAplic)  FROM DocenteAplicacion da WHERE da.rechazado='No Rechazado' and da.docente.rechazado='No Rechazado'",
				lockMode = LockModeType.PESSIMISTIC_WRITE
		),
		@NamedQuery(name = "DocenteAplicacion.findByIdSigobsolUsuarioNoRechazadas",
		query = "SELECT d FROM DocenteAplicacion d WHERE d.rechazado='No Rechazado' AND d.docente.idSigobsolUsuario=:idSigobsolUsuario AND d.docente.rechazado='No Rechazado'")
})
public class DocenteAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tramite_aplic")
	private long idTramiteAplic;

	//bi-directional many-to-one association to Docente
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_sigobsol_usuario")
	private Docente docente;

	//bi-directional many-to-one association to Plaza
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_secuencial_plaza")
	private Plaza plaza;

	//bi-directional many-to-one association to TipoTramite
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_tramite")
	private TipoTramite tipoTramiteBean;

	//bi-directional many-to-one association to Calificacion
	@JsonbTransient
	@OneToMany(mappedBy="docentesAplicacione")
	private List<Calificacion> calificaciones;

	//bi-directional many-to-one association to DocenteSeleccionado
	@JsonbTransient
	@OneToMany(mappedBy="docentesAplicacione")
	private List<DocenteSeleccionado> docentesSeleccionados;

	private String rechazado;

	public DocenteAplicacion() {
	}

	public long getIdTramiteAplic() {
		return this.idTramiteAplic;
	}

	public void setIdTramiteAplic(long idTramiteAplic) {
		this.idTramiteAplic = idTramiteAplic;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Plaza getPlaza() {
		return this.plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}

	public TipoTramite getTipoTramiteBean() {
		return this.tipoTramiteBean;
	}

	public void setTipoTramiteBean(TipoTramite tipoTramiteBean) {
		this.tipoTramiteBean = tipoTramiteBean;
	}

	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificacion addCalificacione(Calificacion calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setDocentesAplicacione(this);

		return calificacione;
	}

	public Calificacion removeCalificacione(Calificacion calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setDocentesAplicacione(null);

		return calificacione;
	}

	public List<DocenteSeleccionado> getDocentesSeleccionados() {
		return this.docentesSeleccionados;
	}

	public void setDocentesSeleccionados(List<DocenteSeleccionado> docentesSeleccionados) {
		this.docentesSeleccionados = docentesSeleccionados;
	}

	public DocenteSeleccionado addDocentesSeleccionado(DocenteSeleccionado docentesSeleccionado) {
		getDocentesSeleccionados().add(docentesSeleccionado);
		docentesSeleccionado.setDocentesAplicacione(this);

		return docentesSeleccionado;
	}

	public DocenteSeleccionado removeDocentesSeleccionado(DocenteSeleccionado docentesSeleccionado) {
		getDocentesSeleccionados().remove(docentesSeleccionado);
		docentesSeleccionado.setDocentesAplicacione(null);

		return docentesSeleccionado;
	}

	public String getRechazado() {
		return rechazado;
	}

	public void setRechazado(String rechazado) {
		this.rechazado = rechazado;
	}
}