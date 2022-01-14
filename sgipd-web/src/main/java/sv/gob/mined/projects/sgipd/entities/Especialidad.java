package sv.gob.mined.projects.sgipd.entities;

import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


/**
 * The persistent class for the Especialidad database table.
 */
/*@Audited(targetAuditMode = NOT_AUDITED)*/
@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
                @NamedQuery(name="Especialidad.findByNombre",
                        query="SELECT e FROM Especialidad e WHERE e.nombre = :nombre")
        }
)

public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    //bi-directional many-to-one association to DocenteEstudio
    @OneToMany(mappedBy = "especialidad")
    private List<DocenteEstudio> docentesEstudios;

    public Especialidad() {
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

    public List<DocenteEstudio> getDocentesEstudios() {
        return this.docentesEstudios;
    }

    public void setDocentesEstudios(List<DocenteEstudio> docentesEstudios) {
        this.docentesEstudios = docentesEstudios;
    }

    public DocenteEstudio addDocentesEstudio(DocenteEstudio docentesEstudio) {
        getDocentesEstudios().add(docentesEstudio);
        docentesEstudio.setEspecialidad(this);

        return docentesEstudio;
    }

    public DocenteEstudio removeDocentesEstudio(DocenteEstudio docentesEstudio) {
        getDocentesEstudios().remove(docentesEstudio);
        docentesEstudio.setEspecialidad(null);

        return docentesEstudio;
    }

}