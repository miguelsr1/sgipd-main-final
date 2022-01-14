package sv.gob.mined.projects.sgipd.repositories;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.fakeentities.*;
import sv.gob.mined.projects.sgipd.repositories.enums.CalificacionEstatusEnum;
import sv.gob.mined.projects.sgipd.repositories.enums.CalificacionSaveEnum;
import sv.gob.mined.projects.sgipd.utils.MathUtil;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@ApplicationScoped
public class CalificacionRepository extends GenericRepository<Calificacion> {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionRepository() {
        super(Calificacion.class);
    }

    @Inject
    @ConfigProperty(name = "grade_folder")
    private String carpetaXLSXNotas;

    @Inject
    @ConfigProperty(name = "grade_folder_filters")
    List<String> carpetasFiltros;

    @Inject
    private DocenteAplicacionRepository docenteAplicacionRepository;
    @Inject
    private CriterioRepository criterioRepository;
    private static final long CRITERIO2 = 2L;
    private static final long CRITERIO1 = 1L;
    private static final long CRITERIO5 = 5L;
    private static final long CRITERIO3A = 3L;
    private static final long CRITERIO3B = 6L;
    private static final long CRITERIO4A = 4L;
    private static final long CRITERIO4B = 7L;
    private static final double MAX_CALIF = 10;
    private static final double DOS_TERCIOS = 2.0 / 3.0;
    private static final double UN_TERCIO = 1.0 / 3.0;
    public static final String AUTOGENERADO = "Autogenerado Criterio_";
    private Criterio criterio2;
    private Criterio criterio1;
    private Criterio criterio5;
    private Criterio criterio3a;
    private Criterio criterio3b;
    private Criterio criterio4a;
    private Criterio criterio4b;
    @Inject
    MunicipioRepository municipioRepository;
    @Inject
    DepartamentoRepository departamentoRepository;
    @Inject
    DocenteExperienciaRepository docenteExperienciaRepository;
    @Inject
    DocenteEstudioRepository docenteEstudioRepository;
    @Inject
    DocenteCapacitacionRepository docenteCapacitacionRepository;

    @PostConstruct
    private void init() {
        criterio2 = criterioRepository.find(CRITERIO2);
        criterio1 = criterioRepository.find(CRITERIO1);
        criterio5 = criterioRepository.find(CRITERIO5);
        criterio3a = criterioRepository.find(CRITERIO3A);
        criterio3b = criterioRepository.find(CRITERIO3B);
        criterio4a = criterioRepository.find(CRITERIO4A);
        criterio4b = criterioRepository.find(CRITERIO4B);
        initFolders();
    }

    public List<File> getCarpetasFiltros() {
        List<File> carpetas = new ArrayList<>();
        this.carpetasFiltros.stream().forEach(c -> {
            carpetas.add(new File(this.carpetaXLSXNotas, c));
        });
        return carpetas;
    }


    private void initFolders() {
        getCarpetasFiltros().stream().forEach(f -> {
            if (!f.exists()) {
                if (f.mkdirs()) {
                    getLogger().info("Folder: " + f.getPath() + " created!");
                } else {
                    getLogger().error(f.getPath() + " not created!");
                }
            } else {
                getLogger().info("Folder: " + f.getPath() + " already exists!");
            }
        });
    }

    public Long countByIdCriterioAndIdTramiteAplic(long idCriterio, long idTramiteAplic) {
        Long out = Long.valueOf(-500);
        out = (Long) getEntityManager()
                .createNamedQuery("Calificacion.countByIdCriterioAndIdTramiteAplic")
                .setParameter("idCriterio", idCriterio)
                .setParameter("idTramiteAplic", idTramiteAplic)
                .getSingleResult();
        return out;
    }

