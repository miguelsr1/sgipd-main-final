package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Grado_academico database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@Table(name="Grado_academico")
@NamedQueries({
		@NamedQuery(name="GradoAcademico.findAll", query="SELECT g FROM GradoAcademico g"),
		@NamedQuery(name="GradoAcademico.findByNombre", query="SELECT g FROM GradoAcademico g WHERE g.nombre = :nombre")
})

public class GradoAcademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grado_academico")
	private long idGradoAcademico;

	private String nombre;

	//bi-directional many-to-one association to DocenteEstudio
	@OneToMany(mappedBy="gradoAcademico")
	private List<DocenteEstudio> docentesEstudios;

	public GradoAcademico() {
	}

	public long getIdGradoAcademico() {
		return this.idGradoAcademico;
	}

	public void setIdGradoAcademico(long idGradoAcademico) {
		this.idGradoAcademico = idGradoAcademico;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DocenteEstudio> getDocentesEstudios() {
		return this.docentesEstudios;
	}

	public void setDocentesEstudios(List<DocenteEstudio> docentesEstudios) {
		this.docentesEstudios = docentesEstudios;
	}

	public DocenteEstudio addDocentesEstudio(DocenteEstudio docentesEstudio) {
		getDocentesEstudios().add(docentesEstudio);
		docentesEstudio.setGradoAcademico(this);

		return docentesEstudio;
	}

	public DocenteEstudio removeDocentesEstudio(DocenteEstudio docentesEstudio) {
		getDocentesEstudios().remove(docentesEstudio);
		docentesEstudio.setGradoAcademico(null);

		return docentesEstudio;
	}

}