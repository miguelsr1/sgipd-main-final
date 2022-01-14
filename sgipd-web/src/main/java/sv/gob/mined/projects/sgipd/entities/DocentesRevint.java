package sv.gob.mined.projects.sgipd.entities;

import javax.persistence.*;

@Entity
@Table(name = "Docentes_revint")
@NamedQueries(
        {
                @NamedQuery(name = "DocentesRevint.findByIdSigobsolUsuarioIndiceTituloTipo",
                query = "SELECT d FROM DocentesRevint d where d.idSigobsolUsuario=:idSigobsolUsuario AND d.indiceTitulo=:indiceTitulo AND d.tipo=:tipo")
        }
)
public class DocentesRevint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rev", nullable = false)
    private Long id;

    @Column(name = "id_tramite_cv", nullable = false)
    private Long idTramiteCv;

    @Column(name = "id_sigobsol_usuario", nullable = false)
    private Long idSigobsolUsuario;

    @Column(name = "indice_titulo")
    private Integer indiceTitulo;

    @Column(name = "tipo", length = 25)
    private String tipo;

    @Column(name = "plazas_homologadas", length = 7000)
    private String plazasHomologadas;

    public String getPlazasHomologadas() {
        return plazasHomologadas;
    }

    public void setPlazasHomologadas(String plazasHomologadas) {
        this.plazasHomologadas = plazasHomologadas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIndiceTitulo() {
        return indiceTitulo;
    }

    public void setIndiceTitulo(Integer indiceTitulo) {
        this.indiceTitulo = indiceTitulo;
    }

    public Long getIdSigobsolUsuario() {
        return idSigobsolUsuario;
    }

    public void setIdSigobsolUsuario(Long idSigobsolUsuario) {
        this.idSigobsolUsuario = idSigobsolUsuario;
    }

    public Long getIdTramiteCv() {
        return idTramiteCv;
    }

    public void setIdTramiteCv(Long idTramiteCv) {
        this.idTramiteCv = idTramiteCv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}