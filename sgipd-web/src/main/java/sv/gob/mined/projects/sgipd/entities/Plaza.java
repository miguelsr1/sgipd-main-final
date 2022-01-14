package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Plazas database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@Table(name="Plazas")
@NamedQuery(name="Plaza.findAll", query="SELECT p FROM Plaza p")
public class Plaza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_secuencial")
	private long idSecuencial;

	private String especialidad;

	@Column(name="nivel_educativo")
	private String nivelEducativo;

	private String turno;

	//bi-directional many-to-one association to DocenteAplicacion
	@OneToMany(mappedBy="plaza")
	private List<DocenteAplicacion> docentesAplicaciones;

	//bi-directional many-to-one association to CentroEducativo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codinfra")
	private CentroEducativo centrosEducativo;

	public Plaza() {
	}

	public long getIdSecuencial() {
		return this.idSecuencial;
	}

	public void setIdSecuencial(long idSecuencial) {
		this.idSecuencial = idSecuencial;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNivelEducativo() {
		return this.nivelEducativo;
	}

	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<DocenteAplicacion> getDocentesAplicaciones() {
		return this.docentesAplicaciones;
	}

	public void setDocentesAplicaciones(List<DocenteAplicacion> docentesAplicaciones) {
		this.docentesAplicaciones = docentesAplicaciones;
	}

	public DocenteAplicacion addDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
		getDocentesAplicaciones().add(docentesAplicacione);
		docentesAplicacione.setPlaza(this);

		return docentesAplicacione;
	}

	public DocenteAplicacion removeDocentesAplicacione(DocenteAplicacion docentesAplicacione) {
		getDocentesAplicaciones().remove(docentesAplicacione);
		docentesAplicacione.setPlaza(null);

		return docentesAplicacione;
	}

	public CentroEducativo getCentrosEducativo() {
		return this.centrosEducativo;
	}

	public void setCentrosEducativo(CentroEducativo centrosEducativo) {
		this.centrosEducativo = centrosEducativo;
	}

}