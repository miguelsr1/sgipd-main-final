package sv.gob.mined.projects.sgipd.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Nuevos_datos_expedientes")
public class NuevosDatosExpediente {
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

    public void setFaseActualSigob(Integer faseActualSigob) {
        this.faseActualSigob = faseActualSigob;
    }

    public Boolean getValidacionDeInterino() {
        return validacionDeInterino;
    }

    public void setValidacionDeInterino(Boolean validacionDeInterino) {
        this.validacionDeInterino = validacionDeInterino;
    }

    public Boolean getDatosValidosOtraExperienciaLaboral3() {
        return datosValidosOtraExperienciaLaboral3;
    }

    public void setDatosValidosOtraExperienciaLaboral3(Boolean datosValidosOtraExperienciaLaboral3) {
        this.datosValidosOtraExperienciaLaboral3 = datosValidosOtraExperienciaLaboral3;
    }

    public Timestamp getFechaFinCorregidaOtraExperienciaLaboral3() {
        return fechaFinCorregidaOtraExperienciaLaboral3;
    }

    public void setFechaFinCorregidaOtraExperienciaLaboral3(Timestamp fechaFinCorregidaOtraExperienciaLaboral3) {
        this.fechaFinCorregidaOtraExperienciaLaboral3 = fechaFinCorregidaOtraExperienciaLaboral3;
    }

    public Timestamp getFechaInicioCorregidaOtraExperienciaLaboral3() {
        return fechaInicioCorregidaOtraExperienciaLaboral3;
    }

    public void setFechaInicioCorregidaOtraExperienciaLaboral3(Timestamp fechaInicioCorregidaOtraExperienciaLaboral3) {
        this.fechaInicioCorregidaOtraExperienciaLaboral3 = fechaInicioCorregidaOtraExperienciaLaboral3;
    }

    public Timestamp getFechaFinCorregidaOtraExperienciaLaboral2() {
        return fechaFinCorregidaOtraExperienciaLaboral2;
    }

    public void setFechaFinCorregidaOtraExperienciaLaboral2(Timestamp fechaFinCorregidaOtraExperienciaLaboral2) {
        this.fechaFinCorregidaOtraExperienciaLaboral2 = fechaFinCorregidaOtraExperienciaLaboral2;
    }

    public Timestamp getFechaInicioCorregidaOtraExperienciaLaboral2() {
        return fechaInicioCorregidaOtraExperienciaLaboral2;
    }

    public void setFechaInicioCorregidaOtraExperienciaLaboral2(Timestamp fechaInicioCorregidaOtraExperienciaLaboral2) {
        this.fechaInicioCorregidaOtraExperienciaLaboral2 = fechaInicioCorregidaOtraExperienciaLaboral2;
    }

    public Boolean getDatosValidosOtraExperienciaLaboral1() {
        return datosValidosOtraExperienciaLaboral1;
    }

    public void setDatosValidosOtraExperienciaLaboral1(Boolean datosValidosOtraExperienciaLaboral1) {
        this.datosValidosOtraExperienciaLaboral1 = datosValidosOtraExperienciaLaboral1;
    }

    public Timestamp getFechaFinCorregidaOtraExperienciaLaboral1() {
        return fechaFinCorregidaOtraExperienciaLaboral1;
    }

    public void setFechaFinCorregidaOtraExperienciaLaboral1(Timestamp fechaFinCorregidaOtraExperienciaLaboral1) {
        this.fechaFinCorregidaOtraExperienciaLaboral1 = fechaFinCorregidaOtraExperienciaLaboral1;
    }

    public Timestamp getFechaInicioCorregidaOtraExperienciaLaboral1() {
        return fechaInicioCorregidaOtraExperienciaLaboral1;
    }

    public void setFechaInicioCorregidaOtraExperienciaLaboral1(Timestamp fechaInicioCorregidaOtraExperienciaLaboral1) {
        this.fechaInicioCorregidaOtraExperienciaLaboral1 = fechaInicioCorregidaOtraExperienciaLaboral1;
    }

    public Boolean getDatosValidosExperienciaLaboral4() {
        return datosValidosExperienciaLaboral4;
    }

