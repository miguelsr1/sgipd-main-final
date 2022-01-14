package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.DocenteCapacitacion;
import sv.gob.mined.projects.sgipd.entities.DocenteEstudio;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.utils.XClassUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class DocenteCapacitacionRepository extends GenericRepository<DocenteCapacitacion> {

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteCapacitacionRepository() {
        super(DocenteCapacitacion.class);
    }

    public List<DocenteCapacitacion> findByIdSigobsolUsuario(long idSigobsolUsuario) {
        List<DocenteCapacitacion> lista = getEntityManager()
                .createNamedQuery("DocenteCapacitacion.findByIdSigobsolUsuario")
                .setParameter("idSigobsolUsuario", idSigobsolUsuario)
                .getResultList();
       return lista;
    }

    public DocenteCapacitacion findByIdSigobsolUsuarioAndIndiceCapacitacion(long idSigobsolUsuario, short indiceCapacitacion) {
        List<DocenteCapacitacion> lista = getEntityManager()
                .createNamedQuery("DocenteCapacitacion.findByIdSigobsolUsuarioAndIndiceCapacitacion")
                .setParameter("idSigobsolUsuario", idSigobsolUsuario)
                .setParameter("indiceCapacitacion", indiceCapacitacion)
                .getResultList();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }

    }

    @Transactional
    public DocenteCapacitacion obtenerCapacitacion(NuevosDatosExpediente p, String currentUser, int indiceTitulo) {
        DocenteCapacitacion dc = findByIdSigobsolUsuarioAndIndiceCapacitacion(p.getCodigoDeSolicitante().longValue(),
                (short) indiceTitulo);
        if (dc == null) {
            dc = new DocenteCapacitacion();
            Integer cantidadHoras = XClassUtil.getIntegerByNombreAndIndice(p,
                    "cantidadHoras", indiceTitulo);
            if (cantidadHoras != null) {
                dc.setCantidadHoras(cantidadHoras.longValue());
            }
            String diplomaObtenido = XClassUtil.getStringByNombreAndIndice(p,
                    "diplomaObtenido", indiceTitulo);
            dc.setDiplomaObtenido(diplomaObtenido != null ? diplomaObtenido : "");
            Timestamp fechaFinalizacion = XClassUtil.getFechaByNombreAndIndice(p,
                    "fechaFinalizacion", indiceTitulo);
            if (fechaFinalizacion != null) {
                dc.setFechaFinalizacion(fechaFinalizacion);
            }
            Timestamp fechaInicio = XClassUtil.getFechaByNombreAndIndice(p,
                    "fechaInicio", indiceTitulo);
            if (fechaInicio != null) {
                dc.setFechaInicio(fechaInicio);
            }
            dc.setIdSigobsolUsuario(p.getCodigoDeSolicitante().longValue());
            dc.setIndiceCapacitacion((short) indiceTitulo);
            String institucion = XClassUtil.getStringByNombreAndIndice(p,
                    "institucion", indiceTitulo);
            dc.setInstitucion(institucion != null ? institucion : null);
            String nombreCapacitacion = XClassUtil.getStringByNombreAndIndice(p,
                    "nombreCapacitacion", indiceTitulo);
            dc.setNombreCapacitacion(nombreCapacitacion != null ? nombreCapacitacion : null);
            String pais = XClassUtil.getStringByNombreAndIndice(p,
                    "pais", indiceTitulo);
            dc.setPais(pais != null ? pais : null);
            String plazasHomologadas = XClassUtil.getStringByNombreAndIndice(p,
                    "plazasHomologadasCapacitaciones", indiceTitulo);
            getLogger().info("Insert Plazas homologadas capacitaciones: "+plazasHomologadas);
            dc.setPlazasHomologadas(plazasHomologadas != null ? plazasHomologadas : null);
            if(plazasHomologadas!=null){
                dc.setValido(Boolean.TRUE);
            }else{
                dc.setValido(Boolean.FALSE);
            }
            dc.setFechaActualizacion(new Timestamp(new Date().getTime()));
            dc.setUsuarioActualizacion(currentUser);

        } else {
            String plazasHomologadas = XClassUtil.getStringByNombreAndIndice(p,
                    "plazasHomologadasCapacitaciones", indiceTitulo);
            getLogger().info("Update Plazas homologadas capacitaciones: "+plazasHomologadas);
            dc.setPlazasHomologadas(plazasHomologadas != null ? plazasHomologadas : null);
            if(plazasHomologadas!=null){
                dc.setValido(Boolean.TRUE);
            }else{
                dc.setValido(Boolean.FALSE);
            }
            dc.setFechaActualizacion(new Timestamp(new Date().getTime()));
            dc.setUsuarioActualizacion(currentUser);
        }
        return dc;
    }

    @Transactional
    public List<DocenteCapacitacion> fromNuevosDatosExpediente_2_DocenteCapacitacion(NuevosDatosExpediente p, String currentUser) {
        List<DocenteCapacitacion> data = new ArrayList<>();
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        list.stream().forEach(indiceTitulo -> data.add(obtenerCapacitacion(p, currentUser, indiceTitulo)));
        //data.removeAll(Collections.singleton(null));
        for (int i = 1; i <=5 ; i++) {
            data.add(obtenerCapacitacion(p,currentUser,i));
            getLogger().info("Indice: "+data.get(i-1).getIndiceCapacitacion());
        }
        return data;
    }

    @Transactional
    public void merge(DocenteCapacitacion dc) {
        if (findByIdSigobsolUsuarioAndIndiceCapacitacion(dc.getIdSigobsolUsuario(),dc.getIndiceCapacitacion())==null) {
            this.create(dc);
        } else {
            this.edit(dc);
        }
    }

    @Transactional
    public void mergeList(List<DocenteCapacitacion> lista) {
        lista.stream().forEach(dc -> this.merge(dc));
    }

}
