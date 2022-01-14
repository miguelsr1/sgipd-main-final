package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

/**
 * The persistent class for the Criterio database table.
 * 
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@NamedQuery(name="Criterio.findAll", query="SELECT c FROM Criterio c")
public class Criterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_criterio")
	private long idCriterio;

	@Lob
	@Column(name="descripcion_criterio")
	private String descripcionCriterio;

	@Lob
	@Column(name="descripcion_puntaje")
	private String descripcionPuntaje;

	private String formula;

	@Column(name="fraccion_ponderacion")
	private BigDecimal fraccionPonderacion;

	@Column(name="indice_criterio")
	private String indiceCriterio;

	@Column(name="nombre_criterio")
	private String nombreCriterio;

	@Column(name="puntaje_maximo")
	private double puntajeMaximo;

	//bi-directional many-to-one association to Calificacion
	@JsonbTransient
	@OneToMany(mappedBy="criterio")
	private List<Calificacion> calificaciones;

	public Criterio() {
	}

	public long getIdCriterio() {
		return this.idCriterio;
	}

	public void setIdCriterio(long idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getDescripcionCriterio() {
		return this.descripcionCriterio;
	}

	public void setDescripcionCriterio(String descripcionCriterio) {
		this.descripcionCriterio = descripcionCriterio;
	}

	public String getDescripcionPuntaje() {
		return this.descripcionPuntaje;
	}

	public void setDescripcionPuntaje(String descripcionPuntaje) {
		this.descripcionPuntaje = descripcionPuntaje;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public BigDecimal getFraccionPonderacion() {
		return this.fraccionPonderacion;
	}

	public void setFraccionPonderacion(BigDecimal fraccionPonderacion) {
		this.fraccionPonderacion = fraccionPonderacion;
	}

	public String getIndiceCriterio() {
		return indiceCriterio;
	}

	public void setIndiceCriterio(String indiceCriterio) {
		this.indiceCriterio = indiceCriterio;
	}

	public String getNombreCriterio() {
		return this.nombreCriterio;
	}

	public void setNombreCriterio(String nombreCriterio) {
		this.nombreCriterio = nombreCriterio;
	}

	public double getPuntajeMaximo() {
		return this.puntajeMaximo;
	}

	public void setPuntajeMaximo(double puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}

	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificacion addCalificacione(Calificacion calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setCriterio(this);

		return calificacione;
	}

	public Calificacion removeCalificacione(Calificacion calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setCriterio(null);

		return calificacione;
	}

}