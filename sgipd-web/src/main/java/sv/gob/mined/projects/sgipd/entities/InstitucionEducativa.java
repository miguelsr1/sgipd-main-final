package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Instituciones_educativas database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@Table(name="Instituciones_educativas")
@NamedQueries({
		@NamedQuery(name="InstitucionEducativa.findAll", query="SELECT i FROM InstitucionEducativa i"),
		@NamedQuery(name="InstitucionEducativa.findByNombre", query="SELECT i FROM InstitucionEducativa i WHERE i.nombre = :nombre")
})

public class InstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String nombre;

	@Column(name="tipo_institucion")
	private String tipoInstitucion;

	//bi-directional many-to-one association to DocenteEstudio
	@OneToMany(mappedBy="institucionesEducativa")
	private List<DocenteEstudio> docentesEstudios;

	public InstitucionEducativa() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoInstitucion() {
		return this.tipoInstitucion;
	}

	public void setTipoInstitucion(String tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

	public List<DocenteEstudio> getDocentesEstudios() {
		return this.docentesEstudios;
	}

	public void setDocentesEstudios(List<DocenteEstudio> docentesEstudios) {
		this.docentesEstudios = docentesEstudios;
	}

	public DocenteEstudio addDocentesEstudio(DocenteEstudio docentesEstudio) {
		getDocentesEstudios().add(docentesEstudio);
		docentesEstudio.setInstitucionesEducativa(this);

		return docentesEstudio;
	}

	public DocenteEstudio removeDocentesEstudio(DocenteEstudio docentesEstudio) {
		getDocentesEstudios().remove(docentesEstudio);
		docentesEstudio.setInstitucionesEducativa(null);

		return docentesEstudio;
	}

}