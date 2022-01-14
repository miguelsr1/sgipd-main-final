package sv.gob.mined.projects.sgipd.beans;

import sv.gob.mined.projects.sgipd.services.Criterio1Service;
import sv.gob.mined.projects.sgipd.utils.ExcelUtil;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class RepDocPruPsiBean extends XBaseBean{

    private static final String REPORTE_PARTICIPANTES = "Informe_de_aprobados_para_prueba_psicometrica";
    private static final String XLS = ".xls";
    private static final String XLSX = ".xlsx";

    @Inject
    private ExcelUtil excelUtil;

    @Override
    @PostConstruct
    public void init() {

    }

    public String downloadExcelFile() {

        try {

                downloadFile(excelUtil
                                .createReportDocentesPruebaPsicometrica(),
                        REPORTE_PARTICIPANTES + XLSX);


        } catch (Exception e) {
            getLogger().error("Error generating excel File: ", e);
        }
        return "";
    }
}
