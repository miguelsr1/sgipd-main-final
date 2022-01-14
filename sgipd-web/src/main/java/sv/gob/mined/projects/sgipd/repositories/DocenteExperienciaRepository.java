package sv.gob.mined.projects.sgipd.repositories;

import org.keycloak.representations.AccessToken;
import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.utils.XClassUtil;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.print.Doc;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DocenteExperienciaRepository extends GenericRepository<DocenteExperiencia> {
    public static final String OTRA_EXP = "OTRA_EXPERIENCIA";
    public static final Boolean OTRA_EXP_INT = Boolean.getBoolean("false");

    private Timestamp el31;

    @Inject
    MunicipioRepository municipioRepository;

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteExperienciaRepository() {
        super(DocenteExperiencia.class);
    }

    @PostConstruct
    public void init() {
        el31 = get31();
    }

    public Timestamp get31() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate el31 = LocalDate.of(2021, 12, 31);
        Date t1 = Date.from(el31.atStartOfDay(defaultZoneId).toInstant());
        return new Timestamp(t1.getTime());
    }

    public BigDecimal calcularAnniosEntreFechasMSSQL(Timestamp desde, Timestamp hasta) {

        StoredProcedureQuery query = getEntityManager()
                .createStoredProcedureQuery("p_calcularAnniosEntreFechas")
                .registerStoredProcedureParameter(1, Timestamp.class,
                        ParameterMode.IN)
                .registerStoredProcedureParameter(2, Timestamp.class,
                        ParameterMode.IN)
                .registerStoredProcedureParameter(3, BigDecimal.class,
                        ParameterMode.OUT)
                .setParameter(1, desde.after(el31) ? get31() : desde)
                .setParameter(2, hasta.after(el31) ? get31() : hasta);

        query.execute();

        BigDecimal annios = (BigDecimal) query.getOutputParameterValue(3);
        return annios;
    }

    public DocenteExperiencia findByIdSigobsolUsuarioAndIndiceExperiencia(long idSigobsolUsuario, short indiceExperiencia) {
        List<DocenteExperiencia> list = getEntityManager()
                .createNamedQuery("DocenteExperiencia.byIdSigobsolUsuarioAndIndiceExperiencia", DocenteExperiencia.class)
                .setParameter("idSigobsolUsuario", idSigobsolUsuario)
                .setParameter("indiceExperiencia", indiceExperiencia)
                .getResultList();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public BigDecimal getAnnios(long idSigobsolUsuario, short indiceExperiencia) {
        DocenteExperiencia de = findByIdSigobsolUsuarioAndIndiceExperiencia(idSigobsolUsuario, indiceExperiencia);
        return calcularAnniosEntreFechasMSSQL(de.getDesdeActualizado(), de.getHastaActualizado());
    }


    @Transactional
    public DocenteExperiencia prepareNewOtrasExperiencias(NuevosDatosExpediente p, Integer indiceExperiencia,
                                                          String currentUser) {
        DocenteExperiencia de = new DocenteExperiencia();
        String departamento = XClassUtil.getStringByNombreAndIndiceOE(p,
                "departamentoOtraExperienciaLaboral", indiceExperiencia);
        de.setDepartamento(departamento != null ? departamento : "");
        de.setIdSigobsolUsuario(p.getCodigoDeSolicitante().longValue());
        de.setIndiceExperiencia(indiceExperiencia.shortValue());
        String institucionOtraExperienciaLaboral = XClassUtil.getStringByNombreAndIndiceOE(p,
                "institucionOtraExperienciaLaboral", indiceExperiencia);
        de.setInstitucionEducativaNacional(institucionOtraExperienciaLaboral != null ?
                institucionOtraExperienciaLaboral : "");
        String municipioOtraExperienciaLaboral = XClassUtil.getStringByNombreAndIndiceOE(p,
                "municipioOtraExperienciaLaboral", indiceExperiencia);
        de.setMunicipio(municipioOtraExperienciaLaboral != null ? municipioOtraExperienciaLaboral : "");
        de.setNombramiento(OTRA_EXP);
        String sectorOtraExperienciaLaboral = XClassUtil.getStringByNombreAndIndiceOE(p,
                "sectorOtraExperienciaLaboral", indiceExperiencia);
        de.setSector(sectorOtraExperienciaLaboral != null ? sectorOtraExperienciaLaboral : "");
        Timestamp fechaInicioOtraExperienciaLaboral = XClassUtil.getFechaByNombreAndIndiceOE(p,
                "fechaInicioOtraExperienciaLaboral", indiceExperiencia);
        if (fechaInicioOtraExperienciaLaboral != null) {
            de.setDesde(fechaInicioOtraExperienciaLaboral);
        }
        Timestamp fechaFinOtraExperienciaLaboral = XClassUtil.getFechaByNombreAndIndiceOE(p,
                "fechaFinOtraExperienciaLaboral", indiceExperiencia);
        if (fechaFinOtraExperienciaLaboral != null) {
            de.setHasta(fechaFinOtraExperienciaLaboral);
        }
        Boolean datosValidosOtraExperienciaLaboral = XClassUtil.getBooleanByNombreAndIndiceOE(p,
                "datosValidosOtraExperienciaLaboral", indiceExperiencia);
        Timestamp desdeCorregido = XClassUtil.getFechaByNombreAndIndiceOE(p,
                "fechaInicioCorregidaOtraExperienciaLaboral", indiceExperiencia);
        if (desdeCorregido != null) {
            de.setDesdeCorregido(desdeCorregido);
        }
        Timestamp hastaCorregido = XClassUtil.getFechaByNombreAndIndiceOE(p,
                "fechaFinCorregidaOtraExperienciaLaboral", indiceExperiencia);
        if (hastaCorregido != null) {
            de.setHastaCorregido(hastaCorregido);
        }
        if (datosValidosOtraExperienciaLaboral != null) {
            de.setExperienciaValida(datosValidosOtraExperienciaLaboral);
        } else {
            de.setExperienciaValida(Boolean.FALSE);
        }
        getLogger().info("desde_" + indiceExperiencia + "=" + de.getDesde() +
                " desde_corregido_" + indiceExperiencia + "=" + de.getDesdeCorregido() +
                ", desde_actualizado_" + indiceExperiencia + "=" + de.getDesdeActualizado());
        getLogger().info("hasta_" + indiceExperiencia + "=" + de.getHasta() +
                " hasta_corregido_" + indiceExperiencia + "=" + de.getHastaCorregido() +
                ", hasta_actualizado_" + indiceExperiencia + "=" + de.getHastaActualizado());
        if (de.getDesdeActualizado() != null && de.getHastaActualizado() != null) {
            de.setCantidadDeAnnios(calcularAnniosEntreFechasMSSQL(de.getDesdeActualizado(), de.getHastaActualizado()));
        } else {
            de.setCantidadDeAnnios(BigDecimal.valueOf(0.00));
        }
        de.setFechaActualizacion(new Timestamp(new Date().getTime()));
        de.setUsuarioActualizacion(currentUser);
        de.setInterino(OTRA_EXP_INT);
        return de;
    }

    public DocenteExperiencia updateOne(NuevosDatosExpediente p, Integer indiceExperiencia, DocenteExperiencia de, String currentUser) {
        getLogger().info("Processing: experiencia indice: " + indiceExperiencia + " idSigobsolUsuario=" + de.getIdSigobsolUsuario());
        Boolean experienciaValida =
                XClassUtil.getBooleanByNombreAndIndice(p, "datosValidosExperienciaLaboral",
                        indiceExperiencia);
        Timestamp desde = XClassUtil.getFechaByNombreAndIndice(p, "desde", indiceExperiencia);
        if (desde != null) {
            de.setDesde(desde);
        }
        Timestamp hasta = XClassUtil.getFechaByNombreAndIndice(p, "hasta", indiceExperiencia);
        if (hasta != null) {
            de.setHasta(hasta);
        }

        if (experienciaValida != null) {
            de.setExperienciaValida(experienciaValida);
        }else{
            de.setExperienciaValida(Boolean.FALSE);
        }
        Timestamp desdeCorregido = XClassUtil.getFechaByNombreAndIndice(p,
                "fechaInicioCorregidaExperienciaLaboral", indiceExperiencia);
        if (desdeCorregido != null) {
            de.setDesdeCorregido(desdeCorregido);
        }
        Timestamp hastaCorregido = XClassUtil.getFechaByNombreAndIndice(p,
                "fechaFinCorregidaExperienciaLaboral", indiceExperiencia);
        if (hastaCorregido != null) {
            de.setHastaCorregido(hastaCorregido);
        }
        getLogger().info("desde_" + indiceExperiencia + "=" + de.getDesde() +
                " desde_corregido_" + indiceExperiencia + "=" + de.getDesdeCorregido() +
                ", desde_actualizado_" + indiceExperiencia + "=" + de.getDesdeActualizado());
        getLogger().info("hasta_" + indiceExperiencia + "=" + de.getHasta() +
                " hasta_corregido_" + indiceExperiencia + "=" + de.getHastaCorregido() +
                ", hasta_actualizado_" + indiceExperiencia + "=" + de.getHastaActualizado());
        if (de.getDesdeActualizado() != null && de.getHastaActualizado() != null) {
            de.setCantidadDeAnnios(calcularAnniosEntreFechasMSSQL(de.getDesdeActualizado(), de.getHastaActualizado()));
        } else {
            de.setCantidadDeAnnios(BigDecimal.valueOf(0.00));
        }
        de.setFechaActualizacion(new Timestamp(new Date().getTime()));
        de.setUsuarioActualizacion(currentUser);
        return de;
    }

    @Transactional
    public DocenteExperiencia updateOneOtrasExperiencias(NuevosDatosExpediente p, Integer indiceExperiencia, DocenteExperiencia de,
                                                         String currentUser) {
        Boolean experienciaValida =
                XClassUtil.getBooleanByNombreAndIndiceOE(p, "datosValidosOtraExperienciaLaboral",
                        indiceExperiencia);
        Timestamp desde = XClassUtil.getFechaByNombreAndIndiceOE(p, "desde", indiceExperiencia);
        if (desde != null) {
            de.setDesde(desde);
        }
        Timestamp hasta = XClassUtil.getFechaByNombreAndIndiceOE(p, "hasta", indiceExperiencia);
        if (hasta != null) {
            de.setHasta(hasta);
        }
        Timestamp desdeCorregido = XClassUtil.getFechaByNombreAndIndiceOE(p,
                "fechaInicioCorregidaOtraExperienciaLaboral", indiceExperiencia);
        if (desdeCorregido != null) {
            de.setDesdeCorregido(desdeCorregido);
        }
        Timestamp hastaCorregido = XClassUtil.getFechaByNombreAndIndiceOE(p,
                "fechaFinCorregidaOtraExperienciaLaboral", indiceExperiencia);
        if (hastaCorregido != null) {
            de.setHastaCorregido(hastaCorregido);
        }
        if (experienciaValida != null) {
            de.setExperienciaValida(experienciaValida);
        } else {
            de.setExperienciaValida(Boolean.FALSE);
        }
        getLogger().info("desde_" + indiceExperiencia + "=" + de.getDesde() +
                " desde_corregido_" + indiceExperiencia + "=" + de.getDesdeCorregido() +
                ", desde_actualizado_" + indiceExperiencia + "=" + de.getDesdeActualizado());
        getLogger().info("hasta_" + indiceExperiencia + "=" + de.getHasta() +
                " hasta_corregido_" + indiceExperiencia + "=" + de.getHastaCorregido() +
                ", hasta_actualizado_" + indiceExperiencia + "=" + de.getHastaActualizado());
        if (de.getDesdeActualizado() != null && de.getHastaActualizado() != null) {
            de.setCantidadDeAnnios(calcularAnniosEntreFechasMSSQL(de.getDesdeActualizado(), de.getHastaActualizado()));
        } else {
            de.setCantidadDeAnnios(BigDecimal.valueOf(0.00));
        }
        de.setFechaActualizacion(new Timestamp(new Date().getTime()));
        de.setUsuarioActualizacion(currentUser);
        return de;
    }

    @Transactional
    public DocenteExperiencia updateExperiencias(NuevosDatosExpediente p, Integer indiceExperiencia, String currentUser) {
        DocenteExperiencia de =
                findByIdSigobsolUsuarioAndIndiceExperiencia(p.getCodigoDeSolicitante().longValue(),
                        Integer.valueOf(indiceExperiencia).shortValue());
        if (de != null) {
            de = updateOne(p, indiceExperiencia, de, currentUser);
        }
        return de;
    }

    @Transactional
    public DocenteExperiencia prepareOrUpdateOtrasExperiencias(NuevosDatosExpediente p, Integer indiceExperiencia,
                                                               String currentUser) {
        DocenteExperiencia de = findByIdSigobsolUsuarioAndIndiceExperiencia(p.getCodigoDeSolicitante().longValue(),
                Integer.valueOf(indiceExperiencia).shortValue());
        if (de != null) {
            de = updateOneOtrasExperiencias(p, indiceExperiencia, de, currentUser);
        } else {
            de = prepareNewOtrasExperiencias(p, indiceExperiencia, currentUser);
        }
        return de;
    }

    @Transactional
    public List<DocenteExperiencia> fromNuevosDatosExpediente_2_DocenteExperiencia(NuevosDatosExpediente p, String currentUser) {
        List<DocenteExperiencia> data = new ArrayList<>();
        DocenteExperiencia de1 = updateExperiencias(p, 1, currentUser);
        data.add(de1);
        DocenteExperiencia de2 = updateExperiencias(p, 2, currentUser);
        data.add(de2);
        DocenteExperiencia de3 = updateExperiencias(p, 3, currentUser);
        data.add(de3);
        DocenteExperiencia de4 = updateExperiencias(p, 4, currentUser);
        data.add(de4);
        DocenteExperiencia de5 = prepareOrUpdateOtrasExperiencias(p, 5, currentUser);
        data.add(de5);
        DocenteExperiencia de6 = prepareOrUpdateOtrasExperiencias(p, 6, currentUser);
        data.add(de6);
        DocenteExperiencia de7 = prepareOrUpdateOtrasExperiencias(p, 7, currentUser);
        data.add(de7);
        data.removeAll(Collections.singleton(null));
        return data;
    }

    @Transactional
    public void merge(DocenteExperiencia n) {
        if (find(n.getIdExperiencia()) == null) {
            this.create(n);
        } else {
            this.edit(n);
        }
    }

    @Transactional
    public void mergeList(List<DocenteExperiencia> lista) {
        lista.stream().forEach(de -> this.merge(de));
    }

    public BigDecimal calculateSumOfExperiencias(long idSigobsolUsuario) {
        return (BigDecimal) getEntityManager()
                .createNamedQuery("DocenteExperiencia.sumExperienciasValidas")
                .setParameter("idSigobsolUsuario", idSigobsolUsuario)
                .getSingleResult();
    }
}
