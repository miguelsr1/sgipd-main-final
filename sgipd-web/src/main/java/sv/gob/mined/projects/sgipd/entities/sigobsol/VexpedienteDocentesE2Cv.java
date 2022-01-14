package sv.gob.mined.projects.sgipd.entities.sigobsol;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Immutable
@Table(name = "vExpediente_docentes_e2_cv_21_12_2021")
@NamedQueries({
        @NamedQuery(name = "VexpedienteDocentesE2Cv.findAllWithExceptions",
        query = "SELECT v FROM VexpedienteDocentesE2Cv v where v.codigoDeSolicitante not in (6614,10309,15969,19159,19854,22206)")
})
public class VexpedienteDocentesE2Cv {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @Column(name = "codigo_de_tramite", nullable = false)
    private Long codigoDeTramite;

    @Column(name = "codigo_de_solicitante", nullable = false)
    private Integer codigoDeSolicitante;

    @Column(name = "codigo_de_tipo_de_tramite")
    private Integer codigoDeTipoDeTramite;

    @Column(name = "nombre_completo_segun_registro_plataforma")
    private String nombreCompletoSegunRegistroPlataforma;

    @Column(name = "email_segun_registro_plataforma")
    private String emailSegunRegistroPlataforma;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "direccion_actual_de_residencia")
    private String direccionActualDeResidencia;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "nip")
    private String nip;

    @Column(name = "dui")
    private String dui;

    @Column(name = "correo")
    private String correo;

    @Column(name = "nivel_docente")
    private String nivelDocente;

    @Column(name = "telefono_fijo")
    private String telefonoFijo;

    @Column(name = "telefono_celular")
    private String telefonoCelular;

    @Column(name = "discapacidad")
    private String discapacidad;

    @Column(name = "grado_academico_1")
    private String gradoAcademico1;

    @Column(name = "especialidad_1")
    private String especialidad1;

    @Column(name = "institucion_educativa_1")
    private String institucionEducativa1;

    @Column(name = "annio_de_graduacion_1")
    private String annioDeGraduacion1;

    @Column(name = "grado_academico_2")
    private String gradoAcademico2;

    @Column(name = "especialidad_2")
    private String especialidad2;

    @Column(name = "institucion_educativa_2")
    private String institucionEducativa2;

    @Column(name = "annio_de_graduacion_2")
    private String annioDeGraduacion2;

    @Column(name = "grado_academico_3")
    private String gradoAcademico3;

    @Column(name = "especialidad_3")
    private String especialidad3;

    @Column(name = "institucion_educativa_3")
    private String institucionEducativa3;

    @Column(name = "annio_de_graduacion_3")
    private String annioDeGraduacion3;

    @Column(name = "grado_academico_4")
    private String gradoAcademico4;

    @Column(name = "especialidad_4")
    private String especialidad4;

    @Column(name = "institucion_educativa_4")
    private String institucionEducativa4;

    @Column(name = "annio_de_graduacion_4")
    private String annioDeGraduacion4;

    @Column(name = "nombre_capacitacion_1")
    private String nombreCapacitacion1;

    @Column(name = "cantidad_horas_1")
    private Integer cantidadHoras1;

    @Column(name = "Institucion_1")
    private String institucion1;

    @Column(name = "fecha_inicio_1")
    private Timestamp fechaInicio1;

    @Column(name = "fecha_finalizacion_1")
    private Timestamp fechaFinalizacion1;

    @Column(name = "Pais_1")
    private String pais1;

    @Column(name = "diploma_obtenido_1")
    private String diplomaObtenido1;

    @Column(name = "nombre_capacitacion_2")
    private String nombreCapacitacion2;

    @Column(name = "cantidad_horas_2")
    private Integer cantidadHoras2;

    @Column(name = "Institucion_2")
    private String institucion2;

    @Column(name = "fecha_inicio_2")
    private Timestamp fechaInicio2;

    @Column(name = "fecha_finalizacion_2")
    private Timestamp fechaFinalizacion2;

    @Column(name = "Pais_2")
    private String pais2;

    @Column(name = "diploma_obtenido_2")
    private String diplomaObtenido2;

    @Column(name = "nombre_capacitacion_3")
    private String nombreCapacitacion3;

    @Column(name = "cantidad_horas_3")
    private Integer cantidadHoras3;

    @Column(name = "Institucion_3")
    private String institucion3;

    @Column(name = "fecha_inicio_3")
    private Timestamp fechaInicio3;

    @Column(name = "fecha_finalizacion_3")
    private Timestamp fechaFinalizacion3;

    @Column(name = "Pais_3")
    private String pais3;

    @Column(name = "diploma_obtenido_3")
    private String diplomaObtenido3;

    @Column(name = "nombre_capacitacion_4")
    private String nombreCapacitacion4;

    @Column(name = "cantidad_horas_4")
    private Integer cantidadHoras4;

    @Column(name = "Institucion_4")
    private String institucion4;

    @Column(name = "fecha_inicio_4")
    private Timestamp fechaInicio4;

    @Column(name = "fecha_finalizacion_4")
    private Timestamp fechaFinalizacion4;

    @Column(name = "Pais_4")
    private String pais4;

    @Column(name = "diploma_obtenido_4")
    private String diplomaObtenido4;

    @Column(name = "nombre_capacitacion_5")
    private String nombreCapacitacion5;

    @Column(name = "cantidad_horas_5")
    private Integer cantidadHoras5;

    @Column(name = "Institucion_5")
    private String institucion5;

    @Column(name = "fecha_inicio_5")
    private Timestamp fechaInicio5;

    @Column(name = "fecha_finalizacion_5")
    private Timestamp fechaFinalizacion5;

    @Column(name = "Pais_5")
    private String pais5;

    @Column(name = "diploma_obtenido_5")
    private String diplomaObtenido5;

    @Column(name = "institucion_educativa_nacional_1")
    private String institucionEducativaNacional1;

    @Column(name = "institucion_educativa_extranjero_1")
    private String institucionEducativaExtranjero1;

    @Column(name = "cantidad_de_annios_1")
    private Integer cantidadDeAnnios1;

    @Column(name = "departamento_1")
    private String departamento1;

    @Column(name = "municipio_1")
    private String municipio1;

    @Column(name = "desde_1")
    private Timestamp desde1;

    @Column(name = "hasta_1")
    private Timestamp hasta1;

    @Column(name = "nombramiento_1")
    private String nombramiento1;

    @Column(name = "sector_1")
    private String sector1;

    @Column(name = "institucion_educativa_nacional_2")
    private String institucionEducativaNacional2;

    @Column(name = "institucion_educativa_extranjero_2")
    private String institucionEducativaExtranjero2;

    @Column(name = "cantidad_de_annios_2")
    private Integer cantidadDeAnnios2;

    @Column(name = "departamento_2")
    private String departamento2;

    @Column(name = "municipio_2")
    private String municipio2;

    @Column(name = "desde_2")
    private Timestamp desde2;

    @Column(name = "hasta_2")
    private Timestamp hasta2;

    @Column(name = "nombramiento_2")
    private String nombramiento2;

    @Column(name = "sector_2")
    private String sector2;

    @Column(name = "institucion_educativa_nacional_3")
    private String institucionEducativaNacional3;

    @Column(name = "institucion_educativa_extranjero_3")
    private String institucionEducativaExtranjero3;

    @Column(name = "cantidad_de_annios_3")
    private Integer cantidadDeAnnios3;

    @Column(name = "departamento_3")
    private String departamento3;

    @Column(name = "municipio_3")
    private String municipio3;

    @Column(name = "desde_3")
    private Timestamp desde3;

    @Column(name = "hasta_3")
    private Timestamp hasta3;

    @Column(name = "nombramiento_3")
    private String nombramiento3;

    @Column(name = "sector_3")
    private String sector3;

    @Column(name = "institucion_educativa_nacional_4")
    private String institucionEducativaNacional4;

    @Column(name = "institucion_educativa_extranjero_4")
    private String institucionEducativaExtranjero4;

    @Column(name = "cantidad_de_annios_4")
    private Integer cantidadDeAnnios4;

    @Column(name = "departamento_4")
    private String departamento4;

    @Column(name = "municipio_4")
    private String municipio4;

    @Column(name = "desde_4")
    private Timestamp desde4;

    @Column(name = "hasta_4")
    private Timestamp hasta4;

    @Column(name = "nombramiento_4")
    private String nombramiento4;

    @Column(name = "sector_4")
    private String sector4;

    @Column(name = "Interino")
    private Boolean interino;

    @Column(name = "Estado", nullable = false)
    private Integer estado;

    @Column(name = "institucion_otra_experiencia_laboral_1")
    private String institucionOtraExperienciaLaboral1;

    @Column(name = "cantidad_annos_otra_experiencia_laboral_1")
    private Integer cantidadAnnosOtraExperienciaLaboral1;

    @Column(name = "departamento_otra_experiencia_laboral_1")
    private String departamentoOtraExperienciaLaboral1;

    @Column(name = "municipio_otra_experiencia_laboral_1")
    private String municipioOtraExperienciaLaboral1;

    @Column(name = "fecha_inicio_otra_experiencia_laboral_1")
    private Timestamp fechaInicioOtraExperienciaLaboral1;

    @Column(name = "fecha_fin_otra_experiencia_laboral_1")
    private Timestamp fechaFinOtraExperienciaLaboral1;

    @Column(name = "sector_otra_experiencia_laboral_1")
    private String sectorOtraExperienciaLaboral1;

    @Column(name = "institucion_otra_experiencia_laboral_2")
    private String institucionOtraExperienciaLaboral2;

    @Column(name = "cantidad_annos_otra_experiencia_laboral_2")
    private Integer cantidadAnnosOtraExperienciaLaboral2;

    @Column(name = "departamento_otra_experiencia_laboral_2")
    private String departamentoOtraExperienciaLaboral2;

    @Column(name = "municipio_otra_experiencia_laboral_2")
    private String municipioOtraExperienciaLaboral2;

    @Column(name = "fecha_inicio_otra_experiencia_laboral_2")
    private Timestamp fechaInicioOtraExperienciaLaboral2;

    @Column(name = "fecha_fin_otra_experiencia_laboral_2")
    private Timestamp fechaFinOtraExperienciaLaboral2;

    @Column(name = "sector_otra_experiencia_laboral_2")
    private String sectorOtraExperienciaLaboral2;

    @Column(name = "institucion_otra_experiencia_laboral_3")
    private String institucionOtraExperienciaLaboral3;

    @Column(name = "cantidad_annos_otra_experiencia_laboral_3")
    private Integer cantidadAnnosOtraExperienciaLaboral3;

    @Column(name = "departamento_otra_experiencia_laboral_3")
    private String departamentoOtraExperienciaLaboral3;

    @Column(name = "municipio_otra_experiencia_laboral_3")
    private String municipioOtraExperienciaLaboral3;

    @Column(name = "fecha_inicio_otra_experiencia_laboral_3")
    private Timestamp fechaInicioOtraExperienciaLaboral3;

    @Column(name = "fecha_fin_otra_experiencia_laboral_3")
    private Timestamp fechaFinOtraExperienciaLaboral3;

    @Column(name = "sector_otra_experiencia_laboral_3")
    private String sectorOtraExperienciaLaboral3;

    @Column(name = "NIP_Verificado")
    private String nipVerificado;

    @Column(name = "DUI_Verificado")
    private String duiVerificado;

    @Column(name = "Especialidad_corregida_1")
    private String especialidadCorregida1;

    @Lob
    @Column(name = "Plazas_Homologadas_Estudios_realizados_1")
    private String plazasHomologadasEstudiosRealizados1;

    @Column(name = "Datos_validos_Estudios_realizados_1")
    private Boolean datosValidosEstudiosRealizados1;

    @Column(name = "Especialidad_corregida_2")
    private String especialidadCorregida2;

    @Lob
    @Column(name = "Plazas_Homologadas_Estudios_realizados_2")
    private String plazasHomologadasEstudiosRealizados2;

    @Column(name = "Datos_validos_Estudios_realizados_2")
    private Boolean datosValidosEstudiosRealizados2;

    @Column(name = "Especialidad_corregida_3")
    private String especialidadCorregida3;

    @Lob
    @Column(name = "Plazas_Homologadas_Estudios_realizados_3")
    private String plazasHomologadasEstudiosRealizados3;

    @Column(name = "Datos_validos_Estudios_realizados_3")
    private Boolean datosValidosEstudiosRealizados3;

    @Column(name = "Especialidad_corregida_4")
    private String especialidadCorregida4;

    @Lob
    @Column(name = "Plazas_Homologadas_Estudios_realizados_4")
    private String plazasHomologadasEstudiosRealizados4;

    @Column(name = "Datos_validos_Estudios_realizados_4")
    private Boolean datosValidosEstudiosRealizados4;

    @Lob
    @Column(name = "Plazas_homologadas_capacitaciones_1")
    private String plazasHomologadasCapacitaciones1;

    @Lob
    @Column(name = "Plazas_homologadas_capacitaciones_2")
    private String plazasHomologadasCapacitaciones2;

    @Lob
    @Column(name = "Plazas_homologadas_capacitaciones_3")
    private String plazasHomologadasCapacitaciones3;

    @Lob
    @Column(name = "Plazas_homologadas_capacitaciones_4")
    private String plazasHomologadasCapacitaciones4;

    @Lob
    @Column(name = "Plazas_homologadas_capacitaciones_5")
    private String plazasHomologadasCapacitaciones5;

    @Column(name = "Fecha_inicio_corregida_experiencia_laboral_1")
    private Timestamp fechaInicioCorregidaExperienciaLaboral1;

    @Column(name = "Fecha_fin_corregida_experiencia_laboral_1")
    private Timestamp fechaFinCorregidaExperienciaLaboral1;

    @Column(name = "Datos_validos_experiencia_laboral_1")
    private Boolean datosValidosExperienciaLaboral1;

    @Column(name = "Fecha_inicio_corregida_experiencia_laboral_2")
    private Timestamp fechaInicioCorregidaExperienciaLaboral2;

    @Column(name = "Fecha_fin_corregida_experiencia_laboral_2")
    private Timestamp fechaFinCorregidaExperienciaLaboral2;

    @Column(name = "Datos_validos_experiencia_laboral_2")
    private Boolean datosValidosExperienciaLaboral2;

    @Column(name = "Fecha_inicio_corregida_experiencia_laboral_3")
    private Timestamp fechaInicioCorregidaExperienciaLaboral3;

    @Column(name = "Fecha_fin_corregida_experiencia_laboral_3")
    private Timestamp fechaFinCorregidaExperienciaLaboral3;

    @Column(name = "Datos_validos_experiencia_laboral_3")
    private Boolean datosValidosExperienciaLaboral3;

    @Column(name = "Fecha_inicio_corregida_experiencia_laboral_4")
    private Timestamp fechaInicioCorregidaExperienciaLaboral4;

    @Column(name = "Fecha_fin_corregida_experiencia_laboral_4")
    private Timestamp fechaFinCorregidaExperienciaLaboral4;

    @Column(name = "Datos_validos_experiencia_laboral_4")
    private Boolean datosValidosExperienciaLaboral4;

    @Column(name = "Fecha_inicio_corregida_otra_experiencia_laboral_1")
    private Timestamp fechaInicioCorregidaOtraExperienciaLaboral1;

    @Column(name = "Fecha_fin_corregida_otra_experiencia_laboral_1")
    private Timestamp fechaFinCorregidaOtraExperienciaLaboral1;

    @Column(name = "Datos_validos_otra_experiencia_laboral_1")
    private Boolean datosValidosOtraExperienciaLaboral1;

    @Column(name = "Fecha_inicio_corregida_otra_experiencia_laboral_2")
    private Timestamp fechaInicioCorregidaOtraExperienciaLaboral2;

    @Column(name = "Fecha_fin_corregida_otra_experiencia_laboral_2")
    private Timestamp fechaFinCorregidaOtraExperienciaLaboral2;

    @Column(name = "Datos_validos_otra_experiencia_laboral_2")
    private Boolean datosValidosOtraExperienciaLaboral2;

    @Column(name = "Fecha_inicio_corregida_otra_experiencia_laboral_3")
    private Timestamp fechaInicioCorregidaOtraExperienciaLaboral3;

    @Column(name = "Fecha_fin_corregida_otra_experiencia_laboral_3")
    private Timestamp fechaFinCorregidaOtraExperienciaLaboral3;

    @Column(name = "Datos_validos_otra_experiencia_laboral_3")
    private Boolean datosValidosOtraExperienciaLaboral3;

    @Column(name = "Validacion_de_interino")
    private Boolean validacionDeInterino;

    @Column(name = "fase_actual_SIGOB")
    private Integer faseActualSigob;

    public Integer getFaseActualSigob() {
        return faseActualSigob;
    }

    public Boolean getValidacionDeInterino() {
        return validacionDeInterino;
    }

    public Boolean getDatosValidosOtraExperienciaLaboral3() {
        return datosValidosOtraExperienciaLaboral3;
    }

    public Timestamp getFechaFinCorregidaOtraExperienciaLaboral3() {
        return fechaFinCorregidaOtraExperienciaLaboral3;
    }

    public Timestamp getFechaInicioCorregidaOtraExperienciaLaboral3() {
        return fechaInicioCorregidaOtraExperienciaLaboral3;
    }

    public Timestamp getFechaFinCorregidaOtraExperienciaLaboral2() {
        return fechaFinCorregidaOtraExperienciaLaboral2;
    }

    public Timestamp getFechaInicioCorregidaOtraExperienciaLaboral2() {
        return fechaInicioCorregidaOtraExperienciaLaboral2;
    }

    public Boolean getDatosValidosOtraExperienciaLaboral1() {
        return datosValidosOtraExperienciaLaboral1;
    }

    public Timestamp getFechaFinCorregidaOtraExperienciaLaboral1() {
        return fechaFinCorregidaOtraExperienciaLaboral1;
    }

    public Timestamp getFechaInicioCorregidaOtraExperienciaLaboral1() {
        return fechaInicioCorregidaOtraExperienciaLaboral1;
    }

    public Boolean getDatosValidosExperienciaLaboral4() {
        return datosValidosExperienciaLaboral4;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral4() {
        return fechaFinCorregidaExperienciaLaboral4;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral4() {
        return fechaInicioCorregidaExperienciaLaboral4;
    }

    public Boolean getDatosValidosExperienciaLaboral3() {
        return datosValidosExperienciaLaboral3;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral3() {
        return fechaFinCorregidaExperienciaLaboral3;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral3() {
        return fechaInicioCorregidaExperienciaLaboral3;
    }

    public Boolean getDatosValidosExperienciaLaboral2() {
        return datosValidosExperienciaLaboral2;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral2() {
        return fechaFinCorregidaExperienciaLaboral2;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral2() {
        return fechaInicioCorregidaExperienciaLaboral2;
    }

    public Boolean getDatosValidosExperienciaLaboral1() {
        return datosValidosExperienciaLaboral1;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral1() {
        return fechaFinCorregidaExperienciaLaboral1;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral1() {
        return fechaInicioCorregidaExperienciaLaboral1;
    }

    public String getPlazasHomologadasCapacitaciones5() {
        return plazasHomologadasCapacitaciones5;
    }

    public String getPlazasHomologadasCapacitaciones4() {
        return plazasHomologadasCapacitaciones4;
    }

    public String getPlazasHomologadasCapacitaciones3() {
        return plazasHomologadasCapacitaciones3;
    }

    public String getPlazasHomologadasCapacitaciones2() {
        return plazasHomologadasCapacitaciones2;
    }

    public String getPlazasHomologadasCapacitaciones1() {
        return plazasHomologadasCapacitaciones1;
    }

    public Boolean getDatosValidosEstudiosRealizados4() {
        return datosValidosEstudiosRealizados4;
    }

    public String getPlazasHomologadasEstudiosRealizados4() {
        return plazasHomologadasEstudiosRealizados4;
    }

    public String getEspecialidadCorregida4() {
        return especialidadCorregida4;
    }

    public Boolean getDatosValidosEstudiosRealizados3() {
        return datosValidosEstudiosRealizados3;
    }

    public String getPlazasHomologadasEstudiosRealizados3() {
        return plazasHomologadasEstudiosRealizados3;
    }

    public String getEspecialidadCorregida3() {
        return especialidadCorregida3;
    }

    public Boolean getDatosValidosEstudiosRealizados2() {
        return datosValidosEstudiosRealizados2;
    }

    public String getPlazasHomologadasEstudiosRealizados2() {
        return plazasHomologadasEstudiosRealizados2;
    }

    public String getEspecialidadCorregida2() {
        return especialidadCorregida2;
    }

    public Boolean getDatosValidosEstudiosRealizados1() {
        return datosValidosEstudiosRealizados1;
    }

    public String getPlazasHomologadasEstudiosRealizados1() {
        return plazasHomologadasEstudiosRealizados1;
    }

    public String getEspecialidadCorregida1() {
        return especialidadCorregida1;
    }

    public String getDuiVerificado() {
        return duiVerificado;
    }

    public String getNipVerificado() {
        return nipVerificado;
    }

    public String getSectorOtraExperienciaLaboral3() {
        return sectorOtraExperienciaLaboral3;
    }

    public Timestamp getFechaFinOtraExperienciaLaboral3() {
        return fechaFinOtraExperienciaLaboral3;
    }

    public Timestamp getFechaInicioOtraExperienciaLaboral3() {
        return fechaInicioOtraExperienciaLaboral3;
    }

    public String getMunicipioOtraExperienciaLaboral3() {
        return municipioOtraExperienciaLaboral3;
    }

    public String getDepartamentoOtraExperienciaLaboral3() {
        return departamentoOtraExperienciaLaboral3;
    }

    public Integer getCantidadAnnosOtraExperienciaLaboral3() {
        return cantidadAnnosOtraExperienciaLaboral3;
    }

    public String getInstitucionOtraExperienciaLaboral3() {
        return institucionOtraExperienciaLaboral3;
    }

    public String getSectorOtraExperienciaLaboral2() {
        return sectorOtraExperienciaLaboral2;
    }

    public Timestamp getFechaFinOtraExperienciaLaboral2() {
        return fechaFinOtraExperienciaLaboral2;
    }

    public Timestamp getFechaInicioOtraExperienciaLaboral2() {
        return fechaInicioOtraExperienciaLaboral2;
    }

    public String getMunicipioOtraExperienciaLaboral2() {
        return municipioOtraExperienciaLaboral2;
    }

    public String getDepartamentoOtraExperienciaLaboral2() {
        return departamentoOtraExperienciaLaboral2;
    }

    public Integer getCantidadAnnosOtraExperienciaLaboral2() {
        return cantidadAnnosOtraExperienciaLaboral2;
    }

    public String getInstitucionOtraExperienciaLaboral2() {
        return institucionOtraExperienciaLaboral2;
    }

    public String getSectorOtraExperienciaLaboral1() {
        return sectorOtraExperienciaLaboral1;
    }

    public Timestamp getFechaFinOtraExperienciaLaboral1() {
        return fechaFinOtraExperienciaLaboral1;
    }

    public Timestamp getFechaInicioOtraExperienciaLaboral1() {
        return fechaInicioOtraExperienciaLaboral1;
    }

    public String getMunicipioOtraExperienciaLaboral1() {
        return municipioOtraExperienciaLaboral1;
    }

    public String getDepartamentoOtraExperienciaLaboral1() {
        return departamentoOtraExperienciaLaboral1;
    }

    public Integer getCantidadAnnosOtraExperienciaLaboral1() {
        return cantidadAnnosOtraExperienciaLaboral1;
    }

    public String getInstitucionOtraExperienciaLaboral1() {
        return institucionOtraExperienciaLaboral1;
    }

    public Integer getEstado() {
        return estado;
    }

    public Boolean getInterino() {
        return interino;
    }

    public String getSector4() {
        return sector4;
    }

    public String getNombramiento4() {
        return nombramiento4;
    }

    public Timestamp getHasta4() {
        return hasta4;
    }

    public Timestamp getDesde4() {
        return desde4;
    }

    public String getMunicipio4() {
        return municipio4;
    }

    public String getDepartamento4() {
        return departamento4;
    }

    public Integer getCantidadDeAnnios4() {
        return cantidadDeAnnios4;
    }

    public String getInstitucionEducativaExtranjero4() {
        return institucionEducativaExtranjero4;
    }

    public String getInstitucionEducativaNacional4() {
        return institucionEducativaNacional4;
    }

    public String getSector3() {
        return sector3;
    }

    public String getNombramiento3() {
        return nombramiento3;
    }

    public Timestamp getHasta3() {
        return hasta3;
    }

    public Timestamp getDesde3() {
        return desde3;
    }

    public String getMunicipio3() {
        return municipio3;
    }

    public String getDepartamento3() {
        return departamento3;
    }

    public Integer getCantidadDeAnnios3() {
        return cantidadDeAnnios3;
    }

    public String getInstitucionEducativaExtranjero3() {
        return institucionEducativaExtranjero3;
    }

    public String getInstitucionEducativaNacional3() {
        return institucionEducativaNacional3;
    }

    public String getSector2() {
        return sector2;
    }

    public String getNombramiento2() {
        return nombramiento2;
    }

    public Timestamp getHasta2() {
        return hasta2;
    }

    public Timestamp getDesde2() {
        return desde2;
    }

    public String getMunicipio2() {
        return municipio2;
    }

    public String getDepartamento2() {
        return departamento2;
    }

    public Integer getCantidadDeAnnios2() {
        return cantidadDeAnnios2;
    }

    public String getInstitucionEducativaExtranjero2() {
        return institucionEducativaExtranjero2;
    }

    public String getInstitucionEducativaNacional2() {
        return institucionEducativaNacional2;
    }

    public String getSector1() {
        return sector1;
    }

    public String getNombramiento1() {
        return nombramiento1;
    }

    public Timestamp getHasta1() {
        return hasta1;
    }

    public Timestamp getDesde1() {
        return desde1;
    }

    public String getMunicipio1() {
        return municipio1;
    }

    public String getDepartamento1() {
        return departamento1;
    }

    public Integer getCantidadDeAnnios1() {
        return cantidadDeAnnios1;
    }

    public String getInstitucionEducativaExtranjero1() {
        return institucionEducativaExtranjero1;
    }

    public String getInstitucionEducativaNacional1() {
        return institucionEducativaNacional1;
    }

    public String getDiplomaObtenido5() {
        return diplomaObtenido5;
    }

    public String getPais5() {
        return pais5;
    }

    public Timestamp getFechaFinalizacion5() {
        return fechaFinalizacion5;
    }

    public Timestamp getFechaInicio5() {
        return fechaInicio5;
    }

    public String getInstitucion5() {
        return institucion5;
    }

    public Integer getCantidadHoras5() {
        return cantidadHoras5;
    }

    public String getNombreCapacitacion5() {
        return nombreCapacitacion5;
    }

    public String getDiplomaObtenido4() {
        return diplomaObtenido4;
    }

    public String getPais4() {
        return pais4;
    }

    public Timestamp getFechaFinalizacion4() {
        return fechaFinalizacion4;
    }

    public Timestamp getFechaInicio4() {
        return fechaInicio4;
    }

    public String getInstitucion4() {
        return institucion4;
    }

    public Integer getCantidadHoras4() {
        return cantidadHoras4;
    }

    public String getNombreCapacitacion4() {
        return nombreCapacitacion4;
    }

    public String getDiplomaObtenido3() {
        return diplomaObtenido3;
    }

    public String getPais3() {
        return pais3;
    }

    public Timestamp getFechaFinalizacion3() {
        return fechaFinalizacion3;
    }

    public Timestamp getFechaInicio3() {
        return fechaInicio3;
    }

    public String getInstitucion3() {
        return institucion3;
    }

    public Integer getCantidadHoras3() {
        return cantidadHoras3;
    }

    public String getNombreCapacitacion3() {
        return nombreCapacitacion3;
    }

    public String getDiplomaObtenido2() {
        return diplomaObtenido2;
    }

    public String getPais2() {
        return pais2;
    }

    public Timestamp getFechaFinalizacion2() {
        return fechaFinalizacion2;
    }

    public Timestamp getFechaInicio2() {
        return fechaInicio2;
    }

    public String getInstitucion2() {
        return institucion2;
    }

    public Integer getCantidadHoras2() {
        return cantidadHoras2;
    }

    public String getNombreCapacitacion2() {
        return nombreCapacitacion2;
    }

    public String getDiplomaObtenido1() {
        return diplomaObtenido1;
    }

    public String getPais1() {
        return pais1;
    }

    public Timestamp getFechaFinalizacion1() {
        return fechaFinalizacion1;
    }

    public Timestamp getFechaInicio1() {
        return fechaInicio1;
    }

    public String getInstitucion1() {
        return institucion1;
    }

    public Integer getCantidadHoras1() {
        return cantidadHoras1;
    }

    public String getNombreCapacitacion1() {
        return nombreCapacitacion1;
    }

    public String getAnnioDeGraduacion4() {
        return annioDeGraduacion4;
    }

    public String getInstitucionEducativa4() {
        return institucionEducativa4;
    }

    public String getEspecialidad4() {
        return especialidad4;
    }

    public String getGradoAcademico4() {
        return gradoAcademico4;
    }

    public String getAnnioDeGraduacion3() {
        return annioDeGraduacion3;
    }

    public String getInstitucionEducativa3() {
        return institucionEducativa3;
    }

    public String getEspecialidad3() {
        return especialidad3;
    }

    public String getGradoAcademico3() {
        return gradoAcademico3;
    }

    public String getAnnioDeGraduacion2() {
        return annioDeGraduacion2;
    }

    public String getInstitucionEducativa2() {
        return institucionEducativa2;
    }

    public String getEspecialidad2() {
        return especialidad2;
    }

    public String getGradoAcademico2() {
        return gradoAcademico2;
    }

    public String getAnnioDeGraduacion1() {
        return annioDeGraduacion1;
    }

    public String getInstitucionEducativa1() {
        return institucionEducativa1;
    }

    public String getEspecialidad1() {
        return especialidad1;
    }

    public String getGradoAcademico1() {
        return gradoAcademico1;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public String getNivelDocente() {
        return nivelDocente;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDui() {
        return dui;
    }

    public String getNip() {
        return nip;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDireccionActualDeResidencia() {
        return direccionActualDeResidencia;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getEmailSegunRegistroPlataforma() {
        return emailSegunRegistroPlataforma;
    }

    public String getNombreCompletoSegunRegistroPlataforma() {
        return nombreCompletoSegunRegistroPlataforma;
    }

    public Integer getCodigoDeTipoDeTramite() {
        return codigoDeTipoDeTramite;
    }

    public Integer getCodigoDeSolicitante() {
        return codigoDeSolicitante;
    }

    public Long getCodigoDeTramite() {
        return codigoDeTramite;
    }

    public Boolean getDatosValidosOtraExperienciaLaboral2() {
        return datosValidosOtraExperienciaLaboral2;
    }

    public void setDatosValidosOtraExperienciaLaboral2(Boolean datosValidosOtraExperienciaLaboral2) {
        this.datosValidosOtraExperienciaLaboral2 = datosValidosOtraExperienciaLaboral2;
    }
}