package sv.gob.mined.projects.sgipd.services;

import sv.gob.mined.projects.sgipd.entities.CentroEducativo;
import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.fakeentities.*;
import sv.gob.mined.projects.sgipd.repositories.*;
import sv.gob.mined.projects.sgipd.services.enums.Criterio1ServiceEnum;
import sv.gob.mined.projects.sgipd.services.enums.Criterio2ServiceEnum;
import sv.gob.mined.projects.sgipd.utils.ExcelUtil;

import javax.ejb.Asynchronous;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.File;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class Criterio1Service {

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
    private ReporteCriterio1V1Service reporteCriterio1V1Service;
    @Inject
    private ReporteDocentesPruebaPsicometricaService reporteDocentesPruebaPsicometricaService;
    @Inject
    private RDPPsiIngrCalifService rdpPsiIngrCalifService;

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
    public Map<String,Long> saveExcelFileCriterio1V1PruebaPsicometrica(
            List<ReporteCriterio1V1> listadoCalificaciones, String usuario){
        return calificacionRepository.saveExcelFileCriterio1V1PruebaPsicometrica(listadoCalificaciones,usuario);
    }

    /**
     * Devuelve el listado de aplicaciones docentes para ser utilizado en el ingreso de
     * calificaciones
     * @param criteria departamento,municipio o centro educativo
     * @param id correspondiente a cualquiera de los filtros
     * @return
     */
    public List<ReporteCriterio1V1> findByCriteriaReporteCriterio1V1(
            Criterio1ServiceEnum criteria, Long id) {
        return reporteCriterio1V1Service.findByCriteriaReporteCriterio1V1(criteria,id);
    }

    /**
     * Devuelve un excel con la informacion para ingresar las calificaciones de las
     * pruebas de conocimiento y psicométrica
     * @param lines listado de lineas filtradas para ingreso de notas
     * @return
     */
    public byte[] crearPlantillaPruebaPsicometrica(List<ReporteCriterio1V1> lines) {
        return excelUtil.crearPlantillaPruebaPsicometricaV1(lines);
    }

    /**
     * Devuelve un excel con la informacion para ingresar las calificaciones de las
     * pruebas de conocimiento y psicométrica
     * @param seleccionado departamento,municipio o centro educativo
     * @param id correspondiente a cualquiera de los filtros
     * @return
     */
    public byte[] crearPlantillaPruebaPsicometrica(Criterio1ServiceEnum seleccionado,long id){
        return crearPlantillaPruebaPsicometrica(this.findByCriteriaReporteCriterio1V1(seleccionado, id));
    }

    /**
     * Leer archivo excel para obtener calificaciones
     * @param file archivo excel a leer
     * @return
     */
    public List<ReporteCriterio1V1> readXLSXCalificacionFile(File file) {
        return excelUtil.readXLSXCalificacionFileV1(file);
    }

    /**
     * Reporte de Docentes que pasaron la prueba de conocimientos y
     * pueden realizar la prueba Psicometrica.
     * @return
     */
    public List<RDPPsicometrica> findAll(){
        return reporteDocentesPruebaPsicometricaService
                .findAll();
    }

    /**
     * Listado de docentes a los cuales se les agregara calficacion
     * Prueba Psicometrica
     * @return
     */
    public List<RDPPsiIngrCalif> findAllDocentes(){
        return rdpPsiIngrCalifService.findAll();
    }

    public byte[] crearPlantillaPruebaPsicometricaV14IngresoCalif(){
        return excelUtil.crearPlantillaPruebaPsicometricaV14IngresoCalif(findAllDocentes());
    }

    public List<RDPPsiIngrCalif> readXLSXCalificacionFileV1_RDPPsiIngrCalif(File file){
        return excelUtil.readXLSXCalificacionFileV1_RDPPsiIngrCalif(file);
    }

    public List<RDPPsiIngrCalif> readTableCalificacionFileV1_RDPPsiIngrCalif(Integer pageSize,Integer from){
        return rdpPsiIngrCalifService.readTableCalificacionFileV1_RDPPsiIngrCalif(pageSize,from);
    }

    public List<RDPPsiIngrCalif> readTableCalificacionFileV1_RDPPsiIngrCalif(String nip){
        return rdpPsiIngrCalifService.readTableCalificacionFileV1_RDPPsiIngrCalif(nip);
    }


    @Asynchronous
    @Transactional
    public Map<String, Long> saveExcelFileCriterio1V1PruebaPsicometricaNew(File file,String usuario){
        return calificacionRepository.saveExcelFileCriterio1V1PruebaPsicometricaNew(
                readXLSXCalificacionFileV1_RDPPsiIngrCalif(file),usuario
        );
    }

    @Asynchronous
    @Transactional
    public Map<String, Long> saveExcelFileCriterio1V1PruebaPsicometricaNew(String usuario,Integer pageSize,Integer from){
        return calificacionRepository.saveExcelFileCriterio1V1PruebaPsicometricaNew(
                readTableCalificacionFileV1_RDPPsiIngrCalif(pageSize,from),usuario
        );
    }

    @Asynchronous
    @Transactional
    public Map<String, Long> saveExcelFileCriterio1V1PruebaPsicometricaNew(String usuario,String nip){
        return calificacionRepository.saveExcelFileCriterio1V1PruebaPsicometricaNew(
                readTableCalificacionFileV1_RDPPsiIngrCalif(nip),usuario
        );
    }
}
