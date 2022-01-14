package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the Calificaciones database table.
 * 
 */
/*@Audited*/
@Entity
@Table(name="Calificaciones")
@NamedQueries({
		@NamedQuery(name="Calificacion.findAll", query="SELECT c FROM Calificacion c"),
		@NamedQuery(name="Calificacion.countByIdCriterioAndIdTramiteAplic",
				query="SELECT COUNT(c.valorCalif) FROM Calificacion c WHERE c.criterio.idCriterio=:idCriterio AND c.docentesAplicacione.idTramiteAplic=:idTramiteAplic"),
		@NamedQuery(name="Calificacion.findIdsTramiteAplicForIngrPruebaPsiByNipOLD",
		query ="SELECT c.docentesAplicacione.idTramiteAplic FROM Calificacion c WHERE c.aprobacion=true AND trim(c.docentesAplicacione.docente.nip)=trim(:nip) AND c.criterio.idCriterio=2 AND c.docentesAplicacione.rechazado='No Rechazado' AND c.docentesAplicacione.docente.rechazado='No Rechazado'"),
		@NamedQuery(name="Calificacion.findIdsTramiteAplicForIngrPruebaPsiByNip",
				query ="SELECT c.docentesAplicacione.idTramiteAplic FROM Calificacion c WHERE trim(c.docentesAplicacione.docente.nip)=trim(:nip) AND c.docentesAplicacione.rechazado='No Rechazado' AND c.docentesAplicacione.docente.rechazado='No Rechazado' order by c.docentesAplicacione.idTramiteAplic"),
		@NamedQuery(name = "Calificacion.findByIdCriterioAndIdTramiteAplic",
		query = "SELECT c FROM Calificacion c WHERE c.docentesAplicacione.idTramiteAplic=:idTramiteAplic AND c.criterio.idCriterio=:idCriterio"),
		@NamedQuery(name = "Calificacion.findByIdTramiteAplic",
				query = "SELECT c FROM Calificacion c WHERE c.docentesAplicacione.idTramiteAplic=:idTramiteAplic order by c.criterio.indiceCriterio")
})

public class Calificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_calificacion")
	private long idCalificacion;

	private boolean aprobacion;

	@Column(name="fecha_actualizacion")
	private Timestamp fechaActualizacion;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	@Column(name="usuario_actualizacion")
	private String usuarioActualizacion;

	@Column(name="usuario_ingreso")
	private String usuarioIngreso;

	@Column(name="valor_calif")
	private BigDecimal valorCalif;

	@Column(name="valor_ponderacion")
	private BigDecimal valorPonderacion;

	//bi-directional many-to-one association to Criterio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	//bi-directional many-to-one association to DocenteAplicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tramite_aplic")
	private DocenteAplicacion docentesAplicacione;



	private String estatus;
	private String observacion;

	public Calificacion() {
	}

	public long getIdCalificacion() {
		return this.idCalificacion;
	}

	public void setIdCalificacion(long idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public boolean getAprobacion() {
		return this.aprobacion;
	}

	public void setAprobacion(boolean aprobacion) {
		this.aprobacion = aprobacion;
	}

	public Timestamp getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public String getUsuarioIngreso() {
		return this.usuarioIngreso;
	}

	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public BigDecimal getValorCalif() {
		return this.valorCalif;
	}

	public void setValorCalif(BigDecimal valorCalif) {
		this.valorCalif = valorCalif;
	}

	public BigDecimal getValorPonderacion() {
		return this.valorPonderacion;
	}

	public void setValorPonderacion(BigDecimal valorPonderacion) {
		this.valorPonderacion = valorPonderacion;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public DocenteAplicacion getDocentesAplicacione() {
		return this.docentesAplicacione;
	}

	public void setDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
		this.docentesAplicacione = docentesAplicacione;
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

}