package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Centros_educativos database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@Table(name="Centros_educativos")
@NamedQueries(
		{
				@NamedQuery(name="CentroEducativo.findAll", query="SELECT c FROM CentroEducativo c"),
				@NamedQuery(name="CentroEducativo.findByMunicipio", query="SELECT c FROM CentroEducativo c WHERE c.municipioBean.id = :idMunicipio")
		}
)

public class CentroEducativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codinfra;

	private String departamento;

	private String municipio;

	private String nombrece;

	//bi-directional many-to-one association to Municipio
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_municipio")
	private Municipio municipioBean;

	//bi-directional many-to-one association to Plaza
	@JsonbTransient
	@OneToMany(mappedBy="centrosEducativo")
	private List<Plaza> plazas;

	public CentroEducativo() {
	}

	public long getCodinfra() {
		return this.codinfra;
	}

	public void setCodinfra(long codinfra) {
		this.codinfra = codinfra;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNombrece() {
		return this.nombrece;
	}

	public void setNombrece(String nombrece) {
		this.nombrece = nombrece;
	}

	public Municipio getMunicipioBean() {
		return this.municipioBean;
	}

	public void setMunicipioBean(Municipio municipioBean) {
		this.municipioBean = municipioBean;
	}

	public List<Plaza> getPlazas() {
		return this.plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public Plaza addPlaza(Plaza plaza) {
		getPlazas().add(plaza);
		plaza.setCentrosEducativo(this);

		return plaza;
	}

	public Plaza removePlaza(Plaza plaza) {
		getPlazas().remove(plaza);
		plaza.setCentrosEducativo(null);

		return plaza;
	}

}