    @Transactional
    public Calificacion fromReporteCriterio12Calificacion(ReporteCriterio2 r, String usuario) {
        Calificacion cal = new Calificacion();
        if (r.getCalificacion() != null && r.getCalificacion().doubleValue() >= 7.0) {
            cal.setAprobacion(true);
        } else {
            cal.setAprobacion(false);
        }
        cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
        cal.setFechaIngreso(new Timestamp(new Date().getTime()));
        cal.setUsuarioIngreso(usuario);
        cal.setUsuarioActualizacion(usuario);
        if (r.getCalificacion() != null) {
            cal.setValorCalif(MathUtil.roundBigDecimal(r.getCalificacion()));
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio2.getFraccionPonderacion().multiply(r.getCalificacion())
                    )
            );
        } else {
            cal.setValorCalif(BigDecimal.valueOf(0.00));
            cal.setValorPonderacion(BigDecimal.valueOf(0.00));
        }
        cal.setCriterio(criterio2);
        cal.setDocentesAplicacione(docenteAplicacionRepository.find(r.getIdTramite()));
        if (r.getObservacion() != null) {
            cal.setObservacion(r.getObservacion());
        }
        if (r.getEstatus() != null) {
            cal.setEstatus(r.getEstatus());
            //Reprobar aunque se este aprobado por irregularidades durante la prueba
            if (cal.getEstatus().equals(CalificacionEstatusEnum.REPROBADO.toString())) {
                cal.setAprobacion(false);
            } else if (cal.getEstatus().equals(CalificacionEstatusEnum.APROBADO.toString())) {
                cal.setAprobacion(true);
            }
        }
        return cal;
    }


    @Transactional
    public Calificacion fromReporteCriterio2V22Calificacion(ReporteCriterio2V2 r, String usuario) {
        getLogger().info("Registro: " + r);
        Calificacion cal = new Calificacion();
//        if (r.getCalificacion() != null && r.getCalificacion().doubleValue() >= 7.0) {
//            cal.setAprobacion(true);
//        } else {
//            cal.setAprobacion(false);
//        }
        cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
        cal.setFechaIngreso(new Timestamp(new Date().getTime()));
        cal.setUsuarioIngreso(usuario);
        cal.setUsuarioActualizacion(usuario);
        if (r.getCalificacion() != null) {
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            r.getCalificacion()
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio2.getFraccionPonderacion().multiply(r.getCalificacion())
                    )
            );
            getLogger().info("nota: " + cal.getValorCalif());
            getLogger().info("ponderacion: " + cal.getValorPonderacion());
        } else {
            cal.setValorCalif(BigDecimal.valueOf(0.00));
            cal.setValorPonderacion(BigDecimal.valueOf(0.00));
        }
        cal.setCriterio(criterio2);
        cal.setDocentesAplicacione(docenteAplicacionRepository.find(r.getIdTramite()));
        if (r.getObservacion() != null) {
            cal.setObservacion(r.getObservacion());
        }
        if (r.getEstatus() != null) {
            cal.setEstatus(r.getEstatus());
            //Reprobar aunque se este aprobado por irregularidades durante la prueba
            if (cal.getEstatus().equals(CalificacionEstatusEnum.REPROBADO.toString())) {
                cal.setAprobacion(false);
            } else if (cal.getEstatus().equals(CalificacionEstatusEnum.APROBADO.toString())) {
                cal.setAprobacion(true);
            }
        }
        return cal;
    }


    @Transactional
    public Calificacion fromReporteCriterio1V12Calificacion(ReporteCriterio1V1 r, String usuario) {
        Calificacion cal = new Calificacion();
        if (r.getCalificacion() != null && r.getCalificacion().doubleValue() >= 7.0) {
            cal.setAprobacion(true);
        } else {
            cal.setAprobacion(false);
        }
        cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
        cal.setFechaIngreso(new Timestamp(new Date().getTime()));
        cal.setUsuarioIngreso(usuario);
        cal.setUsuarioActualizacion(usuario);
        if (r.getCalificacion() != null) {
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            r.getCalificacion()
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio1.getFraccionPonderacion().multiply(r.getCalificacion())
                    )
            );
        } else {
            cal.setValorCalif(BigDecimal.valueOf(0.00));
            cal.setValorPonderacion(BigDecimal.valueOf(0.00));
        }
        cal.setCriterio(criterio1);
        cal.setDocentesAplicacione(docenteAplicacionRepository.find(r.getIdTramite()));
        if (r.getObservacion() != null) {
            cal.setObservacion(r.getObservacion());
        }
        if (r.getEstatus() != null) {
            cal.setEstatus(r.getEstatus());
            //Reprobar aunque se este aprobado por irregularidades durante la prueba
            if (cal.getEstatus().equals(CalificacionEstatusEnum.REPROBADO.toString())) {
                cal.setAprobacion(false);
            } else if (cal.getEstatus().equals(CalificacionEstatusEnum.APROBADO.toString())) {
                cal.setAprobacion(true);
            }
        }
        return cal;
    }

    public List<Long> findIdsTramiteAplicForIngrPruebaPsiByNipOLD(String nip) {
        return getEntityManager()
                .createNamedQuery("Calificacion.findIdsTramiteAplicForIngrPruebaPsiByNip")
                .setParameter("nip", nip)
                .getResultList();
    }

    public List<Long> findIdsTramiteAplicForIngrPruebaPsiByNip(String nip) {
        return getEntityManager()
                .createNamedQuery("DocenteAplicacion.findIdsTramiteAplicForIngrPruebaPsiByNip")
                .setParameter("nip", nip)
                .getResultList();
    }

    @Transactional
    public List<Calificacion> fromRDPPsiIngrCalif2Calificacion(RDPPsiIngrCalif r, String usuario) {
        List<Calificacion> listado = new ArrayList<>();

        this.findIdsTramiteAplicForIngrPruebaPsiByNip(r.getNip()).stream().forEach(id -> {
            Calificacion cal = new Calificacion();
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setFechaIngreso(new Timestamp(new Date().getTime()));
            cal.setUsuarioIngreso(usuario);
            cal.setUsuarioActualizacion(usuario);
            if (r.getCalificacion() != null) {
                cal.setValorCalif(
                        MathUtil.roundBigDecimal(
                                r.getCalificacion()
                        )
                );
                cal.setValorPonderacion(
                        MathUtil.roundBigDecimal(
                                criterio1.getFraccionPonderacion().multiply(r.getCalificacion())
                        )
                );
            } else {
                cal.setValorCalif(BigDecimal.valueOf(0.00));
                cal.setValorPonderacion(BigDecimal.valueOf(0.00));
            }
            cal.setCriterio(criterio1);
            cal.setDocentesAplicacione(docenteAplicacionRepository.find(id.longValue()));
            if (r.getObservacion() != null) {
                cal.setObservacion(r.getObservacion());
            }
            if (r.getEstatus() != null) {
                cal.setEstatus(r.getEstatus());
                //Reprobar aunque se este aprobado por irregularidades durante la prueba
                if (cal.getEstatus().equals(CalificacionEstatusEnum.REPROBADO.toString())) {
                    cal.setAprobacion(false);
                } else if (cal.getEstatus().equals(CalificacionEstatusEnum.APROBADO.toString())) {
                    cal.setAprobacion(true);
                }
            } else {
                if (cal.getValorCalif() != null && cal.getValorCalif().doubleValue() >= 6.0) {
                    cal.setAprobacion(true);
                } else {
                    cal.setAprobacion(false);
                }
            }
            listado.add(cal);
        });
        return listado;
    }

    public double obtenerCalificacionCriterio5(CalculateCriterio5 r) {
        double calificacion;
        getLogger().info("Puntaje maximo: " + criterio5.getPuntajeMaximo());
        if (r.getIdMuniResidencia().equals(r.getIdMuniPlaza())) {
            calificacion = criterio5.getPuntajeMaximo() * 10.00;
        } else if (r.getIdDepResidencia().equals(r.getIdDepPlaza())) {
            calificacion = criterio5.getPuntajeMaximo() * 10.00 * 0.66;
        } else {
            calificacion = criterio5.getPuntajeMaximo() * 10.00 * 0.33;
        }
        return calificacion;
    }

    public double obtenerCalificacionCriterio5(DocenteAplicacion da){
        CalculateCriterio5 c = new CalculateCriterio5();
        c.setIdDepPlaza(da.getPlaza().getCentrosEducativo().getMunicipioBean().getDepartamento().getCodInstitucional());
        c.setIdMuniPlaza(da.getPlaza().getCentrosEducativo().getMunicipioBean().getCodInstitucional());
        c.setIdTramite(da.getIdTramiteAplic());
        c.setIdDepResidencia(da.getDocente().getMunicipioBean().getDepartamento().getCodInstitucional());
        c.setIdMuniResidencia(da.getDocente().getMunicipioBean().getCodInstitucional());
        return obtenerCalificacionCriterio5(c);
    }

    @Transactional
    public Calificacion fromCalculateCriterio52CalificacionCriterio5(CalculateCriterio5 r, String usuario) {
        Calificacion cal = new Calificacion();
        double valorCalif = obtenerCalificacionCriterio5(r);
        getLogger().info("valorCalif: " + valorCalif);
        cal.setValorCalif(
                MathUtil.roundBigDecimal(
                        BigDecimal.valueOf(valorCalif)
                )
        );
        cal.setValorPonderacion(
                MathUtil.roundBigDecimal(
                        criterio5.getFraccionPonderacion().multiply(cal.getValorCalif())
                )
        );
        cal.setAprobacion(true);
        cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
        cal.setFechaIngreso(new Timestamp(new Date().getTime()));
        cal.setUsuarioIngreso(usuario);
        cal.setUsuarioActualizacion(usuario);
        cal.setCriterio(criterio5);
        cal.setDocentesAplicacione(docenteAplicacionRepository.find(r.getIdTramite().longValue()));
        cal.setObservacion(AUTOGENERADO + CRITERIO5);
        cal.setEstatus("APROBADO");
        return cal;
    }

    @Transactional
    public Map<String, Long> saveExcelFileCriterio2PruebaConocimientos(
            List<ReporteCriterio2> listadoCalificaciones, String usuario) {
        Map<String, Long> report = new HashMap<>();
        int procesados = listadoCalificaciones.size();
        AtomicLong guardados = new AtomicLong(0);
        AtomicLong existentes = new AtomicLong(0);
        AtomicLong sinCalificacion = new AtomicLong(0);
        listadoCalificaciones.stream().forEach(r -> {
            Calificacion c = fromReporteCriterio12Calificacion(r, usuario);
            if (c != null) {
                Long counter = countByIdCriterioAndIdTramiteAplic(criterio2.getIdCriterio(),
                        c.getDocentesAplicacione().getIdTramiteAplic());
                if (counter == 0 && c.getValorCalif() != null && c.getValorCalif().intValue() > 0) {
                    this.create(c);
                    guardados.incrementAndGet();
                } else {
                    if (counter > 0) {
                        getLogger().info("Calificacion Criterio 2 previamente ingresada! para idTramiteAplic: "
                                + c.getDocentesAplicacione().getIdTramiteAplic());
                        existentes.incrementAndGet();
                    }
                    if (c.getValorCalif() == null) {
                        getLogger().info("Calificacion Criterio 2 no ingresada para idTramiteAplic: "
                                + c.getDocentesAplicacione().getIdTramiteAplic() +
                                " skipping...");
                        sinCalificacion.incrementAndGet();
                    }
                }
            }
        });
        report.put(CalificacionSaveEnum.Procesados.toString(), Long.valueOf(procesados));
        report.put(CalificacionSaveEnum.Existentes.toString(), existentes.get());
        report.put(CalificacionSaveEnum.Guardados.toString(), guardados.get());
        report.put(CalificacionSaveEnum.Sin_Calificacion.toString(), sinCalificacion.get());
        getLogger().info(report);
        return report;
    }

    @Transactional
    public Map<String, Long> saveExcelFileCriterio2V2PruebaConocimientos(
            List<ReporteCriterio2V2> listadoCalificaciones, String usuario) {
        Map<String, Long> report = new HashMap<>();
        int procesados = listadoCalificaciones.size();
        AtomicLong guardados = new AtomicLong(0);
        AtomicLong existentes = new AtomicLong(0);
        AtomicLong sinCalificacion = new AtomicLong(0);
        listadoCalificaciones.stream().forEach(r -> {
            Calificacion c = fromReporteCriterio2V22Calificacion(r, usuario);
            if (c != null) {
                Long counter = countByIdCriterioAndIdTramiteAplic(criterio2.getIdCriterio(),
                        c.getDocentesAplicacione().getIdTramiteAplic());
                if (counter == 0 && c.getValorCalif() != null && c.getValorCalif().intValue() > 0) {
                    this.create(c);
                    guardados.incrementAndGet();
                } else {
                    if (counter > 0) {
                        getLogger().info("Calificacion Criterio 2 V2 previamente ingresada! para idTramiteAplic: "
                                + c.getDocentesAplicacione().getIdTramiteAplic());
                        existentes.incrementAndGet();
                    }
                    if (c.getValorCalif() == null) {
                        getLogger().info("Calificacion Criterio 2 V2 no ingresada para idTramiteAplic: "
                                + c.getDocentesAplicacione().getIdTramiteAplic() +
                                " skipping...");
                        sinCalificacion.incrementAndGet();
                    }
                }
            }
        });
        report.put(CalificacionSaveEnum.Procesados.toString(), Long.valueOf(procesados));
        report.put(CalificacionSaveEnum.Existentes.toString(), existentes.get());
        report.put(CalificacionSaveEnum.Guardados.toString(), guardados.get());
        report.put(CalificacionSaveEnum.Sin_Calificacion.toString(), sinCalificacion.get());
        getLogger().info(report);
        return report;
    }

    @Transactional
    public Map<String, Long> saveExcelFileCriterio1V1PruebaPsicometrica(
            List<ReporteCriterio1V1> listadoCalificaciones, String usuario) {
        Map<String, Long> report = new HashMap<>();
        int procesados = listadoCalificaciones.size();
        AtomicLong guardados = new AtomicLong(0);
        AtomicLong existentes = new AtomicLong(0);
        AtomicLong sinCalificacion = new AtomicLong(0);
        listadoCalificaciones.stream().forEach(r -> {
            Calificacion c = fromReporteCriterio1V12Calificacion(r, usuario);
            if (c != null) {
                Long counter = countByIdCriterioAndIdTramiteAplic(criterio1.getIdCriterio(),
                        c.getDocentesAplicacione().getIdTramiteAplic());
                if (counter == 0 && c.getValorCalif() != null && c.getValorCalif().intValue() > 0) {
                    this.create(c);
                    guardados.incrementAndGet();
                } else {
                    if (counter > 0) {
                        getLogger().info("Calificacion Criterio 1 V1 previamente ingresada! para idTramiteAplic: "
                                + c.getDocentesAplicacione().getIdTramiteAplic());
                        existentes.incrementAndGet();
                    }
                    if (c.getValorCalif() == null) {
                        getLogger().info("Calificacion Criterio 1 V1 no ingresada para idTramiteAplic: "
                                + c.getDocentesAplicacione().getIdTramiteAplic() +
                                " skipping...");
                        sinCalificacion.incrementAndGet();
                    }
                }
            }
        });
        report.put(CalificacionSaveEnum.Procesados.toString(), Long.valueOf(procesados));
        report.put(CalificacionSaveEnum.Existentes.toString(), existentes.get());
        report.put(CalificacionSaveEnum.Guardados.toString(), guardados.get());
        report.put(CalificacionSaveEnum.Sin_Calificacion.toString(), sinCalificacion.get());
        getLogger().info(report);
        return report;
    }

    @Transactional
    public void updateCalificaciones(Calificacion c, RDPPsiIngrCalif r, String usuario) {
        c.setValorCalif(MathUtil.roundBigDecimal(r.getCalificacion()));
        c.setValorPonderacion(MathUtil.roundBigDecimal(criterio1.getFraccionPonderacion().multiply(r.getCalificacion())));
        c.setFechaActualizacion(new Timestamp(new Date().getTime()));
        c.setUsuarioActualizacion(usuario);
        if (r.getEstatus() != null) {
            c.setEstatus(r.getEstatus());
            //Reprobar aunque se este aprobado por irregularidades durante la prueba
            if (c.getEstatus().equals(CalificacionEstatusEnum.REPROBADO.toString())) {
                c.setAprobacion(false);
            } else if (c.getEstatus().equals(CalificacionEstatusEnum.APROBADO.toString())) {
                c.setAprobacion(true);
            }
        } else {
            if (c.getValorCalif() != null && c.getValorCalif().doubleValue() >= 6.0) {
                c.setAprobacion(true);
            } else {
                c.setAprobacion(false);
            }
        }

    }

    @Transactional
    public Map<String, Long> saveExcelFileCriterio1V1PruebaPsicometricaNew(
            List<RDPPsiIngrCalif> listadoCalificaciones, String usuario) {
        Map<String, Long> report = new HashMap<>();
        int procesados = listadoCalificaciones.size();
        AtomicLong guardados = new AtomicLong(0);
        AtomicLong existentes = new AtomicLong(0);
        AtomicLong sinCalificacion = new AtomicLong(0);
        listadoCalificaciones.stream().forEach(r -> {
            getLogger().info("Processing NIP: " + r.getNip() + " for Docente: " + r.getNombreCompleto());
            fromRDPPsiIngrCalif2Calificacion(r, usuario).stream().forEach(c -> {
                if (c != null) {
                    Long counter = countByIdCriterioAndIdTramiteAplic(criterio1.getIdCriterio(),
                            c.getDocentesAplicacione().getIdTramiteAplic());
                    if (counter == 0 && c.getValorCalif() != null && c.getValorCalif().intValue() >= 0) {
                        this.create(c);
                        guardados.incrementAndGet();
                    } else {
                        if (counter > 0) {
                            getLogger().info("Calificacion Criterio 1 V1 previamente ingresada! para idTramiteAplic: "
                                    + c.getDocentesAplicacione().getIdTramiteAplic());
                            existentes.incrementAndGet();
                            getLogger().info("Actualizando Calificacion Criterio 1 V1 previamente ingresada! para idTramiteAplic: "
                                    + c.getDocentesAplicacione().getIdTramiteAplic());
                            updateCalificaciones(c, r, usuario);
                            this.edit(c);
                        }
                        if (c.getValorCalif() == null) {
                            getLogger().info("Calificacion Criterio 1 V1 no ingresada para idTramiteAplic: "
                                    + c.getDocentesAplicacione().getIdTramiteAplic() +
                                    " skipping...");
                            sinCalificacion.incrementAndGet();
                        }
                    }
                }
            });

        });
        report.put(CalificacionSaveEnum.Procesados.toString(), Long.valueOf(procesados));
        report.put(CalificacionSaveEnum.Existentes.toString(), existentes.get());
        report.put(CalificacionSaveEnum.Guardados.toString(), guardados.get());
        report.put(CalificacionSaveEnum.Sin_Calificacion.toString(), sinCalificacion.get());
        getLogger().info(report);
        return report;
    }

    @Transactional
    public void saveOneCriterio5(CalculateCriterio5 r, String usuario, AtomicLong guardados, AtomicLong existentes, AtomicLong sinCalificacion) {
        getLogger().info("r=" + r.toString());
        Calificacion c = fromCalculateCriterio52CalificacionCriterio5(r, usuario);
        getLogger().info("Calificacion: " + c.getValorCalif() + " ponderacion: " + c.getValorPonderacion());
        if (c != null) {
            Long counter = countByIdCriterioAndIdTramiteAplic(criterio5.getIdCriterio(),
                    c.getDocentesAplicacione().getIdTramiteAplic());
            if (counter == 0 && c.getValorCalif() != null && c.getValorCalif().intValue() > 0) {
                this.create(c);
                guardados.incrementAndGet();
            } else {
                if (counter > 0) {
                    getLogger().info("Calificacion Criterio 5 previamente ingresada! para idTramiteAplic: "
                            + c.getDocentesAplicacione().getIdTramiteAplic());
                    existentes.incrementAndGet();
                }
                if (c.getValorCalif() == null) {
                    getLogger().info("Calificacion Criterio 5 no ingresada para idTramiteAplic: "
                            + c.getDocentesAplicacione().getIdTramiteAplic() +
                            " skipping...");
                    sinCalificacion.incrementAndGet();
                }
            }
        }
    }

    @Transactional
    public Map<String, Long> saveCriterio5ResidenciaDocente(
            List<CalculateCriterio5> listadoCalificaciones, String usuario) {
        Map<String, Long> report = new HashMap<>();
        int procesados = listadoCalificaciones.size();
        AtomicLong guardados = new AtomicLong(0);
        AtomicLong existentes = new AtomicLong(0);
        AtomicLong sinCalificacion = new AtomicLong(0);
        listadoCalificaciones.stream().forEach(r -> saveOneCriterio5(r, usuario, guardados, existentes, sinCalificacion));
        report.put(CalificacionSaveEnum.Procesados.toString(), Long.valueOf(procesados));
        report.put(CalificacionSaveEnum.Existentes.toString(), existentes.get());
        report.put(CalificacionSaveEnum.Guardados.toString(), guardados.get());
        report.put(CalificacionSaveEnum.Sin_Calificacion.toString(), sinCalificacion.get());
        getLogger().info(report);
        return report;
    }

    public Map<String, Long> saveCriterio5NewResidenciaDocente(List<TramiteAplicacionDocente> tramites, String usuario) {
        Map<String, Long> report = new HashMap<>();

        return report;
    }

    public double obtenerCalificacionCriterio3a(BigDecimal annios) {
        double calificacion = 0.00;
        getLogger().info("Puntaje maximo: " + criterio3a.getPuntajeMaximo());
        if (annios.doubleValue() >= 0.90 && annios.doubleValue() < 3.1) {
            calificacion = criterio3a.getPuntajeMaximo() * 10.00 * 0.33;
        } else if (annios.doubleValue() >= 3.1 && annios.doubleValue() < 6.1) {
            calificacion = criterio3a.getPuntajeMaximo() * 10.00 * 0.66;
        } else if (annios.doubleValue() >= 6.1) {
            calificacion = criterio3a.getPuntajeMaximo() * 10.00;
        }
        return calificacion;
    }

    @Transactional
    public double obtenerCalificacionCriterio3b(Docente d) {
        double calificacion = 0.00;
        if (d.getValidacionDeInterino() != null && d.getValidacionDeInterino().booleanValue()) {
            calificacion = 10.00;
        }
        return calificacion;
    }

    public double obtenerPonderacionCriterio3a(double nota) {
        return criterio3a.getFraccionPonderacion().multiply(BigDecimal.valueOf(nota)).doubleValue();
    }

    @Transactional
    public Calificacion obtenerCalificacionCriterio3aObject(DocenteAplicacion da, double nota, String usuario) {

        Calificacion cal = findByIdCriterioAndIdTramiteAplic(criterio3a.getIdCriterio(), da.getIdTramiteAplic());
        if (cal == null) {
            cal = new Calificacion();
            double valorCalif = nota;
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio3a.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setAprobacion(true);
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setFechaIngreso(new Timestamp(new Date().getTime()));
            cal.setUsuarioIngreso(usuario);
            cal.setUsuarioActualizacion(usuario);
            cal.setCriterio(criterio3a);
            cal.setDocentesAplicacione(docenteAplicacionRepository.find(da.getIdTramiteAplic()));
            cal.setObservacion(AUTOGENERADO + CRITERIO3A);
            cal.setEstatus("APROBADO");
        } else {
            double valorCalif = nota;
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio3a.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setUsuarioActualizacion(usuario);
            cal.setObservacion(AUTOGENERADO + CRITERIO3A + " Updated!");
        }
        return cal;
    }

    public double obtenerNotaCriterio4a(List<Integer> dbplazas, long idSecuencial) {
        Integer idSecuencialInteger = Integer.valueOf(Math.toIntExact(idSecuencial));
        if (dbplazas == null) {
            dbplazas = new ArrayList<>();
        }
        long exists = dbplazas.stream().filter(c -> c.equals(idSecuencialInteger)).count();
        if (exists == 1) {
            return 10.00;
        } else {
            return 0.00;
        }
    }

    public List<List<Integer>> getIdPlazasDBByIdSigobsolUsuarioFromCapacitaciones(long idSigobsolUsuario) {
        List<DocenteCapacitacion> capacitacionesConPlazasHomologadas =
                docenteCapacitacionRepository.findByIdSigobsolUsuario(idSigobsolUsuario)
                        .stream().filter(
                                de -> (de.getPlazasHomologadas() != null && !de.getPlazasHomologadas().equals(""))
                        )
                        .collect(Collectors.toList());
        List<List<String>> text = new ArrayList<>();
        capacitacionesConPlazasHomologadas.stream().forEach(dc -> {
                    List<String> current = Arrays.asList(
                            dc.getPlazasHomologadas()
                                    .replaceAll("\\r|\\n", "")
                                    .replaceAll("\\.", ",")
                                    .replaceAll("\\s", "")
                                    .replaceAll("[^0-9\\,]", "")
                                    .trim()
                                    .split(",")
                    );
                    text.add(current);
                }
        );
        List<List<Integer>> result = new ArrayList<>();
        text.stream().forEach(
                current -> result.add(
                        current.stream()
                                .filter(c -> !c.equals(""))
                                .map(Integer::valueOf).collect(Collectors.toList())
                )
        );
        return result;
    }

    @Transactional
    public double obtenerNotaCriterio4b(DocenteAplicacion da) {
        double f = 0.00;
        List<List<Integer>> db =
                getIdPlazasDBByIdSigobsolUsuarioFromCapacitaciones(da.getDocente().getIdSigobsolUsuario());
        AtomicLong contador = new AtomicLong(0);
        db.stream().forEach(current -> {
            long count = current.stream()
                    .filter(c -> c.equals(Integer.valueOf(Math.toIntExact(da.getPlaza().getIdSecuencial()))))
                    .count();
            if (count >= 1) {
                contador.incrementAndGet();
            }
        });
        f = 2.00 * contador.get();
        return f;
    }

    @Transactional
    public Calificacion obtenerCalificacionCriterio4aObject(DocenteAplicacion da, String usuario, List<Integer> dbplazas) {
        Calificacion cal = findByIdCriterioAndIdTramiteAplic(criterio4a.getIdCriterio(), da.getIdTramiteAplic());
        if (cal == null) {
            cal = new Calificacion();
            double valorCalif = obtenerNotaCriterio4a(dbplazas, da.getPlaza().getIdSecuencial());
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio4a.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setAprobacion(true);
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setFechaIngreso(new Timestamp(new Date().getTime()));
            cal.setUsuarioIngreso(usuario);
            cal.setUsuarioActualizacion(usuario);
            cal.setCriterio(criterio4a);
            cal.setDocentesAplicacione(docenteAplicacionRepository.find(da.getIdTramiteAplic()));
            cal.setObservacion(AUTOGENERADO + CRITERIO4A);
            cal.setEstatus("APROBADO");
        } else {
            double valorCalif = obtenerNotaCriterio4a(dbplazas, da.getPlaza().getIdSecuencial());
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio4a.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setUsuarioActualizacion(usuario);
            cal.setObservacion(AUTOGENERADO + CRITERIO4A + " Updated!");
        }
        return cal;
    }

    @Transactional
    public Calificacion obtenerCalificacionCriterio4bObject(DocenteAplicacion da, String usuario) {
        Calificacion cal = findByIdCriterioAndIdTramiteAplic(criterio4b.getIdCriterio(), da.getIdTramiteAplic());
        if (cal == null) {
            cal = new Calificacion();
            double valorCalif = obtenerNotaCriterio4b(da);
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio4b.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setAprobacion(true);
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setFechaIngreso(new Timestamp(new Date().getTime()));
            cal.setUsuarioIngreso(usuario);
            cal.setUsuarioActualizacion(usuario);
            cal.setCriterio(criterio4b);
            cal.setDocentesAplicacione(docenteAplicacionRepository.find(da.getIdTramiteAplic()));
            cal.setObservacion(AUTOGENERADO + CRITERIO4B);
            cal.setEstatus("APROBADO");
        } else {
            double valorCalif = obtenerNotaCriterio4b(da);
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio4b.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setUsuarioActualizacion(usuario);
            cal.setObservacion(AUTOGENERADO + CRITERIO4B + " Updated!");
        }
        return cal;
    }

    @Transactional
    public Calificacion obtenerCalificacionCriterio5Object(DocenteAplicacion da, String usuario) {
        Calificacion cal = findByIdCriterioAndIdTramiteAplic(criterio5.getIdCriterio(), da.getIdTramiteAplic());
        if (cal == null) {
            cal = new Calificacion();
            double valorCalif = obtenerCalificacionCriterio5(da);
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio5.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setAprobacion(true);
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setFechaIngreso(new Timestamp(new Date().getTime()));
            cal.setUsuarioIngreso(usuario);
            cal.setUsuarioActualizacion(usuario);
            cal.setCriterio(criterio5);
            cal.setDocentesAplicacione(docenteAplicacionRepository.find(da.getIdTramiteAplic()));
            cal.setObservacion(AUTOGENERADO + CRITERIO5);
            cal.setEstatus("APROBADO");
        } else {
            double valorCalif = obtenerCalificacionCriterio5(da);
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio5.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setUsuarioActualizacion(usuario);
            cal.setObservacion(AUTOGENERADO + CRITERIO5 + " Updated!");
        }
        return cal;
    }

    @Transactional
    public Calificacion obtenerCalificacionCriterio3bObject(DocenteAplicacion da, double nota, String usuario) {
        Calificacion cal = findByIdCriterioAndIdTramiteAplic(criterio3b.getIdCriterio(), da.getIdTramiteAplic());
        if (cal == null) {
            cal = new Calificacion();
            double valorCalif = nota;
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio3b.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setAprobacion(true);
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setFechaIngreso(new Timestamp(new Date().getTime()));
            cal.setUsuarioIngreso(usuario);
            cal.setUsuarioActualizacion(usuario);
            cal.setCriterio(criterio3b);
            cal.setDocentesAplicacione(docenteAplicacionRepository.find(da.getIdTramiteAplic()));
            cal.setObservacion(AUTOGENERADO + CRITERIO3B);
            cal.setEstatus("APROBADO");
        } else {
            double valorCalif = nota;
            getLogger().info("valorCalif: " + valorCalif);
            cal.setValorCalif(
                    MathUtil.roundBigDecimal(
                            BigDecimal.valueOf(valorCalif)
                    )
            );
            cal.setValorPonderacion(
                    MathUtil.roundBigDecimal(
                            criterio3b.getFraccionPonderacion().multiply(cal.getValorCalif())
                    )
            );
            cal.setFechaActualizacion(new Timestamp(new Date().getTime()));
            cal.setUsuarioActualizacion(usuario);
            cal.setObservacion(AUTOGENERADO + CRITERIO3B + " Updated!");
        }
        return cal;
    }

    public List<Calificacion> fromDocente_2_CalificacionListCriterio3a(Docente d, String currentUser) {
        List<Calificacion> data = new ArrayList<>();
        BigDecimal annios = docenteExperienciaRepository.calculateSumOfExperiencias(d.getIdSigobsolUsuario());
        double nota = obtenerCalificacionCriterio3a(annios);
        double ponderacion = obtenerPonderacionCriterio3a(nota);
        List<DocenteAplicacion> aplicaciones = docenteAplicacionRepository
                .findByIdSigobsolUsuarioNoRechazadas(d.getIdSigobsolUsuario());
        aplicaciones.stream().forEach(da ->
                data.add(obtenerCalificacionCriterio3aObject(da, nota, currentUser)));
        return data;
    }

    public List<Calificacion> fromDocente_2_CalificacionListCriterio3b(Docente d, String currentUser) {
        List<Calificacion> data = new ArrayList<>();
        double nota = obtenerCalificacionCriterio3b(d);
        List<DocenteAplicacion> aplicaciones = docenteAplicacionRepository
                .findByIdSigobsolUsuarioNoRechazadas(d.getIdSigobsolUsuario());
        aplicaciones.stream().forEach(da ->
                data.add(obtenerCalificacionCriterio3bObject(da, nota, currentUser)));
        return data;
    }

    @Deprecated
    public List<String> corregirPlazasHomologadas(String plazasHomologadas) {
        String temporal = plazasHomologadas.replaceAll("\\r|\\n", "")
                .replaceAll("\\.", ",")
                .replaceAll("\\s", "")
                .replaceAll("[^0-9\\,]", "")
                .trim();
        List<String> salida = Arrays.asList(temporal.split(","));
        List<String> corregir = salida.stream().filter(c -> c.length() > 4 && c.length() % 4 == 0).collect(Collectors.toList());
        salida.removeAll(corregir);
        corregir.stream().forEach(c -> {
            if (c.length() % 4 == 0) {

            }
        });

        return salida;
    }

    public List<Integer> getIdPlazasDBByIdSigobsolUsuarioFromEstudios(long idSigobsolUsuario) {
        List<DocenteEstudio> estudiosConPlazasHomologadas =
                docenteEstudioRepository.findByIdSigobsolUsuario(idSigobsolUsuario)
                        .stream().filter(
                                de -> (de.getPlazasHomologadas() != null && !de.getPlazasHomologadas().equals(""))
                                       // ||(de.getValido() != null && de.getValido().booleanValue())
                        )
                        .collect(Collectors.toList());
        List<DocenteEstudio> validacionExtra = estudiosConPlazasHomologadas.stream()
                .filter(de->de.getValido()!=null && de.getValido().booleanValue()!=false )
                .collect(Collectors.toList());

        getLogger().info(validacionExtra);
        List<String> lista = new ArrayList<>();
        validacionExtra.stream().forEach(de ->
                lista.addAll(Arrays.asList(
                        de.getPlazasHomologadas()
                                .replaceAll("\\r|\\n", "")
                                .replaceAll("\\.", ",")
                                .replaceAll("\\s", "")
                                .replaceAll("[^0-9\\,]", "")
                                .trim()
                                .split(",")
                )));
        return lista.stream().distinct().collect(Collectors.toList())
                .stream().filter(c -> !c.equals(""))
                .map(Integer::valueOf).collect(Collectors.toList());
    }

    public Long contarCapacitacionesHomologadas(long idSigobsolUsuario) {
        Long r = Long.valueOf(docenteCapacitacionRepository.findByIdSigobsolUsuario(idSigobsolUsuario)
                .stream().filter(
                        de -> (de.getPlazasHomologadas() != null && !de.getPlazasHomologadas().equals("")) &&
                                (de.getValido() != null && de.getValido().booleanValue())
                ).count());
        return r;
    }

    public List<Calificacion> fromDocente_2_CalificacionListCriterio4a(Docente d, String currentUser) {
        List<Calificacion> data = new ArrayList<>();
        List<Integer> dbplazas = getIdPlazasDBByIdSigobsolUsuarioFromEstudios(d.getIdSigobsolUsuario());
        List<DocenteAplicacion> aplicaciones = docenteAplicacionRepository
                .findByIdSigobsolUsuarioNoRechazadas(d.getIdSigobsolUsuario());
        aplicaciones.stream().forEach(da ->
                data.add(obtenerCalificacionCriterio4aObject(da, currentUser, dbplazas)));
        return data;
    }

    public List<Calificacion> fromDocente_2_CalificacionListCriterio4b(Docente d, String currentUser) {
        List<Calificacion> data = new ArrayList<>();
        List<DocenteAplicacion> aplicaciones = docenteAplicacionRepository
                .findByIdSigobsolUsuarioNoRechazadas(d.getIdSigobsolUsuario());
        aplicaciones.stream().forEach(da ->
                data.add(obtenerCalificacionCriterio4bObject(da, currentUser)));
        return data;
    }

    public List<Calificacion> fromDocente_2_CalificacionListCriterio5(Docente d, String currentUser) {
        List<Calificacion> data = new ArrayList<>();
        List<DocenteAplicacion> aplicaciones = docenteAplicacionRepository
                .findByIdSigobsolUsuarioNoRechazadas(d.getIdSigobsolUsuario());
        aplicaciones.stream().forEach(da ->
                data.add(obtenerCalificacionCriterio5Object(da, currentUser)));
        return data;
    }

    @Transactional
    public void merge(Calificacion c) {
        if (find(c.getIdCalificacion()) == null) {
            this.create(c);
        } else {
            this.edit(c);
        }
    }

    @Transactional
    public void mergeList(List<Calificacion> lista) {
        lista.stream().forEach(c -> this.merge(c));
    }

    public Calificacion findByIdCriterioAndIdTramiteAplic(long idCriterio, long idTramiteAplic) {
        List<Calificacion> cals = getEntityManager()
                .createNamedQuery("Calificacion.findByIdCriterioAndIdTramiteAplic")
                .setParameter("idCriterio", idCriterio)
                .setParameter("idTramiteAplic", idTramiteAplic)
                .getResultList();
        if (cals.isEmpty()) {
            return null;
        } else {
            return cals.get(0);
        }
    }
    @Transactional
    public List<Calificacion> getAllCalificacionesByIdTramiteAplic(long idTramiteAplic){
        return getEntityManager()
                .createNamedQuery("Calificacion.findByIdTramiteAplic")
                .setParameter("idTramiteAplic",idTramiteAplic)
                .getResultList();
    }

}
