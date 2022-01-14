package sv.gob.mined.projects.sgipd.beans;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.representations.AccessToken;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio2;
import sv.gob.mined.projects.sgipd.repositories.enums.CalificacionFolderFilterEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.CalificacionSaveEnum;
import sv.gob.mined.projects.sgipd.services.enums.Criterio2ServiceEnum;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import sv.gob.mined.projects.sgipd.entities.CentroEducativo;
import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.services.Criterio2Service;
import sv.gob.mined.projects.sgipd.utils.CalendarUtil;

@Named
@ViewScoped
public class Criterio2Bean extends XBaseBean implements Serializable {
    //Listado de constantes
    public static final String BASE_FS_FILENAME = "ingreso_calif_uploaded_";
    public static final String REPORTE_INGRESO_NOTAS = "Ingreso_de_calificaciones_concurso_de_plazas_docentes_pc";
    public static final String XLS = ".xls";
    public static final String XLSX = ".xlsx";
    public static final CalendarUtil CALENDAR_UTIL = new CalendarUtil();
    //Listado de propiedades
    private long idDepartamento;
    private List<Municipio> municipios;
    private Criterio2ServiceEnum comboboxSeleccionado;
    private CalificacionFolderFilterEnum carpetaSeleccionada;
    private long idComboboxSeleccionado;
    private List<Departamento> departamentos;
    private long idMunicipio;
    private List<CentroEducativo> centrosEducativos;
    private List<ReporteCriterio2> listadoCalificaciones;
    private long idCentroEducativo;
    private UploadedFile originalImageFile;
    private File currentFileToProcess;

    //Listado de servicios y propiedades desde configuration
    @Inject
    private Criterio2Service criterio2Service;
    @Inject
    @ConfigProperty(name = "grade_folder")
    private String carpetaXLSXNotas;

    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @PostConstruct
    public void init() {
        this.departamentos = criterio2Service.findAllDepartamentos();
        this.criterio2Service.getCarpetasFiltros();
        this.carpetaSeleccionada = CalificacionFolderFilterEnum.departamento;
        this.listadoCalificaciones = new ArrayList<>();
    }
    //Getters y Setters


    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Criterio2ServiceEnum getComboboxSeleccionado() {
        return comboboxSeleccionado;
    }

    public void setComboboxSeleccionado(Criterio2ServiceEnum comboboxSeleccionado) {
        this.comboboxSeleccionado = comboboxSeleccionado;
    }

    public CalificacionFolderFilterEnum getCarpetaSeleccionada() {
        return carpetaSeleccionada;
    }

    public void setCarpetaSeleccionada(CalificacionFolderFilterEnum carpetaSeleccionada) {
        this.carpetaSeleccionada = carpetaSeleccionada;
    }

    public long getIdComboboxSeleccionado() {
        return idComboboxSeleccionado;
    }

