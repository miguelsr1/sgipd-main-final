package sv.gob.mined.projects.sgipd.beans;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.representations.AccessToken;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import sv.gob.mined.projects.sgipd.entities.CentroEducativo;
import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.entities.Municipio;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteCriterio1V1;
import sv.gob.mined.projects.sgipd.repositories.enums.CalificacionFolderFilterEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.CalificacionSaveEnum;
import sv.gob.mined.projects.sgipd.services.Criterio1Service;
import sv.gob.mined.projects.sgipd.services.enums.Criterio1ServiceEnum;
import sv.gob.mined.projects.sgipd.utils.CalendarUtil;

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

@Named
@ViewScoped
public class Criterio1PPsiBean extends XBaseBean implements Serializable {
    //Listado de constantes
    public static final String BASE_FS_FILENAME = "ingreso_calif_uploaded_ps_";
    public static final String REPORTE_INGRESO_NOTAS = "Ingreso_de_calificaciones_concurso_de_plazas_docentes_ps";
    public static final String XLS = ".xls";
    public static final String XLSX = ".xlsx";
    public static final CalendarUtil CALENDAR_UTIL = new CalendarUtil();
    //Listado de propiedades
    private CalificacionFolderFilterEnum carpetaSeleccionada;
    private UploadedFile originalImageFile;
    private File currentFileToProcess;

    //Listado de servicios y propiedades desde configuration
    @Inject
    private Criterio1Service criterio1Service;
    @Inject
    @ConfigProperty(name = "grade_folder")
    private String carpetaXLSXNotas;

    @Inject
    AccessToken accessToken;

    public String getCurrentUser() {
        return accessToken.getPreferredUsername();
    }

    @PostConstruct
    public void init(){
        this.criterio1Service.getCarpetasFiltros();
        this.carpetaSeleccionada = CalificacionFolderFilterEnum.departamento;
    }

    //Getters y Setters



    public CalificacionFolderFilterEnum getCarpetaSeleccionada() {
        return carpetaSeleccionada;
    }

    public void setCarpetaSeleccionada(CalificacionFolderFilterEnum carpetaSeleccionada) {
        this.carpetaSeleccionada = carpetaSeleccionada;
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
     * Bajar Archivo Excel con el listado de aplicaciones de los docentes según filtro
     *
     * @return
     */
    public String downloadExcelFile() {

            try {
                downloadFile(
                        criterio1Service
                                .crearPlantillaPruebaPsicometricaV14IngresoCalif(),
                        REPORTE_INGRESO_NOTAS + "_" + this.carpetaSeleccionada.toString()
                                + XLSX);

            } catch (Exception e) {
                getLogger().error("Error generating excel File: ", e);
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

            } catch (Exception ex) {
                getLogger().error("Error writing the file: " + this.originalImageFile.getFileName());
            }
            addMessage("Successful", this.originalImageFile.getFileName() + " is uploaded.");

        }else {
            addError("Problem with File: ","File not uploaded!");
        }
    }

    public void readAndSaveCalificaciones() {

         if(this.currentFileToProcess!=null) {
             Map<String, Long> result = criterio1Service
                     .saveExcelFileCriterio1V1PruebaPsicometricaNew(this.currentFileToProcess, getCurrentUser());
             Long procesados = result.get(CalificacionSaveEnum.Procesados.toString());
             getLogger().info(CalificacionSaveEnum.Procesados + ": " + procesados);
             Long guardados = result.get(CalificacionSaveEnum.Guardados.toString());
             getLogger().info(CalificacionSaveEnum.Guardados + ": " + guardados);
             Long existentes = result.get(CalificacionSaveEnum.Existentes.toString());
             getLogger().info(CalificacionSaveEnum.Existentes + ": " + existentes);
             Long sinCalificacion = result.get(CalificacionSaveEnum.Sin_Calificacion.toString());
             getLogger().info(CalificacionSaveEnum.Sin_Calificacion + ": " + sinCalificacion);

             addMessage("Resultado del proceso:",
                     CalificacionSaveEnum.Procesados + ": " + procesados + "<br/>" +
                             CalificacionSaveEnum.Guardados + ": " + guardados + "<br/>" +
                             CalificacionSaveEnum.Existentes + ": " + existentes + "<br/>" +
                             CalificacionSaveEnum.Sin_Calificacion + ": " + sinCalificacion
             );
         }
    }
}

