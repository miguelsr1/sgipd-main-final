package sv.gob.mined.projects.sgipd.beans;


import sv.gob.mined.projects.sgipd.entities.Departamento;
import sv.gob.mined.projects.sgipd.fakeentities.ReporteDocentesAplicaciones;
import sv.gob.mined.projects.sgipd.services.Criterio2Service;
import sv.gob.mined.projects.sgipd.services.ReporteDocentesAplicacionesService;
import sv.gob.mined.projects.sgipd.utils.CalendarUtil;
import sv.gob.mined.projects.sgipd.utils.ExcelUtil;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Named
@ViewScoped
public class RepDocAppBean extends XBaseBean implements Serializable {

    private static final String REPORTE_PARTICIPANTES = "Informe_de_Inscritos_concurso_de_plazas_docentes";
    private static final String XLS = ".xls";
    private static final String XLSX = ".xlsx";
    private List<ReporteDocentesAplicaciones> reportLines;
    private List<ReporteDocentesAplicaciones> selectedReportLines;
    private CalendarUtil calUtil;
    private Long idDepartamento;
    private List<Departamento> departamentos;
    @Inject
    private Criterio2Service criterio2Service;

    @Inject
    private ReporteDocentesAplicacionesService reporteDocentesAplicacionesService;
    @Inject
    private ExcelUtil excelUtil;

    @PostConstruct
    @Override
    public void init() {
        this.reportLines = new ArrayList<>();
        this.calUtil = new CalendarUtil();
        this.departamentos = criterio2Service.findAllNoFilter();

    }

    public RepDocAppBean() {
    }

    public List<ReporteDocentesAplicaciones> getReportLines() {
        return reportLines;
    }

    public void setReportLines(List<ReporteDocentesAplicaciones> reportLines) {
        this.reportLines = reportLines;
    }

    public List<ReporteDocentesAplicaciones> getSelectedReportLines() {
        return selectedReportLines;
    }

    public void setSelectedReportLines(List<ReporteDocentesAplicaciones> selectedReportLines) {
        this.selectedReportLines = selectedReportLines;
    }

    public CalendarUtil getCalUtil() {
        return calUtil;
    }

    public void setCalUtil(CalendarUtil calUtil) {
        this.calUtil = calUtil;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public String downloadExcelFile() {
        //List<ReporteDocentesAplicaciones> lines = reporteDocentesAplicacionesService.findByCodigoDeSolicitante(8421L);
        //List<ReporteDocentesAplicaciones> lines = reporteDocentesAplicacionesService.findAll();
        try {
            if(this.idDepartamento!=null) {
                downloadFile(excelUtil
                        .createReportDocentesAplicacionesByDepartamento(this.idDepartamento),
                        REPORTE_PARTICIPANTES + XLSX);
            }else{
                addError("Seleccionar Departamento:","por favor seleccione un departamento!");
            }

        } catch (Exception e) {
            getLogger().error("Error generating excel File: ", e);
        }
        return "";
    }


}
