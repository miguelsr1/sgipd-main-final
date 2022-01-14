package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Docentes_estudios database table.
 * 
 */
/*@Audited*/
@Entity
@Table(name="Docentes_estudios")
@NamedQueries({
		@NamedQuery(name="DocenteEstudio.findAll", query="SELECT d FROM DocenteEstudio d"),
		@NamedQuery(name="DocenteEstudio.findByIdSigobsolUsuarioAndIndiceTitulo",
				query="SELECT d FROM DocenteEstudio d WHERE d.docente.idSigobsolUsuario=:idSigobsolUsuario AND d.indiceTitulo=:indiceTitulo"),
		@NamedQuery(name="DocenteEstudio.findByIdSigobsolUsuario",
				query="SELECT d FROM DocenteEstudio d WHERE d.docente.idSigobsolUsuario=:idSigobsolUsuario"),
		@NamedQuery(name="DocenteEstudio.findValidos",
				query="SELECT d FROM DocenteEstudio d WHERE d.docente.rechazado='No Rechazado'")
})

public class DocenteEstudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estudios")
	private long idEstudios;

	@Column(name="annio_graduacion")
	private Long annioGraduacion;

	@Column(name="indice_titulo")
	private int indiceTitulo;

	//bi-directional many-to-one association to Docente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_sigobsol_usuario")
	private Docente docente;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;

	//bi-directional many-to-one association to GradoAcademico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grado_academico")
	private GradoAcademico gradoAcademico;

	//bi-directional many-to-one association to InstitucionEducativa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_institucion_educativa")
	private InstitucionEducativa institucionesEducativa;

	private Boolean valido;

	@Column(name = "plazas_homologadas")
	private String plazasHomologadas;

	@Column(name ="fecha_actualizacion")
	private Timestamp fechaActualizacion;

	@Column(name = "usuario_actualizacion")
	private String usuarioActualizacion;

	@Column(name = "especialidad_corregida")
	private String especialidadCorregida;

	public DocenteEstudio() {
	}

	public long getIdEstudios() {
		return this.idEstudios;
	}

	public void setIdEstudios(long idEstudios) {
		this.idEstudios = idEstudios;
	}

	public Long getAnnioGraduacion() {
		return this.annioGraduacion;
	}

	public void setAnnioGraduacion(Long annioGraduacion) {
		this.annioGraduacion = annioGraduacion;
	}

	public int getIndiceTitulo() {
		return this.indiceTitulo;
	}

	public void setIndiceTitulo(int indiceTitulo) {
		this.indiceTitulo = indiceTitulo;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public GradoAcademico getGradoAcademico() {
		return this.gradoAcademico;
	}

	public void setGradoAcademico(GradoAcademico gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public InstitucionEducativa getInstitucionesEducativa() {
		return this.institucionesEducativa;
	}

	public void setInstitucionesEducativa(InstitucionEducativa institucionesEducativa) {
		this.institucionesEducativa = institucionesEducativa;
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

	public String getEspecialidadCorregida() {
		return especialidadCorregida;
	}

	public void setEspecialidadCorregida(String especialidadCorregida) {
		this.especialidadCorregida = especialidadCorregida;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DocenteEstudio that = (DocenteEstudio) o;

		return idEstudios == that.idEstudios;
	}

	@Override
	public int hashCode() {
		return (int) (idEstudios ^ (idEstudios >>> 32));
	}

	@Override
	public String toString() {
		return "DocenteEstudio{" +
				"idEstudios=" + idEstudios +
				'}';
	}
}