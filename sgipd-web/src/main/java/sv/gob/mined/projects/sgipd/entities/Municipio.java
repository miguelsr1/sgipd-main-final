package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Municipios database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@Table(name="Municipios")
@NamedQueries({
		@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m"),
		@NamedQuery(name="Municipio.findAllMunicipiosByDepartamento",query="SELECT m FROM Municipio m WHERE m.departamento.id = :idDepartamento"),
		@NamedQuery(name = "Municipio.findByNombreMuniAndNobreDepto",query = "SELECT m FROM Municipio m WHERE m.nombre=:nombreMuni AND m.departamento.nombre=:nombreDepto")
}
)

public class Municipio implements Serializable {
	public static final long NO_DEFINIDO = 259;
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String nombre;

	//bi-directional many-to-one association to CentroEducativo
	@JsonbTransient
	@OneToMany(mappedBy="municipioBean")
	private List<CentroEducativo> centrosEducativos;

	//bi-directional many-to-one association to Docente
	@JsonbTransient
	@OneToMany(mappedBy="municipioBean")
	private List<Docente> docentes;

	//bi-directional many-to-one association to Departamento
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	@Column(name = "cod_institucional")
	private String codInstitucional;

	public Municipio() {
	}

	public Municipio(long id){
		this.id = id;
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

	public List<CentroEducativo> getCentrosEducativos() {
		return this.centrosEducativos;
	}

	public void setCentrosEducativos(List<CentroEducativo> centrosEducativos) {
		this.centrosEducativos = centrosEducativos;
	}

	public CentroEducativo addCentrosEducativo(CentroEducativo centrosEducativo) {
		getCentrosEducativos().add(centrosEducativo);
		centrosEducativo.setMunicipioBean(this);

		return centrosEducativo;
	}

	public CentroEducativo removeCentrosEducativo(CentroEducativo centrosEducativo) {
		getCentrosEducativos().remove(centrosEducativo);
		centrosEducativo.setMunicipioBean(null);

		return centrosEducativo;
	}

	public List<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public Docente addDocente(Docente docente) {
		getDocentes().add(docente);
		docente.setMunicipioBean(this);

		return docente;
	}

	public Docente removeDocente(Docente docente) {
		getDocentes().remove(docente);
		docente.setMunicipioBean(null);

		return docente;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getCodInstitucional() {
		return codInstitucional;
	}

	public void setCodInstitucional(String codInstitucional) {
		this.codInstitucional = codInstitucional;
	}
}