package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Docentes_capacitacion database table.
 * 
 */
/*@Audited*/
@Entity
@Table(name="Docentes_capacitacion")
@NamedQueries({
		@NamedQuery(name="DocenteCapacitacion.findAll", query="SELECT d FROM DocenteCapacitacion d"),
		@NamedQuery(name="DocenteCapacitacion.findByIdSigobsolUsuarioAndIndiceCapacitacion",
				query="SELECT d FROM DocenteCapacitacion d WHERE d.idSigobsolUsuario=:idSigobsolUsuario AND d.indiceCapacitacion=:indiceCapacitacion"),
		@NamedQuery(name="DocenteCapacitacion.findByIdSigobsolUsuario",
				query="SELECT d FROM DocenteCapacitacion d WHERE d.idSigobsolUsuario=:idSigobsolUsuario")
})

public class DocenteCapacitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_capacitacion")
	private long idCapacitacion;

	@Column(name="cantidad_horas")
	private long cantidadHoras;

	@Column(name="diploma_obtenido")
	private String diplomaObtenido;

	@Column(name="fecha_finalizacion")
	private Timestamp fechaFinalizacion;

	@Column(name="fecha_inicio")
	private Timestamp fechaInicio;

	@Column(name="id_sigobsol_usuario")
	private long idSigobsolUsuario;

	@Column(name="indice_capacitacion")
	private short indiceCapacitacion;

	private String institucion;

	@Column(name="nombre_capacitacion")
	private String nombreCapacitacion;

	private String pais;

	private Boolean valido;

	@Column(name = "plazas_homologadas")
	private String plazasHomologadas;

	@Column(name ="fecha_actualizacion")
	private Timestamp fechaActualizacion;

	@Column(name = "usuario_actualizacion")
	private String usuarioActualizacion;

	public DocenteCapacitacion() {
	}

	public long getIdCapacitacion() {
		return this.idCapacitacion;
	}

	public void setIdCapacitacion(long idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public long getCantidadHoras() {
		return this.cantidadHoras;
	}

	public void setCantidadHoras(long cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getDiplomaObtenido() {
		return this.diplomaObtenido;
	}

	public void setDiplomaObtenido(String diplomaObtenido) {
		this.diplomaObtenido = diplomaObtenido;
	}

	public Timestamp getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}

	public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public long getIdSigobsolUsuario() {
		return this.idSigobsolUsuario;
	}

	public void setIdSigobsolUsuario(long idSigobsolUsuario) {
		this.idSigobsolUsuario = idSigobsolUsuario;
	}

	public short getIndiceCapacitacion() {
		return this.indiceCapacitacion;
	}

	public void setIndiceCapacitacion(short indiceCapacitacion) {
		this.indiceCapacitacion = indiceCapacitacion;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getNombreCapacitacion() {
		return this.nombreCapacitacion;
	}

	public void setNombreCapacitacion(String nombreCapacitacion) {
		this.nombreCapacitacion = nombreCapacitacion;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Boolean getValido() {
		return valido;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}

	public String getPlazasHomologadas() {
		return plazasHomologadas;
	}

	public void setPlazasHomologadas(String plazasHomologadas) {
		this.plazasHomologadas = plazasHomologadas;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DocenteCapacitacion that = (DocenteCapacitacion) o;

		return idCapacitacion == that.idCapacitacion;
	}

	@Override
	public int hashCode() {
		return (int) (idCapacitacion ^ (idCapacitacion >>> 32));
	}

	@Override
	public String toString() {
		return "DocenteCapacitacion{" +
				"idCapacitacion=" + idCapacitacion +
				'}';
	}
}