package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the Docentes_seleccionados database table.
 * 
 */
/*@Audited*/
@Entity
@Table(name="Docentes_seleccionados")
@NamedQuery(name="DocenteSeleccionado.findAll", query="SELECT d FROM DocenteSeleccionado d")
public class DocenteSeleccionado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_seleccionado")
	private long idSeleccionado;

	@Column(name="fecha_actualizacion")
	private Timestamp fechaActualizacion;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	@Lob
	@Column(name="Observaciones")
	private String observaciones;

	private long posicion;

	@Column(name="usuario_actualizacion")
	private String usuarioActualizacion;

	@Column(name="usuario_ingreso")
	private String usuarioIngreso;

	@Column(name="valor_calif_total")
	private BigDecimal valorCalifTotal;

	//bi-directional many-to-one association to DocenteAplicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tramite_aplic")
	private DocenteAplicacion docentesAplicacione;

	public DocenteSeleccionado() {
	}

	public long getIdSeleccionado() {
		return this.idSeleccionado;
	}

	public void setIdSeleccionado(long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public long getPosicion() {
		return this.posicion;
	}

	public void setPosicion(long posicion) {
		this.posicion = posicion;
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

	public BigDecimal getValorCalifTotal() {
		return this.valorCalifTotal;
	}

	public void setValorCalifTotal(BigDecimal valorCalifTotal) {
		this.valorCalifTotal = valorCalifTotal;
	}

	public DocenteAplicacion getDocentesAplicacione() {
		return this.docentesAplicacione;
	}

	public void setDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
		this.docentesAplicacione = docentesAplicacione;
	}

}