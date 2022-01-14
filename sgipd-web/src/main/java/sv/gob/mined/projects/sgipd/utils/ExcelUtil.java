package sv.gob.mined.projects.sgipd.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.dtos.IngresoCalificacionDTO;
import sv.gob.mined.projects.sgipd.entities.Calificacion;
import sv.gob.mined.projects.sgipd.fakeentities.*;
import sv.gob.mined.projects.sgipd.services.ReporteDocentesAplicacionesService;
import sv.gob.mined.projects.sgipd.services.ReporteDocentesPruebaPsicometricaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static sv.gob.mined.projects.sgipd.beans.XBaseBean.getLogger;

@ApplicationScoped
public class ExcelUtil {
    private static final String XLSX_TEMPLATES_PATH = "/exceltemplates/";
    private static final String REPORTE_PARTICIPANTES = "Informe_de_Inscritos_concurso_de_plazas_docentes_template.xlsx";
    private static final String REPORTE_PARTICIPANTES_PRUEBA_PSICOMETRICA =
            "Informe_de_aprobados_para_prueba_psicometrica_template_1.xlsx";
    private static final String DATETIME_FORMAT = "m/d/yy h:mm";
    private static final String DATE_FORMAT = "m/d/yy";
    private static final String PERCENTAGE_FORMAT = "0.00%";
    private static final String REPORTE_INGRESO_NOTAS = "Ingreso_de_calificaciones_concurso_de_plazas_docentes_template.xlsx";
    private static final String REPORTE_INGRESO_NOTAS_V2 = "Ingreso_de_calificaciones_concurso_de_plazas_docentes_template_2.xlsx";
    private static final String REPORTE_INGRESO_NOTAS_V1 = "Ingreso_de_calificaciones_prueba_psicometrica_template_1.xlsx";
    private static final String REPORTE_INGRESO_NOTAS_PSI_V2 = "Ingreso_de_calificaciones_prueba_psicometrica_template_2.xlsx";
    private static Logger logger = Logger.getLogger(ExcelUtil.class);

    @Inject
    @ConfigProperty(name = "exceltemplates")
    String exceltemplates;

    @Inject
    private ReporteDocentesAplicacionesService reporteDocentesAplicacionesService;

    @Inject
    private ReporteDocentesPruebaPsicometricaService reporteDocentesPruebaPsicometricaService;

    private XSSFCell createCell(XSSFRow row, int index, CellType cellType) {
        XSSFCell c = row.createCell(index);
        c.setCellType(cellType);
        return c;
    }

    private Cell createCell(Row row, int index, CellType cellType) {
        Cell c = row.createCell(index);
        if (cellType.equals(CellType.BLANK)) {
            c.setBlank();
        }
        return c;
    }

    private XSSFCell createCell(XSSFRow row, int index) {
        XSSFCell c = row.createCell(index);
        return c;
    }

    private Cell createCell(Row row, int index) {
        Cell c = row.createCell(index);
        return c;
    }

    private Cell createStringCell(Row row, int index) {
        return createCell(row, index, CellType.STRING);
    }

    private XSSFCell createStringCell(XSSFRow row, int index) {
        return createCell(row, index, CellType.STRING);
    }

    private Cell createNumericCell(Row row, int index) {
        return createCell(row, index, CellType.NUMERIC);
    }

    private XSSFCell createNumericCell(XSSFRow row, int index) {
        return createCell(row, index, CellType.NUMERIC);
    }

    private Cell createBlankCell(Row row, int index) {
        return createCell(row, index, CellType.BLANK);
    }

    private XSSFCell createBlankCell(XSSFRow row, int index) {
        return createCell(row, index, CellType.BLANK);
    }

