package sv.gob.mined.projects.sgipd.entities.sigobsol;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "vExpediente_docentes_e2_plazas_21_12_2021")
public class VexpedienteDocentesE2Plaza {
    @Id
    @Column(name = "codigo_de_tramite", nullable = false)
    private Long codigoDeTramite;

    @Column(name = "codigo_de_solicitante", nullable = false)
    private Integer codigoDeSolicitante;

    @Column(name = "nombre_completo_segun_registro_plataforma")
    private String nombreCompletoSegunRegistroPlataforma;

    @Column(name = "email_segun_registro_plataforma")
    private String emailSegunRegistroPlataforma;

    @Column(name = "codigo_de_tipo_de_tramite")
    private Integer codigoDeTipoDeTramite;

    @Column(name = "id_de_plaza")
    private Integer idDePlaza;

    @Column(name = "nombre_del_CE")
    private String nombreDelCe;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "nivel_educativo")
    private String nivelEducativo;

    @Column(name = "turno")
    private String turno;

    @Column(name = "especialidad")
    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getNombreDelCe() {
        return nombreDelCe;
    }

    public Integer getIdDePlaza() {
        return idDePlaza;
    }

    public Integer getCodigoDeTipoDeTramite() {
        return codigoDeTipoDeTramite;
    }

    public String getEmailSegunRegistroPlataforma() {
        return emailSegunRegistroPlataforma;
    }

    public String getNombreCompletoSegunRegistroPlataforma() {
        return nombreCompletoSegunRegistroPlataforma;
    }

    public Integer getCodigoDeSolicitante() {
        return codigoDeSolicitante;
    }

    public Long getCodigoDeTramite() {
        return codigoDeTramite;
    }
}