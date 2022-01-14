package sv.gob.mined.projects.sgipd.services;


import sv.gob.mined.projects.sgipd.dtos.IngresoCalificacionDTO;
import sv.gob.mined.projects.sgipd.entities.CentroEducativo;
import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio2;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio2V2;
import sv.gob.mined.projects.sgipd.repositories.*;
import sv.gob.mined.projects.sgipd.repositories.enums.IngresoCalificacionEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.TipoPrueba;
import sv.gob.mined.projects.sgipd.services.enums.Criterio2ServiceEnum;
import sv.gob.mined.projects.sgipd.utils.ExcelUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class Criterio2V2Service {


    @Inject
    private DepartamentoRepository departamentoRepository;
    @Inject
    private MunicipioRepository municipioRepository;
    @Inject
    private CentroEducativoRepository centroEducativoRepository;
    @Inject
    private DocenteAplicacionRepository docenteAplicacionRepository;
    @Inject
    private CalificacionRepository calificacionRepository;
    @Inject
    private ExcelUtil excelUtil;
    @Inject
    private ReporteCriterio2V2Service reporteCriterio2V2Service;


    /**
     * Encontrar todos los departamentos de El Salvador
     * @return List<Departamento>
     */
    public List<Departamento> findAllDepartamentos(){
        return departamentoRepository.findAllDepartamentos();
    }

    /**
     * Encontrar todos los departamentos de El Salvador y el departamento no definido
     * @return
     */
    public List<Departamento> findAllNoFilter(){
        return departamentoRepository.findAllNoFilter();
    }

    /**
     * Encontrar todos los municipios para un idDepartamento dado
     * @param idDepartamento (Código del Departamento)
     * @return List<Municipio>
     */
    public List<Municipio> findAllMunicipiosByDepartamento(long idDepartamento){
        return municipioRepository.findAllMunicipiosByDepartamento(idDepartamento);
    }

    /**
     * Encontrar todos los centros escolares para un idMunicipio dado
     * @param idMunicipio (Código del Municipio)
     * @return List<CentroEducativo>
     */
    public List<CentroEducativo> findByMunicipio(long idMunicipio){
        return centroEducativoRepository.findByMunicipio(idMunicipio);
    }

    /**
     * Obtiene un listado filtrado con la información correspondiente para ingreso de calificaciones
     * @param criteria criterio de filtro para el ingreso de las calificacions @IngresoCalificacionEnum
     * @param id el valor del id seleccionado de los combo boxes de Departamentos, Municipios o Centro escolar
     * @param tipoPrueba el tipo de prueba psicométrica o de conocimientos @TipoPrueba
     * @return
     */
    public List<IngresoCalificacionDTO> findByCriteriaDTO(IngresoCalificacionEnum criteria, long id, TipoPrueba tipoPrueba) {
        return docenteAplicacionRepository.findByCriteriaDTO(criteria,id,tipoPrueba);
    }

    /**
     * Listado de carpetas donde se almacenaran los archivos XLSX que se suban al sistema
     * para notas de los participantes
     * @return
     */
    public List<File> getCarpetasFiltros(){
        return calificacionRepository.getCarpetasFiltros();
    }

    /**
     * Verficar si no hay calificación ingresada para el criterio dado de la transaccion de aplicación
     * a plazas docentes
     * @param idCriterio (Criterio del proceso de selección)
     * @param idTramiteAplic (ID de tramite de aplicación a plaza docente)
     * @return
     */
    public Long countByIdCriterioAndIdTramiteAplic(long idCriterio,long idTramiteAplic){
        return calificacionRepository.countByIdCriterioAndIdTramiteAplic(idCriterio,idTramiteAplic);
    }

    /**
     * Guardar información de calificaciones desde archivo Excel
     * @param listadoCalificaciones
     * @param usuario
     * @return
     */
    public Map<String,Long> saveExcelFileCriterio2PruebaConocimientos(
            List<ReporteCriterio2V2> listadoCalificaciones, String usuario){
        return calificacionRepository.saveExcelFileCriterio2V2PruebaConocimientos(listadoCalificaciones,usuario);
    }

    /**
     * Devuelve el listado de aplicaciones docentes para ser utilizado en el ingreso de
     * calificaciones
     * @param criteria departamento,municipio o centro educativo
     * @param id correspondiente a cualquiera de los filtros
     * @return
     */
    public List<ReporteCriterio2V2> findByCriteriaReporteCriterio2V2(
            Criterio2ServiceEnum criteria, Long id) {
        return reporteCriterio2V2Service.findByCriteriaReporteCriterio2V2(criteria,id);
    }

    /**
     * Devuelve un excel con la informacion para ingresar las calificaciones de las
     * pruebas de conocimiento y psicométrica
     * @param lines listado de lineas filtradas para ingreso de notas
     * @return
     */
    public byte[] crearPlantillaPruebaConocimientos(List<ReporteCriterio2V2> lines) {
        return excelUtil.crearPlantillaPruebaConocimientosV2(lines);
    }

    /**
     * Devuelve un excel con la informacion para ingresar las calificaciones de las
     * pruebas de conocimiento y psicométrica
     * @param seleccionado departamento,municipio o centro educativo
     * @param id correspondiente a cualquiera de los filtros
     * @return
     */
    public byte[] crearPlantillaPruebaConocimientos(Criterio2ServiceEnum seleccionado,long id){
        return crearPlantillaPruebaConocimientos(this.findByCriteriaReporteCriterio2V2(seleccionado, id));
    }

    /**
     * Leer archivo excel para obtener calificaciones
     * @param file archivo excel a leer
     * @return
     */
    public List<ReporteCriterio2V2> readXLSXCalificacionFile(File file) {
        return excelUtil.readXLSXCalificacionFileV2(file);
    }


}