    private Cell createDateCell(Row row, int index, Workbook wb, String format) {
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat(format));
        Cell datecell = createCell(row, index);
        datecell.setCellStyle(cellStyle);
        return datecell;
    }

    private XSSFCell createDateCell(XSSFRow row, int index, XSSFWorkbook wb, String format) {
        XSSFCreationHelper createHelper = wb.getCreationHelper();
        XSSFCellStyle cellStyle = wb.createCellStyle();
        XSSFDataFormat cformat = wb.createDataFormat();
        cellStyle.setDataFormat(cformat.getFormat(format));
        XSSFCell dateCell = createCell(row, index);
        dateCell.setCellStyle(cellStyle);
        return dateCell;
    }

    private Cell createPercentageCell(Row row, int index, Workbook wb) {
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat(PERCENTAGE_FORMAT));
        Cell percentageCell = createCell(row, index);
        percentageCell.setCellStyle(cellStyle);
        return percentageCell;
    }

    private XSSFCell createPercentageCell(XSSFRow row, int index, XSSFWorkbook wb) {
        XSSFCreationHelper createHelper = wb.getCreationHelper();
        XSSFCellStyle cellStyle = wb.createCellStyle();
        XSSFDataFormat cformat = wb.createDataFormat();
        cellStyle.setDataFormat(cformat.getFormat(PERCENTAGE_FORMAT));
        XSSFCell percentageCell = createCell(row, index);
        percentageCell.setCellStyle(cellStyle);
        return percentageCell;
    }

    private void setCellStringValue(Row row, int index, String value) {
        if (value != null && !value.equals("") && !value.equals(" ")) {
            createStringCell(row, index).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellStringValue(XSSFRow row, int index, String value) {
        if (value != null && !value.equals("") && !value.equals(" ")) {
            createStringCell(row, index).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellIntegerValue(Row row, int index, Integer value) {
        if (value != null) {
            createNumericCell(row, index).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellIntegerValue(XSSFRow row, int index, Integer value) {
        if (value != null) {
            createNumericCell(row, index).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellBlankValue(Row row, int index) {
        createBlankCell(row, index).setCellValue("");
    }

    private void setCellBlankValue(XSSFRow row, int index) {
        createBlankCell(row, index).setCellValue("");
    }

    private XSSFCell getCellFormula(XSSFRow row, int index, String formula) {
        XSSFCell c = row.createCell(index);

        c.setCellFormula(formula);
        return c;
    }

    private void setCellDoubleValue(Row row, int index, Double value) {
        if (value != null) {
            createNumericCell(row, index).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellDoubleValue(XSSFRow row, int index, Double value) {
        if (value != null) {
            createNumericCell(row, index).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellPercentageValue(Row row, int index, Workbook wb, Double value) {
        if (value != null) {
            createPercentageCell(row, index, wb).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellPercentageValue(XSSFRow row, int index, Workbook wb, Double value) {
        if (value != null) {
            createPercentageCell(row, index, wb).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellDateValue(Row row, int index, Workbook wb, Date value, String format) {
        if (value != null) {
            createDateCell(row, index, wb, format).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    private void setCellDateValue(XSSFRow row, int index, Workbook wb, Date value, String format) {
        if (value != null) {
            createDateCell(row, index, wb, format).setCellValue(value);
        } else {
            createBlankCell(row, index).setCellValue("");
        }
    }

    public byte[] createReportDocentesAplicacionesByDepartamento(Long idDepartamento) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_PARTICIPANTES))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            //int startRow = 1;
            AtomicInteger startRow = new AtomicInteger(0);
            this.reporteDocentesAplicacionesService.findByDepartamento(idDepartamento).stream().forEach(line -> {
                logger.info("Solicitante: " + line.getCodigoDeSolicitante());
                Row row = sheet.createRow(startRow.incrementAndGet());
                setCellStringValue(row, 0, line.getDepartamento() != null ? line.getDepartamento() : "");
                setCellStringValue(row, 1, line.getMunicipio() != null ? line.getMunicipio() : "");
                setCellIntegerValue(row, 2, line.getCodigoDeSolicitante() != null ? line.getCodigoDeSolicitante().intValue() : null);
                setCellStringValue(row, 3, line.getDui() != null ? line.getDui() : "");
                setCellStringValue(row, 4, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 5, line.getEcorreo() != null ? line.getEcorreo() : "");
                setCellStringValue(row, 6, line.getEspecialidad() != null ? line.getEspecialidad() : "");
                setCellStringValue(row, 7, line.getTitulo() != null ? line.getTitulo() : "");
                setCellStringValue(row, 8, line.getUniversidad() != null ? line.getUniversidad() : "");
                setCellIntegerValue(row, 9, line.getAnnioGraduacion() != null ? line.getAnnioGraduacion().intValue() : null);
                setCellStringValue(row, 10, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                setCellStringValue(row, 11, line.getNombre() != null ? line.getNombre() : "");
                setCellStringValue(row, 12, line.getApellido() != null ? line.getApellido() : "");
                setCellIntegerValue(row, 13, line.getIdDePlazaVacante() != null ? line.getIdDePlazaVacante().intValue() : null);
                setCellStringValue(row, 14, line.getNivelEducativo() != null ? line.getNivelEducativo() : "");
                setCellStringValue(row, 15, line.getCentroEducativoDePlaza() != null ? line.getCentroEducativoDePlaza() : "");
                setCellStringValue(row, 16, line.getEspecialidadDePlazaVacantes() != null ? line.getEspecialidadDePlazaVacantes() : "");
            });
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_PARTICIPANTES, e);
        }
        return binaryWB;
    }

    public byte[] createReportDocentesPruebaPsicometrica() {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_PARTICIPANTES_PRUEBA_PSICOMETRICA))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            //int startRow = 1;
            AtomicInteger startRow = new AtomicInteger(0);
            reporteDocentesPruebaPsicometricaService.findAll().stream().forEach(line -> {
                logger.info("Solicitante: " + line.getNip());
                Row row = sheet.createRow(startRow.incrementAndGet());
                setCellStringValue(row, 0, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 1, line.getDui() != null ? line.getDui() : "");
                setCellStringValue(row, 2, line.getCorreo() != null ? line.getCorreo() : "");
                setCellStringValue(row, 3, line.getEspecialidad() != null ? line.getEspecialidad() : "");
                setCellStringValue(row, 4, line.getTitulo() != null ? line.getTitulo() : "");
                setCellStringValue(row, 5, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                setCellStringValue(row, 6, line.getNombres() != null ? line.getNombres() : "");
                setCellStringValue(row, 7, line.getApellidos() != null ? line.getApellidos() : "");
                setCellStringValue(row, 8, line.getSexo() != null ? line.getSexo() : "");
                setCellStringValue(row, 9, line.getDiscapacidad() != null ? line.getDiscapacidad() : "");
                setCellIntegerValue(row, 10, line.getCodigoMunicipioResidencia() != null ? line.getCodigoMunicipioResidencia().intValue() : null);
                setCellStringValue(row, 11, line.getMunicipioderesidencia() != null ? line.getMunicipioderesidencia() : "");
                setCellIntegerValue(row, 12, line.getCodigoDepartamentoResidencia() != null ? line.getCodigoDepartamentoResidencia().intValue() : null);
                setCellStringValue(row, 13, line.getDepartamentoderesidencia() != null ? line.getDepartamentoderesidencia() : "");
                setCellStringValue(row, 14, line.getDireccionResidencia() != null ? line.getDireccionResidencia() : "");

            });
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_PARTICIPANTES_PRUEBA_PSICOMETRICA, e);
        }
        return binaryWB;
    }

    public byte[] createReportDocentesAplicaciones() {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_PARTICIPANTES))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            //int startRow = 1;
            AtomicInteger startRow = new AtomicInteger(0);
            this.reporteDocentesAplicacionesService.findAll().stream().forEach(line -> {
                logger.info("Solicitante: " + line.getCodigoDeSolicitante());
                Row row = sheet.createRow(startRow.incrementAndGet());
                setCellStringValue(row, 0, line.getDepartamento() != null ? line.getDepartamento() : "");
                setCellStringValue(row, 1, line.getMunicipio() != null ? line.getMunicipio() : "");
                setCellIntegerValue(row, 2, line.getCodigoDeSolicitante() != null ? line.getCodigoDeSolicitante().intValue() : null);
                setCellStringValue(row, 3, line.getDui() != null ? line.getDui() : "");
                setCellStringValue(row, 4, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 5, line.getEcorreo() != null ? line.getEcorreo() : "");
                setCellStringValue(row, 6, line.getEspecialidad() != null ? line.getEspecialidad() : "");
                setCellStringValue(row, 7, line.getTitulo() != null ? line.getTitulo() : "");
                setCellStringValue(row, 8, line.getUniversidad() != null ? line.getUniversidad() : "");
                setCellIntegerValue(row, 9, line.getAnnioGraduacion() != null ? line.getAnnioGraduacion().intValue() : null);
                setCellStringValue(row, 10, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                setCellStringValue(row, 11, line.getNombre() != null ? line.getNombre() : "");
                setCellStringValue(row, 12, line.getApellido() != null ? line.getApellido() : "");
                setCellIntegerValue(row, 13, line.getIdDePlazaVacante() != null ? line.getIdDePlazaVacante().intValue() : null);
                setCellStringValue(row, 14, line.getNivelEducativo() != null ? line.getNivelEducativo() : "");
                setCellStringValue(row, 15, line.getCentroEducativoDePlaza() != null ? line.getCentroEducativoDePlaza() : "");
                setCellStringValue(row, 16, line.getEspecialidadDePlazaVacantes() != null ? line.getEspecialidadDePlazaVacantes() : "");
            });
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_PARTICIPANTES, e);
        }
        return binaryWB;
    }

    public byte[] createReportDocentesAplicaciones(List<ReporteDocentesAplicaciones> lines) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_PARTICIPANTES))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (ReporteDocentesAplicaciones line : lines) {
                logger.info("Solicitante: " + line.getCodigoDeSolicitante());
                Row row = sheet.createRow(startRow);
                setCellStringValue(row, 0, line.getDepartamento() != null ? line.getDepartamento() : "");
                setCellStringValue(row, 1, line.getMunicipio() != null ? line.getMunicipio() : "");
                setCellIntegerValue(row, 2, line.getCodigoDeSolicitante() != null ? line.getCodigoDeSolicitante().intValue() : null);
                setCellStringValue(row, 3, line.getDui() != null ? line.getDui() : "");
                setCellStringValue(row, 4, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 5, line.getEcorreo() != null ? line.getEcorreo() : "");
                setCellStringValue(row, 6, line.getEspecialidad() != null ? line.getEspecialidad() : "");
                setCellStringValue(row, 7, line.getTitulo() != null ? line.getTitulo() : "");
                setCellStringValue(row, 8, line.getUniversidad() != null ? line.getUniversidad() : "");
                setCellIntegerValue(row, 9, line.getAnnioGraduacion() != null ? line.getAnnioGraduacion().intValue() : null);
                setCellStringValue(row, 10, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                setCellStringValue(row, 11, line.getNombre() != null ? line.getNombre() : "");
                setCellStringValue(row, 12, line.getApellido() != null ? line.getApellido() : "");
                setCellIntegerValue(row, 13, line.getIdDePlazaVacante() != null ? line.getIdDePlazaVacante().intValue() : null);
                setCellStringValue(row, 14, line.getNivelEducativo() != null ? line.getNivelEducativo() : "");
                setCellStringValue(row, 15, line.getCentroEducativoDePlaza() != null ? line.getCentroEducativoDePlaza() : "");
                setCellStringValue(row, 16, line.getEspecialidadDePlazaVacantes() != null ? line.getEspecialidadDePlazaVacantes() : "");
                startRow++;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_PARTICIPANTES, e);
        }
        return binaryWB;
    }

    public byte[] createReportIngresoCalificacion(List<IngresoCalificacionDTO> lines) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_INGRESO_NOTAS))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;

            for (IngresoCalificacionDTO line : lines) {
                logger.info("Solicitante: " + line.getCodigoTransaccion());
                Row row = sheet.createRow(startRow);

                setCellStringValue(row, 0, line.getDepartamento() != null ? line.getDepartamento() : "");
                setCellStringValue(row, 1, line.getMunicipio() != null ? line.getMunicipio() : "");
                setCellIntegerValue(row, 2, line.getCodigoSolicitante().intValue());
                setCellStringValue(row, 3, line.getDui() != null ? line.getDui() : "");
                setCellStringValue(row, 4, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 5, line.getEcorreo() != null ? line.getEcorreo() : "");
                setCellStringValue(row, 6, line.getEspecialidad() != null ? line.getEspecialidad() : "");
                setCellStringValue(row, 7, line.getTitulo() != null ? line.getTitulo() : "");
                setCellStringValue(row, 8, line.getUniversidad() != null ? line.getUniversidad() : "");
                setCellIntegerValue(row, 9, line.getAnnioGraduacion() != null ? line.getAnnioGraduacion().intValue() : null);

                getLogger().info("*-*Nombre completo--*>" + line.getNombreCompleto() + " <*-*--*");

                setCellStringValue(row, 10, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");

                getLogger().info("*-*Nombres--*>" + line.getNombres() + " <*-*--*");
                String variable = "madafaq";
                setCellStringValue(row, 11, "AAAAAA");

                setCellStringValue(row, 12, line.getApellidos() != null ? line.getApellidos() : "");

                setCellIntegerValue(row, 13, line.getIdDePlazaVacante().intValue());
                setCellStringValue(row, 14, line.getNivelEducativo() != null ? line.getNivelEducativo() : "");
                setCellStringValue(row, 15, line.getCentroEducativo() != null ? line.getCentroEducativo() : "");
                setCellStringValue(row, 16, line.getEspecialidadPlazaVacante() != null ? line.getEspecialidadPlazaVacante() : "");

                //setCellStringValue(row, 8, line.getTipoPrueba() != null ? line.getTipoPrueba() : "");

                setCellDoubleValue(row, 9, null);
                setCellStringValue(row, 10, "");
                setCellStringValue(row, 11, "");

                startRow++;
            }

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_PARTICIPANTES, e);
        }
        return binaryWB;
    }

    public byte[] crearPlantillaPruebaConocimientos(List<ReporteCriterio2> lines) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_INGRESO_NOTAS))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (ReporteCriterio2 line : lines) {
                logger.info("Solicitante: " + line.getIdTramite());
                Row row = sheet.createRow(startRow);

                setCellIntegerValue(row, 0, line.getIdTramite() != null ? line.getIdTramite().intValue() : null);
                setCellStringValue(row, 1, line.getDepartamento() != null ? line.getDepartamento() : "");
                setCellStringValue(row, 2, line.getMunicipio() != null ? line.getMunicipio() : "");
                setCellIntegerValue(row, 3, line.getCodigoSolicitante() != null ? line.getCodigoSolicitante().intValue() : null);
                setCellStringValue(row, 4, line.getDui() != null ? line.getDui() : "");
                setCellStringValue(row, 5, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 6, line.getEcorreo() != null ? line.getEcorreo() : "");
                setCellStringValue(row, 7, line.getEspecialidad() != null ? line.getEspecialidad() : "");
                setCellStringValue(row, 8, line.getTitulo() != null ? line.getTitulo() : "");
                setCellStringValue(row, 9, line.getUniversidad() != null ? line.getUniversidad() : "");
                setCellIntegerValue(row, 10, line.getAnnioGraduacion() != null ? line.getAnnioGraduacion().intValue() : null);
                setCellStringValue(row, 11, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                setCellStringValue(row, 12, line.getNombres() != null ? line.getNombres() : "");
                setCellStringValue(row, 13, line.getApellidos() != null ? line.getApellidos() : "");
                setCellIntegerValue(row, 14, line.getIdDePlazaVacante().intValue());
                setCellStringValue(row, 15, line.getNivelEducativo() != null ? line.getNivelEducativo() : "");
                setCellStringValue(row, 16, line.getCentroEducativo() != null ? line.getCentroEducativo() : "");
                setCellStringValue(row, 17, line.getEspecialidadPlazaVacante() != null ? line.getEspecialidadPlazaVacante() : "");
                //setCellStringValue(row, 20, line.getTipoPrueba() != null ? line.getTipoPrueba() : "");

                startRow++;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_INGRESO_NOTAS, e);
        }
        return binaryWB;
    }

    public byte[] crearPlantillaPruebaConocimientosV2(List<ReporteCriterio2V2> lines) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_INGRESO_NOTAS_V2))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (ReporteCriterio2V2 line : lines) {
                logger.info("Solicitante: " + line.getIdTramite());
                Row row = sheet.createRow(startRow);
                setCellIntegerValue(row, 0, line.getIdTramite() != null ? line.getIdTramite().intValue() : null);
                setCellStringValue(row, 1, line.getNip() != null ? line.getNip() : "");
                setCellIntegerValue(row, 2, line.getIdPlazaVacante() != null ? line.getIdPlazaVacante().intValue() : null);
                setCellStringValue(row, 3, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                startRow++;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_INGRESO_NOTAS_V2, e);
        }
        return binaryWB;
    }

    public byte[] crearPlantillaPruebaPsicometricaV1(List<ReporteCriterio1V1> lines) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_INGRESO_NOTAS_V1))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (ReporteCriterio1V1 line : lines) {
                logger.info("Solicitante: " + line.getIdTramite());
                Row row = sheet.createRow(startRow);
                setCellIntegerValue(row, 0, line.getIdTramite() != null ? line.getIdTramite().intValue() : null);
                setCellStringValue(row, 1, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 2, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                startRow++;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_INGRESO_NOTAS_V1, e);
        }
        return binaryWB;
    }

    public byte[] crearPlantillaPruebaPsicometricaV14IngresoCalif(List<RDPPsiIngrCalif> lines) {
        byte[] binaryWB = new byte[1024];
        try (InputStream inp = new FileInputStream(new File(exceltemplates, REPORTE_INGRESO_NOTAS_PSI_V2))) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (RDPPsiIngrCalif line : lines) {
                logger.info("Solicitante: " + line.getNip());
                Row row = sheet.createRow(startRow);
                setCellStringValue(row, 0, line.getNip() != null ? line.getNip() : "");
                setCellStringValue(row, 1, line.getNombreCompleto() != null ? line.getNombreCompleto() : "");
                startRow++;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            binaryWB = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + REPORTE_INGRESO_NOTAS_PSI_V2, e);
        }
        return binaryWB;
    }

    private Long getLongValue(Cell cell) {
        return Long.valueOf(
                (long) cell.getNumericCellValue()
        );
    }

    private BigDecimal getBigDecimal(Cell cell) {
        return BigDecimal.valueOf(cell.getNumericCellValue());
    }

    public ReporteCriterio2 fromRow2ReporteCriterio1(Row row) {
        ReporteCriterio2 c = new ReporteCriterio2();
        Cell idTramite = row.getCell(0); //idTramite
        c.setIdTramite(idTramite != null &&
                !idTramite.getCellType().equals(CellType.STRING) ? getLongValue(idTramite) : null);

        Cell departamento = row.getCell(1);
        c.setDepartamento(departamento != null ? departamento.getStringCellValue() : null);

        Cell municipio = row.getCell(2);
        c.setMunicipio(municipio != null ? municipio.getStringCellValue() : null);

        Cell codigoSolicitante = row.getCell(3);
        c.setCodigoSolicitante(codigoSolicitante != null ? getLongValue(codigoSolicitante) : null);

        Cell dui = row.getCell(4);
        c.setDui(dui != null ? dui.getStringCellValue() : null);

        Cell nip = row.getCell(5);
        c.setNip(nip != null ? nip.getStringCellValue() : null);

        Cell ecorreo = row.getCell(6);
        c.setEcorreo(ecorreo != null ? ecorreo.getStringCellValue() : null);

        Cell especialidad = row.getCell(7);
        c.setEspecialidad(especialidad != null ? especialidad.getStringCellValue() : null);

        Cell titulo = row.getCell(8);
        c.setTitulo(titulo != null ? titulo.getStringCellValue() : null);

        Cell universidad = row.getCell(9);
        c.setUniversidad(universidad != null ? universidad.getStringCellValue() : null);

        Cell annioGraduacion = row.getCell(10);
        c.setAnnioGraduacion(annioGraduacion != null &&
                !annioGraduacion.getCellType().equals(CellType.STRING) ?
                getLongValue(annioGraduacion) : null);

        Cell nombreCompleto = row.getCell(11);
        c.setNombreCompleto(nombreCompleto != null ? nombreCompleto.getStringCellValue() : null);

        Cell nombres = row.getCell(12);
        c.setNombres(nombres != null ? nombres.getStringCellValue() : null);

        Cell apellidos = row.getCell(13);
        c.setApellidos(apellidos != null ? apellidos.getStringCellValue() : null);

        Cell idDePlazaVacante = row.getCell(14);
        c.setIdDePlazaVacante(idDePlazaVacante != null &&
                !idDePlazaVacante.getCellType().equals(CellType.STRING) ? getLongValue(idDePlazaVacante) : null);

        Cell nivelEducativo = row.getCell(15);
        c.setNivelEducativo(nivelEducativo != null ? nivelEducativo.getStringCellValue() : null);

        Cell centroEducativo = row.getCell(16);
        c.setCentroEducativo(centroEducativo != null ? centroEducativo.getStringCellValue() : null);

        Cell especialidadPlazaVacante = row.getCell(17);
        c.setEspecialidadPlazaVacante(especialidadPlazaVacante != null ? especialidadPlazaVacante.getStringCellValue() : null);

        Cell calificacion = row.getCell(18);
        c.setCalificacion(calificacion != null ? getBigDecimal(calificacion) : null);

        Cell estatus = row.getCell(19);
        c.setEstatus(estatus != null ? estatus.getStringCellValue() : null);

        Cell observaciones = row.getCell(20);
        c.setObservacion(observaciones != null ? observaciones.getStringCellValue() : null);

        return c;
    }

    public ReporteCriterio2V2 fromRow2ReporteCriterio2V2(Row row) {
        ReporteCriterio2V2 c = new ReporteCriterio2V2();
        Cell idTramite = row.getCell(0); //idTramite
        c.setIdTramite(idTramite != null &&
                !idTramite.getCellType().equals(CellType.STRING) ? getLongValue(idTramite) : null);
        Cell nip = row.getCell(1);

        if (nip.getCellType().equals(CellType.NUMERIC)) {
            c.setNip(nip != null ? getLongValue(nip).toString() : null);
        } else {
            c.setNip(nip != null ? nip.getStringCellValue() : null);
        }

        Cell idPlazaVacante = row.getCell(2);
        c.setIdPlazaVacante(idPlazaVacante != null &&
                !idPlazaVacante.getCellType().equals(CellType.STRING) ?
                getLongValue(idPlazaVacante) : null);

        Cell nombreCompleto = row.getCell(3);
        c.setNombreCompleto(nombreCompleto != null ? nombreCompleto.getStringCellValue() : null);

        Cell calificacion = row.getCell(4);
        c.setCalificacion(calificacion != null ? getBigDecimal(calificacion) : null);

        Cell estatus = row.getCell(5);
        c.setEstatus(estatus != null ? estatus.getStringCellValue() : null);

        Cell observaciones = row.getCell(6);
        c.setObservacion(observaciones != null ? observaciones.getStringCellValue() : null);

        return c;
    }

    public ReporteCriterio1V1 fromRow2ReporteCriterio1V1(Row row) {
        ReporteCriterio1V1 c = new ReporteCriterio1V1();
        Cell idTramite = row.getCell(0); //idTramite
        c.setIdTramite(idTramite != null &&
                !idTramite.getCellType().equals(CellType.STRING) ? getLongValue(idTramite) : null);
        Cell nip = row.getCell(1);
        c.setNip(nip != null ? nip.getStringCellValue() : null);

        Cell nombreCompleto = row.getCell(2);
        c.setNombreCompleto(nombreCompleto != null ? nombreCompleto.getStringCellValue() : null);

        Cell calificacion = row.getCell(3);
        c.setCalificacion(calificacion != null ? getBigDecimal(calificacion) : null);

        Cell estatus = row.getCell(4);
        c.setEstatus(estatus != null ? estatus.getStringCellValue() : null);

        Cell observaciones = row.getCell(5);
        c.setObservacion(observaciones != null ? observaciones.getStringCellValue() : null);

        return c;
    }

    public RDPPsiIngrCalif fromRow2RDPPsiIngrCalif(Row row) {
        RDPPsiIngrCalif c = new RDPPsiIngrCalif();

        Cell nip = row.getCell(0);
        if (nip.getCellType().equals(CellType.NUMERIC)) {
            c.setNip(nip != null ? getLongValue(nip).toString() : null);
        } else {
            c.setNip(nip != null ? nip.getStringCellValue() : null);
        }

        Cell nombreCompleto = row.getCell(1);
        c.setNombreCompleto(nombreCompleto != null ? nombreCompleto.getStringCellValue() : null);

        Cell calificacion = row.getCell(2);
        c.setCalificacion(calificacion != null ? getBigDecimal(calificacion) : null);

        Cell estatus = row.getCell(3);
        c.setEstatus(estatus != null ? estatus.getStringCellValue() : null);

        Cell observaciones = row.getCell(4);
        c.setObservacion(observaciones != null ? observaciones.getStringCellValue() : null);

        return c;
    }

    public List<Calificacion> readXLSXCalificacionFileOld(File file) {
        List<Calificacion> grades = new ArrayList<>();
        try (InputStream inp = new FileInputStream(file)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    switch (currentCell.getCellType()) {
                        case STRING:
                            System.out.print(currentCell.getStringCellValue());
                            break;
                        case BOOLEAN:
                            System.out.print(currentCell.getBooleanCellValue());
                            break;
                        case NUMERIC:
                            System.out.print(currentCell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    System.out.print(" | ");
                }
                System.out.println();
            }
            // Closing the workbook and input stream
            wb.close();
            //inp.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + file.getPath(), e);
        }
        return grades;
    }

    public List<ReporteCriterio2> readXLSXCalificacionFile(File file) {
        List<ReporteCriterio2> grades = new ArrayList<>();
        try (InputStream inp = new FileInputStream(file)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    ReporteCriterio2 c = fromRow2ReporteCriterio1(row);
                    grades.add(c);
                }
            }
            // Closing the workbook and input stream
            wb.close();
            //inp.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + file.getPath(), e);
        }
        return grades;
    }

    public List<ReporteCriterio2V2> readXLSXCalificacionFileV2(File file) {
        List<ReporteCriterio2V2> grades = new ArrayList<>();
        try (InputStream inp = new FileInputStream(file)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    ReporteCriterio2V2 c = fromRow2ReporteCriterio2V2(row);
                    grades.add(c);
                }
            }
            // Closing the workbook and input stream
            wb.close();
            //inp.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + file.getPath(), e);
        }
        return grades;
    }

    public List<ReporteCriterio1V1> readXLSXCalificacionFileV1(File file) {
        List<ReporteCriterio1V1> grades = new ArrayList<>();
        try (InputStream inp = new FileInputStream(file)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    ReporteCriterio1V1 c = fromRow2ReporteCriterio1V1(row);
                    grades.add(c);
                }
            }
            // Closing the workbook and input stream
            wb.close();
            //inp.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + file.getPath(), e);
        }
        return grades;
    }

    public List<RDPPsiIngrCalif> readXLSXCalificacionFileV1_RDPPsiIngrCalif(File file) {
        List<RDPPsiIngrCalif> grades = new ArrayList<>();
        try (InputStream inp = new FileInputStream(file)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int startRow = 1;
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    RDPPsiIngrCalif c = fromRow2RDPPsiIngrCalif(row);
                    grades.add(c);
                }
            }
            // Closing the workbook and input stream
            wb.close();
            //inp.close();
        } catch (Exception e) {
            logger.error("Error reading the XLSX File: " + file.getPath(), e);
        }
        return grades;
    }

}
