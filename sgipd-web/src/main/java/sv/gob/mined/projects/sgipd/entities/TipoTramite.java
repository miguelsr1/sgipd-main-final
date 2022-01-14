package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Tipo_tramite database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@Table(name="Tipo_tramite")
@NamedQuery(name="TipoTramite.findAll", query="SELECT t FROM TipoTramite t")
public class TipoTramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_tramite")
	private long idTipoTramite;

	@Column(name="nombre_tramite")
	private String nombreTramite;

	//bi-directional many-to-one association to Docente
	@OneToMany(mappedBy="tipoTramiteBean")
	private List<Docente> docentes;

	//bi-directional many-to-one association to DocenteAplicacion
	@OneToMany(mappedBy="tipoTramiteBean")
	private List<DocenteAplicacion> docentesAplicaciones;

	public TipoTramite() {
	}

	public TipoTramite(long idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}

	public long getIdTipoTramite() {
		return this.idTipoTramite;
	}

	public void setIdTipoTramite(long idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}

	public String getNombreTramite() {
		return this.nombreTramite;
	}

	public void setNombreTramite(String nombreTramite) {
		this.nombreTramite = nombreTramite;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setTipoTramiteBean(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setTipoTramiteBean(null);

		return docente;
	}

	public List<DocenteAplicacion> getDocentesAplicaciones() {
		return this.docentesAplicaciones;
	}

	public void setDocentesAplicaciones(List<DocenteAplicacion> docentesAplicaciones) {
		this.docentesAplicaciones = docentesAplicaciones;
	}

	public DocenteAplicacion addDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
		getDocentesAplicaciones().add(docentesAplicacione);
		docentesAplicacione.setTipoTramiteBean(this);

		return docentesAplicacione;
	}

	public DocenteAplicacion removeDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
		getDocentesAplicaciones().remove(docentesAplicacione);
		docentesAplicacione.setTipoTramiteBean(null);

		return docentesAplicacione;
	}

}