    public void setDatosValidosExperienciaLaboral4(Boolean datosValidosExperienciaLaboral4) {
        this.datosValidosExperienciaLaboral4 = datosValidosExperienciaLaboral4;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral4() {
        return fechaFinCorregidaExperienciaLaboral4;
    }

    public void setFechaFinCorregidaExperienciaLaboral4(Timestamp fechaFinCorregidaExperienciaLaboral4) {
        this.fechaFinCorregidaExperienciaLaboral4 = fechaFinCorregidaExperienciaLaboral4;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral4() {
        return fechaInicioCorregidaExperienciaLaboral4;
    }

    public void setFechaInicioCorregidaExperienciaLaboral4(Timestamp fechaInicioCorregidaExperienciaLaboral4) {
        this.fechaInicioCorregidaExperienciaLaboral4 = fechaInicioCorregidaExperienciaLaboral4;
    }

    public Boolean getDatosValidosExperienciaLaboral3() {
        return datosValidosExperienciaLaboral3;
    }

    public void setDatosValidosExperienciaLaboral3(Boolean datosValidosExperienciaLaboral3) {
        this.datosValidosExperienciaLaboral3 = datosValidosExperienciaLaboral3;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral3() {
        return fechaFinCorregidaExperienciaLaboral3;
    }

    public void setFechaFinCorregidaExperienciaLaboral3(Timestamp fechaFinCorregidaExperienciaLaboral3) {
        this.fechaFinCorregidaExperienciaLaboral3 = fechaFinCorregidaExperienciaLaboral3;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral3() {
        return fechaInicioCorregidaExperienciaLaboral3;
    }

    public void setFechaInicioCorregidaExperienciaLaboral3(Timestamp fechaInicioCorregidaExperienciaLaboral3) {
        this.fechaInicioCorregidaExperienciaLaboral3 = fechaInicioCorregidaExperienciaLaboral3;
    }

    public Boolean getDatosValidosExperienciaLaboral2() {
        return datosValidosExperienciaLaboral2;
    }

    public void setDatosValidosExperienciaLaboral2(Boolean datosValidosExperienciaLaboral2) {
        this.datosValidosExperienciaLaboral2 = datosValidosExperienciaLaboral2;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral2() {
        return fechaFinCorregidaExperienciaLaboral2;
    }

    public void setFechaFinCorregidaExperienciaLaboral2(Timestamp fechaFinCorregidaExperienciaLaboral2) {
        this.fechaFinCorregidaExperienciaLaboral2 = fechaFinCorregidaExperienciaLaboral2;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral2() {
        return fechaInicioCorregidaExperienciaLaboral2;
    }

    public void setFechaInicioCorregidaExperienciaLaboral2(Timestamp fechaInicioCorregidaExperienciaLaboral2) {
        this.fechaInicioCorregidaExperienciaLaboral2 = fechaInicioCorregidaExperienciaLaboral2;
    }

    public Boolean getDatosValidosExperienciaLaboral1() {
        return datosValidosExperienciaLaboral1;
    }

    public void setDatosValidosExperienciaLaboral1(Boolean datosValidosExperienciaLaboral1) {
        this.datosValidosExperienciaLaboral1 = datosValidosExperienciaLaboral1;
    }

    public Timestamp getFechaFinCorregidaExperienciaLaboral1() {
        return fechaFinCorregidaExperienciaLaboral1;
    }

    public void setFechaFinCorregidaExperienciaLaboral1(Timestamp fechaFinCorregidaExperienciaLaboral1) {
        this.fechaFinCorregidaExperienciaLaboral1 = fechaFinCorregidaExperienciaLaboral1;
    }

    public Timestamp getFechaInicioCorregidaExperienciaLaboral1() {
        return fechaInicioCorregidaExperienciaLaboral1;
    }

    public void setFechaInicioCorregidaExperienciaLaboral1(Timestamp fechaInicioCorregidaExperienciaLaboral1) {
        this.fechaInicioCorregidaExperienciaLaboral1 = fechaInicioCorregidaExperienciaLaboral1;
    }

    public String getPlazasHomologadasCapacitaciones5() {
        return plazasHomologadasCapacitaciones5;
    }

    public void setPlazasHomologadasCapacitaciones5(String plazasHomologadasCapacitaciones5) {
        this.plazasHomologadasCapacitaciones5 = plazasHomologadasCapacitaciones5;
    }

    public String getPlazasHomologadasCapacitaciones4() {
        return plazasHomologadasCapacitaciones4;
    }

    public void setPlazasHomologadasCapacitaciones4(String plazasHomologadasCapacitaciones4) {
        this.plazasHomologadasCapacitaciones4 = plazasHomologadasCapacitaciones4;
    }

    public String getPlazasHomologadasCapacitaciones3() {
        return plazasHomologadasCapacitaciones3;
    }

    public void setPlazasHomologadasCapacitaciones3(String plazasHomologadasCapacitaciones3) {
        this.plazasHomologadasCapacitaciones3 = plazasHomologadasCapacitaciones3;
    }

    public String getPlazasHomologadasCapacitaciones2() {
        return plazasHomologadasCapacitaciones2;
    }

    public void setPlazasHomologadasCapacitaciones2(String plazasHomologadasCapacitaciones2) {
        this.plazasHomologadasCapacitaciones2 = plazasHomologadasCapacitaciones2;
    }

    public String getPlazasHomologadasCapacitaciones1() {
        return plazasHomologadasCapacitaciones1;
    }

    public void setPlazasHomologadasCapacitaciones1(String plazasHomologadasCapacitaciones1) {
        this.plazasHomologadasCapacitaciones1 = plazasHomologadasCapacitaciones1;
    }

    public Boolean getDatosValidosEstudiosRealizados4() {
        return datosValidosEstudiosRealizados4;
    }

    public void setDatosValidosEstudiosRealizados4(Boolean datosValidosEstudiosRealizados4) {
        this.datosValidosEstudiosRealizados4 = datosValidosEstudiosRealizados4;
    }

    public String getPlazasHomologadasEstudiosRealizados4() {
        return plazasHomologadasEstudiosRealizados4;
    }

    public void setPlazasHomologadasEstudiosRealizados4(String plazasHomologadasEstudiosRealizados4) {
        this.plazasHomologadasEstudiosRealizados4 = plazasHomologadasEstudiosRealizados4;
    }

    public String getEspecialidadCorregida4() {
        return especialidadCorregida4;
    }

    public void setEspecialidadCorregida4(String especialidadCorregida4) {
        this.especialidadCorregida4 = especialidadCorregida4;
    }

    public Boolean getDatosValidosEstudiosRealizados3() {
        return datosValidosEstudiosRealizados3;
    }

    public void setDatosValidosEstudiosRealizados3(Boolean datosValidosEstudiosRealizados3) {
        this.datosValidosEstudiosRealizados3 = datosValidosEstudiosRealizados3;
    }

    public String getPlazasHomologadasEstudiosRealizados3() {
        return plazasHomologadasEstudiosRealizados3;
    }

    public void setPlazasHomologadasEstudiosRealizados3(String plazasHomologadasEstudiosRealizados3) {
        this.plazasHomologadasEstudiosRealizados3 = plazasHomologadasEstudiosRealizados3;
    }

    public String getEspecialidadCorregida3() {
        return especialidadCorregida3;
    }

    public void setEspecialidadCorregida3(String especialidadCorregida3) {
        this.especialidadCorregida3 = especialidadCorregida3;
    }

    public Boolean getDatosValidosEstudiosRealizados2() {
        return datosValidosEstudiosRealizados2;
    }

    public void setDatosValidosEstudiosRealizados2(Boolean datosValidosEstudiosRealizados2) {
        this.datosValidosEstudiosRealizados2 = datosValidosEstudiosRealizados2;
    }

    public String getPlazasHomologadasEstudiosRealizados2() {
        return plazasHomologadasEstudiosRealizados2;
    }

    public void setPlazasHomologadasEstudiosRealizados2(String plazasHomologadasEstudiosRealizados2) {
        this.plazasHomologadasEstudiosRealizados2 = plazasHomologadasEstudiosRealizados2;
    }

    public String getEspecialidadCorregida2() {
        return especialidadCorregida2;
    }

    public void setEspecialidadCorregida2(String especialidadCorregida2) {
        this.especialidadCorregida2 = especialidadCorregida2;
    }

    public Boolean getDatosValidosEstudiosRealizados1() {
        return datosValidosEstudiosRealizados1;
    }

    public void setDatosValidosEstudiosRealizados1(Boolean datosValidosEstudiosRealizados1) {
        this.datosValidosEstudiosRealizados1 = datosValidosEstudiosRealizados1;
    }

    public String getPlazasHomologadasEstudiosRealizados1() {
        return plazasHomologadasEstudiosRealizados1;
    }

    public void setPlazasHomologadasEstudiosRealizados1(String plazasHomologadasEstudiosRealizados1) {
        this.plazasHomologadasEstudiosRealizados1 = plazasHomologadasEstudiosRealizados1;
    }

    public String getEspecialidadCorregida1() {
        return especialidadCorregida1;
    }

    public void setEspecialidadCorregida1(String especialidadCorregida1) {
        this.especialidadCorregida1 = especialidadCorregida1;
    }

    public String getDuiVerificado() {
        return duiVerificado;
    }

    public void setDuiVerificado(String duiVerificado) {
        this.duiVerificado = duiVerificado;
    }

    public String getNipVerificado() {
        return nipVerificado;
    }

    public void setNipVerificado(String nipVerificado) {
        this.nipVerificado = nipVerificado;
    }

    public String getSectorOtraExperienciaLaboral3() {
        return sectorOtraExperienciaLaboral3;
    }

    public void setSectorOtraExperienciaLaboral3(String sectorOtraExperienciaLaboral3) {
        this.sectorOtraExperienciaLaboral3 = sectorOtraExperienciaLaboral3;
    }

    public Timestamp getFechaFinOtraExperienciaLaboral3() {
        return fechaFinOtraExperienciaLaboral3;
    }

    public void setFechaFinOtraExperienciaLaboral3(Timestamp fechaFinOtraExperienciaLaboral3) {
        this.fechaFinOtraExperienciaLaboral3 = fechaFinOtraExperienciaLaboral3;
    }

    public Timestamp getFechaInicioOtraExperienciaLaboral3() {
        return fechaInicioOtraExperienciaLaboral3;
    }

    public void setFechaInicioOtraExperienciaLaboral3(Timestamp fechaInicioOtraExperienciaLaboral3) {
        this.fechaInicioOtraExperienciaLaboral3 = fechaInicioOtraExperienciaLaboral3;
    }

    public String getMunicipioOtraExperienciaLaboral3() {
        return municipioOtraExperienciaLaboral3;
    }

    public void setMunicipioOtraExperienciaLaboral3(String municipioOtraExperienciaLaboral3) {
        this.municipioOtraExperienciaLaboral3 = municipioOtraExperienciaLaboral3;
    }

    public String getDepartamentoOtraExperienciaLaboral3() {
        return departamentoOtraExperienciaLaboral3;
    }

    public void setDepartamentoOtraExperienciaLaboral3(String departamentoOtraExperienciaLaboral3) {
        this.departamentoOtraExperienciaLaboral3 = departamentoOtraExperienciaLaboral3;
    }

    public Integer getCantidadAnnosOtraExperienciaLaboral3() {
        return cantidadAnnosOtraExperienciaLaboral3;
    }

    public void setCantidadAnnosOtraExperienciaLaboral3(Integer cantidadAnnosOtraExperienciaLaboral3) {
        this.cantidadAnnosOtraExperienciaLaboral3 = cantidadAnnosOtraExperienciaLaboral3;
    }

    public String getInstitucionOtraExperienciaLaboral3() {
        return institucionOtraExperienciaLaboral3;
    }

    public void setInstitucionOtraExperienciaLaboral3(String institucionOtraExperienciaLaboral3) {
        this.institucionOtraExperienciaLaboral3 = institucionOtraExperienciaLaboral3;
    }

    public String getSectorOtraExperienciaLaboral2() {
        return sectorOtraExperienciaLaboral2;
    }

    public void setSectorOtraExperienciaLaboral2(String sectorOtraExperienciaLaboral2) {
        this.sectorOtraExperienciaLaboral2 = sectorOtraExperienciaLaboral2;
    }

    public Timestamp getFechaFinOtraExperienciaLaboral2() {
        return fechaFinOtraExperienciaLaboral2;
    }

    public void setFechaFinOtraExperienciaLaboral2(Timestamp fechaFinOtraExperienciaLaboral2) {
        this.fechaFinOtraExperienciaLaboral2 = fechaFinOtraExperienciaLaboral2;
    }

    public Timestamp getFechaInicioOtraExperienciaLaboral2() {
        return fechaInicioOtraExperienciaLaboral2;
    }

    public void setFechaInicioOtraExperienciaLaboral2(Timestamp fechaInicioOtraExperienciaLaboral2) {
        this.fechaInicioOtraExperienciaLaboral2 = fechaInicioOtraExperienciaLaboral2;
    }

    public String getMunicipioOtraExperienciaLaboral2() {
        return municipioOtraExperienciaLaboral2;
    }

    public void setMunicipioOtraExperienciaLaboral2(String municipioOtraExperienciaLaboral2) {
        this.municipioOtraExperienciaLaboral2 = municipioOtraExperienciaLaboral2;
    }

    public String getDepartamentoOtraExperienciaLaboral2() {
        return departamentoOtraExperienciaLaboral2;
    }

    public void setDepartamentoOtraExperienciaLaboral2(String departamentoOtraExperienciaLaboral2) {
        this.departamentoOtraExperienciaLaboral2 = departamentoOtraExperienciaLaboral2;
    }

    public Integer getCantidadAnnosOtraExperienciaLaboral2() {
        return cantidadAnnosOtraExperienciaLaboral2;
    }

    public void setCantidadAnnosOtraExperienciaLaboral2(Integer cantidadAnnosOtraExperienciaLaboral2) {
        this.cantidadAnnosOtraExperienciaLaboral2 = cantidadAnnosOtraExperienciaLaboral2;
    }

    public String getInstitucionOtraExperienciaLaboral2() {
        return institucionOtraExperienciaLaboral2;
    }

    public void setInstitucionOtraExperienciaLaboral2(String institucionOtraExperienciaLaboral2) {
        this.institucionOtraExperienciaLaboral2 = institucionOtraExperienciaLaboral2;
    }

    public String getSectorOtraExperienciaLaboral1() {
        return sectorOtraExperienciaLaboral1;
    }

    public void setSectorOtraExperienciaLaboral1(String sectorOtraExperienciaLaboral1) {
        this.sectorOtraExperienciaLaboral1 = sectorOtraExperienciaLaboral1;
    }

    public Timestamp getFechaFinOtraExperienciaLaboral1() {
        return fechaFinOtraExperienciaLaboral1;
    }

    public void setFechaFinOtraExperienciaLaboral1(Timestamp fechaFinOtraExperienciaLaboral1) {
        this.fechaFinOtraExperienciaLaboral1 = fechaFinOtraExperienciaLaboral1;
    }

    public Timestamp getFechaInicioOtraExperienciaLaboral1() {
        return fechaInicioOtraExperienciaLaboral1;
    }

    public void setFechaInicioOtraExperienciaLaboral1(Timestamp fechaInicioOtraExperienciaLaboral1) {
        this.fechaInicioOtraExperienciaLaboral1 = fechaInicioOtraExperienciaLaboral1;
    }

    public String getMunicipioOtraExperienciaLaboral1() {
        return municipioOtraExperienciaLaboral1;
    }

    public void setMunicipioOtraExperienciaLaboral1(String municipioOtraExperienciaLaboral1) {
        this.municipioOtraExperienciaLaboral1 = municipioOtraExperienciaLaboral1;
    }

    public String getDepartamentoOtraExperienciaLaboral1() {
        return departamentoOtraExperienciaLaboral1;
    }

    public void setDepartamentoOtraExperienciaLaboral1(String departamentoOtraExperienciaLaboral1) {
        this.departamentoOtraExperienciaLaboral1 = departamentoOtraExperienciaLaboral1;
    }

    public Integer getCantidadAnnosOtraExperienciaLaboral1() {
        return cantidadAnnosOtraExperienciaLaboral1;
    }

    public void setCantidadAnnosOtraExperienciaLaboral1(Integer cantidadAnnosOtraExperienciaLaboral1) {
        this.cantidadAnnosOtraExperienciaLaboral1 = cantidadAnnosOtraExperienciaLaboral1;
    }

    public String getInstitucionOtraExperienciaLaboral1() {
        return institucionOtraExperienciaLaboral1;
    }

    public void setInstitucionOtraExperienciaLaboral1(String institucionOtraExperienciaLaboral1) {
        this.institucionOtraExperienciaLaboral1 = institucionOtraExperienciaLaboral1;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Boolean getInterino() {
        return interino;
    }

    public void setInterino(Boolean interino) {
        this.interino = interino;
    }

    public String getSector4() {
        return sector4;
    }

    public void setSector4(String sector4) {
        this.sector4 = sector4;
    }

    public String getNombramiento4() {
        return nombramiento4;
    }

    public void setNombramiento4(String nombramiento4) {
        this.nombramiento4 = nombramiento4;
    }

    public Timestamp getHasta4() {
        return hasta4;
    }

    public void setHasta4(Timestamp hasta4) {
        this.hasta4 = hasta4;
    }

    public Timestamp getDesde4() {
        return desde4;
    }

    public void setDesde4(Timestamp desde4) {
        this.desde4 = desde4;
    }

    public String getMunicipio4() {
        return municipio4;
    }

    public void setMunicipio4(String municipio4) {
        this.municipio4 = municipio4;
    }

    public String getDepartamento4() {
        return departamento4;
    }

    public void setDepartamento4(String departamento4) {
        this.departamento4 = departamento4;
    }

    public Integer getCantidadDeAnnios4() {
        return cantidadDeAnnios4;
    }

    public void setCantidadDeAnnios4(Integer cantidadDeAnnios4) {
        this.cantidadDeAnnios4 = cantidadDeAnnios4;
    }

    public String getInstitucionEducativaExtranjero4() {
        return institucionEducativaExtranjero4;
    }

    public void setInstitucionEducativaExtranjero4(String institucionEducativaExtranjero4) {
        this.institucionEducativaExtranjero4 = institucionEducativaExtranjero4;
    }

    public String getInstitucionEducativaNacional4() {
        return institucionEducativaNacional4;
    }

    public void setInstitucionEducativaNacional4(String institucionEducativaNacional4) {
        this.institucionEducativaNacional4 = institucionEducativaNacional4;
    }

    public String getSector3() {
        return sector3;
    }

    public void setSector3(String sector3) {
        this.sector3 = sector3;
    }

    public String getNombramiento3() {
        return nombramiento3;
    }

    public void setNombramiento3(String nombramiento3) {
        this.nombramiento3 = nombramiento3;
    }

    public Timestamp getHasta3() {
        return hasta3;
    }

    public void setHasta3(Timestamp hasta3) {
        this.hasta3 = hasta3;
    }

    public Timestamp getDesde3() {
        return desde3;
    }

    public void setDesde3(Timestamp desde3) {
        this.desde3 = desde3;
    }

    public String getMunicipio3() {
        return municipio3;
    }

    public void setMunicipio3(String municipio3) {
        this.municipio3 = municipio3;
    }

    public String getDepartamento3() {
        return departamento3;
    }

    public void setDepartamento3(String departamento3) {
        this.departamento3 = departamento3;
    }

    public Integer getCantidadDeAnnios3() {
        return cantidadDeAnnios3;
    }

    public void setCantidadDeAnnios3(Integer cantidadDeAnnios3) {
        this.cantidadDeAnnios3 = cantidadDeAnnios3;
    }

    public String getInstitucionEducativaExtranjero3() {
        return institucionEducativaExtranjero3;
    }

    public void setInstitucionEducativaExtranjero3(String institucionEducativaExtranjero3) {
        this.institucionEducativaExtranjero3 = institucionEducativaExtranjero3;
    }

    public String getInstitucionEducativaNacional3() {
        return institucionEducativaNacional3;
    }

    public void setInstitucionEducativaNacional3(String institucionEducativaNacional3) {
        this.institucionEducativaNacional3 = institucionEducativaNacional3;
    }

    public String getSector2() {
        return sector2;
    }

    public void setSector2(String sector2) {
        this.sector2 = sector2;
    }

    public String getNombramiento2() {
        return nombramiento2;
    }

    public void setNombramiento2(String nombramiento2) {
        this.nombramiento2 = nombramiento2;
    }

    public Timestamp getHasta2() {
        return hasta2;
    }

    public void setHasta2(Timestamp hasta2) {
        this.hasta2 = hasta2;
    }

    public Timestamp getDesde2() {
        return desde2;
    }

    public void setDesde2(Timestamp desde2) {
        this.desde2 = desde2;
    }

    public String getMunicipio2() {
        return municipio2;
    }

    public void setMunicipio2(String municipio2) {
        this.municipio2 = municipio2;
    }

    public String getDepartamento2() {
        return departamento2;
    }

    public void setDepartamento2(String departamento2) {
        this.departamento2 = departamento2;
    }

    public Integer getCantidadDeAnnios2() {
        return cantidadDeAnnios2;
    }

    public void setCantidadDeAnnios2(Integer cantidadDeAnnios2) {
        this.cantidadDeAnnios2 = cantidadDeAnnios2;
    }

    public String getInstitucionEducativaExtranjero2() {
        return institucionEducativaExtranjero2;
    }

    public void setInstitucionEducativaExtranjero2(String institucionEducativaExtranjero2) {
        this.institucionEducativaExtranjero2 = institucionEducativaExtranjero2;
    }

    public String getInstitucionEducativaNacional2() {
        return institucionEducativaNacional2;
    }

    public void setInstitucionEducativaNacional2(String institucionEducativaNacional2) {
        this.institucionEducativaNacional2 = institucionEducativaNacional2;
    }

    public String getSector1() {
        return sector1;
    }

    public void setSector1(String sector1) {
        this.sector1 = sector1;
    }

    public String getNombramiento1() {
        return nombramiento1;
    }

    public void setNombramiento1(String nombramiento1) {
        this.nombramiento1 = nombramiento1;
    }

    public Timestamp getHasta1() {
        return hasta1;
    }

    public void setHasta1(Timestamp hasta1) {
        this.hasta1 = hasta1;
    }

    public Timestamp getDesde1() {
        return desde1;
    }

    public void setDesde1(Timestamp desde1) {
        this.desde1 = desde1;
    }

    public String getMunicipio1() {
        return municipio1;
    }

    public void setMunicipio1(String municipio1) {
        this.municipio1 = municipio1;
    }

    public String getDepartamento1() {
        return departamento1;
    }

    public void setDepartamento1(String departamento1) {
        this.departamento1 = departamento1;
    }

    public Integer getCantidadDeAnnios1() {
        return cantidadDeAnnios1;
    }

    public void setCantidadDeAnnios1(Integer cantidadDeAnnios1) {
        this.cantidadDeAnnios1 = cantidadDeAnnios1;
    }

    public String getInstitucionEducativaExtranjero1() {
        return institucionEducativaExtranjero1;
    }

    public void setInstitucionEducativaExtranjero1(String institucionEducativaExtranjero1) {
        this.institucionEducativaExtranjero1 = institucionEducativaExtranjero1;
    }

    public String getInstitucionEducativaNacional1() {
        return institucionEducativaNacional1;
    }

    public void setInstitucionEducativaNacional1(String institucionEducativaNacional1) {
        this.institucionEducativaNacional1 = institucionEducativaNacional1;
    }

    public String getDiplomaObtenido5() {
        return diplomaObtenido5;
    }

    public void setDiplomaObtenido5(String diplomaObtenido5) {
        this.diplomaObtenido5 = diplomaObtenido5;
    }

    public String getPais5() {
        return pais5;
    }

    public void setPais5(String pais5) {
        this.pais5 = pais5;
    }

    public Timestamp getFechaFinalizacion5() {
        return fechaFinalizacion5;
    }

    public void setFechaFinalizacion5(Timestamp fechaFinalizacion5) {
        this.fechaFinalizacion5 = fechaFinalizacion5;
    }

    public Timestamp getFechaInicio5() {
        return fechaInicio5;
    }

    public void setFechaInicio5(Timestamp fechaInicio5) {
        this.fechaInicio5 = fechaInicio5;
    }

    public String getInstitucion5() {
        return institucion5;
    }

    public void setInstitucion5(String institucion5) {
        this.institucion5 = institucion5;
    }

    public Integer getCantidadHoras5() {
        return cantidadHoras5;
    }

    public void setCantidadHoras5(Integer cantidadHoras5) {
        this.cantidadHoras5 = cantidadHoras5;
    }

    public String getNombreCapacitacion5() {
        return nombreCapacitacion5;
    }

    public void setNombreCapacitacion5(String nombreCapacitacion5) {
        this.nombreCapacitacion5 = nombreCapacitacion5;
    }

    public String getDiplomaObtenido4() {
        return diplomaObtenido4;
    }

    public void setDiplomaObtenido4(String diplomaObtenido4) {
        this.diplomaObtenido4 = diplomaObtenido4;
    }

    public String getPais4() {
        return pais4;
    }

    public void setPais4(String pais4) {
        this.pais4 = pais4;
    }

    public Timestamp getFechaFinalizacion4() {
        return fechaFinalizacion4;
    }

    public void setFechaFinalizacion4(Timestamp fechaFinalizacion4) {
        this.fechaFinalizacion4 = fechaFinalizacion4;
    }

    public Timestamp getFechaInicio4() {
        return fechaInicio4;
    }

    public void setFechaInicio4(Timestamp fechaInicio4) {
        this.fechaInicio4 = fechaInicio4;
    }

    public String getInstitucion4() {
        return institucion4;
    }

    public void setInstitucion4(String institucion4) {
        this.institucion4 = institucion4;
    }

    public Integer getCantidadHoras4() {
        return cantidadHoras4;
    }

    public void setCantidadHoras4(Integer cantidadHoras4) {
        this.cantidadHoras4 = cantidadHoras4;
    }

    public String getNombreCapacitacion4() {
        return nombreCapacitacion4;
    }

    public void setNombreCapacitacion4(String nombreCapacitacion4) {
        this.nombreCapacitacion4 = nombreCapacitacion4;
    }

    public String getDiplomaObtenido3() {
        return diplomaObtenido3;
    }

    public void setDiplomaObtenido3(String diplomaObtenido3) {
        this.diplomaObtenido3 = diplomaObtenido3;
    }

    public String getPais3() {
        return pais3;
    }

    public void setPais3(String pais3) {
        this.pais3 = pais3;
    }

    public Timestamp getFechaFinalizacion3() {
        return fechaFinalizacion3;
    }

    public void setFechaFinalizacion3(Timestamp fechaFinalizacion3) {
        this.fechaFinalizacion3 = fechaFinalizacion3;
    }

    public Timestamp getFechaInicio3() {
        return fechaInicio3;
    }

    public void setFechaInicio3(Timestamp fechaInicio3) {
        this.fechaInicio3 = fechaInicio3;
    }

    public String getInstitucion3() {
        return institucion3;
    }

    public void setInstitucion3(String institucion3) {
        this.institucion3 = institucion3;
    }

    public Integer getCantidadHoras3() {
        return cantidadHoras3;
    }

    public void setCantidadHoras3(Integer cantidadHoras3) {
        this.cantidadHoras3 = cantidadHoras3;
    }

    public String getNombreCapacitacion3() {
        return nombreCapacitacion3;
    }

    public void setNombreCapacitacion3(String nombreCapacitacion3) {
        this.nombreCapacitacion3 = nombreCapacitacion3;
    }

    public String getDiplomaObtenido2() {
        return diplomaObtenido2;
    }

    public void setDiplomaObtenido2(String diplomaObtenido2) {
        this.diplomaObtenido2 = diplomaObtenido2;
    }

    public String getPais2() {
        return pais2;
    }

    public void setPais2(String pais2) {
        this.pais2 = pais2;
    }

    public Timestamp getFechaFinalizacion2() {
        return fechaFinalizacion2;
    }

    public void setFechaFinalizacion2(Timestamp fechaFinalizacion2) {
        this.fechaFinalizacion2 = fechaFinalizacion2;
    }

    public Timestamp getFechaInicio2() {
        return fechaInicio2;
    }

    public void setFechaInicio2(Timestamp fechaInicio2) {
        this.fechaInicio2 = fechaInicio2;
    }

    public String getInstitucion2() {
        return institucion2;
    }

    public void setInstitucion2(String institucion2) {
        this.institucion2 = institucion2;
    }

    public Integer getCantidadHoras2() {
        return cantidadHoras2;
    }

    public void setCantidadHoras2(Integer cantidadHoras2) {
        this.cantidadHoras2 = cantidadHoras2;
    }

    public String getNombreCapacitacion2() {
        return nombreCapacitacion2;
    }

    public void setNombreCapacitacion2(String nombreCapacitacion2) {
        this.nombreCapacitacion2 = nombreCapacitacion2;
    }

    public String getDiplomaObtenido1() {
        return diplomaObtenido1;
    }

    public void setDiplomaObtenido1(String diplomaObtenido1) {
        this.diplomaObtenido1 = diplomaObtenido1;
    }

    public String getPais1() {
        return pais1;
    }

    public void setPais1(String pais1) {
        this.pais1 = pais1;
    }

    public Timestamp getFechaFinalizacion1() {
        return fechaFinalizacion1;
    }

    public void setFechaFinalizacion1(Timestamp fechaFinalizacion1) {
        this.fechaFinalizacion1 = fechaFinalizacion1;
    }

    public Timestamp getFechaInicio1() {
        return fechaInicio1;
    }

    public void setFechaInicio1(Timestamp fechaInicio1) {
        this.fechaInicio1 = fechaInicio1;
    }

    public String getInstitucion1() {
        return institucion1;
    }

    public void setInstitucion1(String institucion1) {
        this.institucion1 = institucion1;
    }

    public Integer getCantidadHoras1() {
        return cantidadHoras1;
    }

    public void setCantidadHoras1(Integer cantidadHoras1) {
        this.cantidadHoras1 = cantidadHoras1;
    }

    public String getNombreCapacitacion1() {
        return nombreCapacitacion1;
    }

    public void setNombreCapacitacion1(String nombreCapacitacion1) {
        this.nombreCapacitacion1 = nombreCapacitacion1;
    }

    public String getAnnioDeGraduacion4() {
        return annioDeGraduacion4;
    }

    public void setAnnioDeGraduacion4(String annioDeGraduacion4) {
        this.annioDeGraduacion4 = annioDeGraduacion4;
    }

    public String getInstitucionEducativa4() {
        return institucionEducativa4;
    }

    public void setInstitucionEducativa4(String institucionEducativa4) {
        this.institucionEducativa4 = institucionEducativa4;
    }

    public String getEspecialidad4() {
        return especialidad4;
    }

    public void setEspecialidad4(String especialidad4) {
        this.especialidad4 = especialidad4;
    }

    public String getGradoAcademico4() {
        return gradoAcademico4;
    }

    public void setGradoAcademico4(String gradoAcademico4) {
        this.gradoAcademico4 = gradoAcademico4;
    }

    public String getAnnioDeGraduacion3() {
        return annioDeGraduacion3;
    }

    public void setAnnioDeGraduacion3(String annioDeGraduacion3) {
        this.annioDeGraduacion3 = annioDeGraduacion3;
    }

    public String getInstitucionEducativa3() {
        return institucionEducativa3;
    }

    public void setInstitucionEducativa3(String institucionEducativa3) {
        this.institucionEducativa3 = institucionEducativa3;
    }

    public String getEspecialidad3() {
        return especialidad3;
    }

    public void setEspecialidad3(String especialidad3) {
        this.especialidad3 = especialidad3;
    }

    public String getGradoAcademico3() {
        return gradoAcademico3;
    }

    public void setGradoAcademico3(String gradoAcademico3) {
        this.gradoAcademico3 = gradoAcademico3;
    }

    public String getAnnioDeGraduacion2() {
        return annioDeGraduacion2;
    }

    public void setAnnioDeGraduacion2(String annioDeGraduacion2) {
        this.annioDeGraduacion2 = annioDeGraduacion2;
    }

    public String getInstitucionEducativa2() {
        return institucionEducativa2;
    }

    public void setInstitucionEducativa2(String institucionEducativa2) {
        this.institucionEducativa2 = institucionEducativa2;
    }

    public String getEspecialidad2() {
        return especialidad2;
    }

    public void setEspecialidad2(String especialidad2) {
        this.especialidad2 = especialidad2;
    }

    public String getGradoAcademico2() {
        return gradoAcademico2;
    }

    public void setGradoAcademico2(String gradoAcademico2) {
        this.gradoAcademico2 = gradoAcademico2;
    }

    public String getAnnioDeGraduacion1() {
        return annioDeGraduacion1;
    }

    public void setAnnioDeGraduacion1(String annioDeGraduacion1) {
        this.annioDeGraduacion1 = annioDeGraduacion1;
    }

    public String getInstitucionEducativa1() {
        return institucionEducativa1;
    }

    public void setInstitucionEducativa1(String institucionEducativa1) {
        this.institucionEducativa1 = institucionEducativa1;
    }

    public String getEspecialidad1() {
        return especialidad1;
    }

    public void setEspecialidad1(String especialidad1) {
        this.especialidad1 = especialidad1;
    }

    public String getGradoAcademico1() {
        return gradoAcademico1;
    }

    public void setGradoAcademico1(String gradoAcademico1) {
        this.gradoAcademico1 = gradoAcademico1;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getNivelDocente() {
        return nivelDocente;
    }

    public void setNivelDocente(String nivelDocente) {
        this.nivelDocente = nivelDocente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccionActualDeResidencia() {
        return direccionActualDeResidencia;
    }

    public void setDireccionActualDeResidencia(String direccionActualDeResidencia) {
        this.direccionActualDeResidencia = direccionActualDeResidencia;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmailSegunRegistroPlataforma() {
        return emailSegunRegistroPlataforma;
    }

    public void setEmailSegunRegistroPlataforma(String emailSegunRegistroPlataforma) {
        this.emailSegunRegistroPlataforma = emailSegunRegistroPlataforma;
    }

    public String getNombreCompletoSegunRegistroPlataforma() {
        return nombreCompletoSegunRegistroPlataforma;
    }

    public void setNombreCompletoSegunRegistroPlataforma(String nombreCompletoSegunRegistroPlataforma) {
        this.nombreCompletoSegunRegistroPlataforma = nombreCompletoSegunRegistroPlataforma;
    }

    public Integer getCodigoDeTipoDeTramite() {
        return codigoDeTipoDeTramite;
    }

    public void setCodigoDeTipoDeTramite(Integer codigoDeTipoDeTramite) {
        this.codigoDeTipoDeTramite = codigoDeTipoDeTramite;
    }

    public Integer getCodigoDeSolicitante() {
        return codigoDeSolicitante;
    }

    public void setCodigoDeSolicitante(Integer codigoDeSolicitante) {
        this.codigoDeSolicitante = codigoDeSolicitante;
    }

    public Long getCodigoDeTramite() {
        return codigoDeTramite;
    }

    public void setCodigoDeTramite(Long codigoDeTramite) {
        this.codigoDeTramite = codigoDeTramite;
    }

    public Boolean getDatosValidosOtraExperienciaLaboral2() {
        return datosValidosOtraExperienciaLaboral2;
    }

    public void setDatosValidosOtraExperienciaLaboral2(Boolean datosValidosOtraExperienciaLaboral2) {
        this.datosValidosOtraExperienciaLaboral2 = datosValidosOtraExperienciaLaboral2;
    }
}