    public void setIdComboboxSeleccionado(long idComboboxSeleccionado) {
        this.idComboboxSeleccionado = idComboboxSeleccionado;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public List<CentroEducativo> getCentrosEducativos() {
        return centrosEducativos;
    }

    public void setCentrosEducativos(List<CentroEducativo> centrosEducativos) {
        this.centrosEducativos = centrosEducativos;
    }

    public List<ReporteCriterio2> getListadoCalificaciones() {
        return listadoCalificaciones;
    }

    public void setListadoCalificaciones(List<ReporteCriterio2> listadoCalificaciones) {
        this.listadoCalificaciones = listadoCalificaciones;
    }

    public long getIdCentroEducativo() {
        return idCentroEducativo;
    }

    public void setIdCentroEducativo(long idCentroEducativo) {
        this.idCentroEducativo = idCentroEducativo;
    }

    public UploadedFile getOriginalImageFile() {
        return originalImageFile;
    }

    public void setOriginalImageFile(UploadedFile originalImageFile) {
        this.originalImageFile = originalImageFile;
    }

    public File getCurrentFileToProcess() {
        return currentFileToProcess;
    }

    public void setCurrentFileToProcess(File currentFileToProcess) {
        this.currentFileToProcess = currentFileToProcess;
    }

    //Métodos Utilitarios

    /**
     * Obtener carpeta remota donde se subiran los archivos excel con notas
     * @return
     */
    public File getCarpeta() {
        return new File(carpetaXLSXNotas, this.carpetaSeleccionada.toString());
    }

    /**
     * Obtener el archivo subido con las calificaciones
     * @return
     */
    public File getFileToWrite() {

        return new File(getCarpeta(), BASE_FS_FILENAME + getCurrentUser() +
                "_" + CALENDAR_UTIL.formatSGIPD(new Date()) + XLSX);
    }

    //Métodos del Bean

    /**
     * Carga de Municipios en selectOneMenu de criterio2.xhtml
     */
    public void cargarMunicipios() {
        this.municipios = criterio2Service.findAllMunicipiosByDepartamento(this.idDepartamento);
        this.comboboxSeleccionado = Criterio2ServiceEnum.findByDepartamento;
        this.carpetaSeleccionada = CalificacionFolderFilterEnum.departamento;
        this.idComboboxSeleccionado = this.idDepartamento;
    }

    /**
     * Carga de Centros educativos en selectOneMenu de criterio2.xhtml
     */
    public void cargarCentrosEducativos() {
        this.centrosEducativos = criterio2Service.findByMunicipio(idMunicipio);
        this.comboboxSeleccionado = Criterio2ServiceEnum.findByMunicipio;
        this.carpetaSeleccionada = CalificacionFolderFilterEnum.municipio;
        this.idComboboxSeleccionado = this.idMunicipio;
    }

    /**
     * Seleccionar el idCentroEducativo y otros valores de criterio2.xhtml
     */
    public void cargarSeleccionado() {
        this.comboboxSeleccionado = Criterio2ServiceEnum.findByCentroEducativo;
        this.carpetaSeleccionada = CalificacionFolderFilterEnum.centroeducativo;
        this.idComboboxSeleccionado = this.idCentroEducativo;
    }

    /**
     * Bajar Archivo Excel con el listado de aplicaciones de los docentes según filtro
     *
     * @return
     */
    public String downloadExcelFile() {

        if (comboboxSeleccionado != null) {

            try {
                downloadFile(
                        criterio2Service
                                .crearPlantillaPruebaConocimientos(
                                        comboboxSeleccionado, idComboboxSeleccionado),
                        REPORTE_INGRESO_NOTAS + "_" + this.carpetaSeleccionada.toString()
                                + XLSX);

            } catch (Exception e) {
                getLogger().error("Error generating excel File: ", e);
            }
        } else {

        }


        return "";
    }

    /**
     * Manejar la subida de archivos excel con calificaciones
     * @param event
     */
    public void handleFileUpload(FileUploadEvent event) {
        this.originalImageFile = null;
        UploadedFile file = event.getFile();
        if (file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.originalImageFile = file;
            getLogger().info(getCarpeta());
            try {
                this.currentFileToProcess = getFileToWrite();
                copyFile(this.currentFileToProcess, this.originalImageFile.getInputStream());
                if(this.currentFileToProcess!=null){
                    this.listadoCalificaciones = criterio2Service.readXLSXCalificacionFile(this.currentFileToProcess);

                }
            } catch (Exception ex) {
                getLogger().error("Error writing the file: " + this.originalImageFile.getFileName());
            }
            addMessage("Successful", this.originalImageFile.getFileName() + " is uploaded.");

        }
    }


    public void readAndSaveCalificaciones() {
        if(this.listadoCalificaciones!=null && !this.listadoCalificaciones.isEmpty()){

            Map<String,Long> result = criterio2Service
                    .saveExcelFileCriterio2PruebaConocimientos(listadoCalificaciones,getCurrentUser());
            Long procesados = result.get(CalificacionSaveEnum.Procesados.toString());
            getLogger().info(CalificacionSaveEnum.Procesados+": "+procesados);
            Long guardados = result.get(CalificacionSaveEnum.Guardados.toString());
            getLogger().info(CalificacionSaveEnum.Guardados+": "+guardados);
            Long existentes = result.get(CalificacionSaveEnum.Existentes.toString());
            getLogger().info(CalificacionSaveEnum.Existentes+": "+existentes);
            Long sinCalificacion = result.get(CalificacionSaveEnum.Sin_Calificacion.toString());
            getLogger().info(CalificacionSaveEnum.Sin_Calificacion+": "+sinCalificacion);
            this.listadoCalificaciones =new ArrayList<>();
            addMessage("Resultado del proceso:",
                    CalificacionSaveEnum.Procesados+": "+procesados+"<br/>"+
                            CalificacionSaveEnum.Guardados+": "+guardados+"<br/>"+
                            CalificacionSaveEnum.Existentes+": "+existentes+"<br/>"+
                            CalificacionSaveEnum.Sin_Calificacion+": "+sinCalificacion
                    );
        }else{
            addError("Error al guardar las calificaciones: ",
                    "Descargué, llené y suba el archivo excel con las calificaciones!");
        }
    }
}
