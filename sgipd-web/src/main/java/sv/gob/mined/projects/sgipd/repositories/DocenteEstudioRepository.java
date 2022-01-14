package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.Calificacion;
import sv.gob.mined.projects.sgipd.entities.DocenteEstudio;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.utils.XClassUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@ApplicationScoped
public class DocenteEstudioRepository extends GenericRepository<DocenteEstudio> {

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Inject
    DocenteRepository docenteRepository;

    @Inject
    EspecialidadRepository especialidadRepository;

    @Inject
    GradoAcademicoRepository gradoAcademicoRepository;

    @Inject
    InstitucionEducativaRepository institucionEducativaRepository;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteEstudioRepository() {
        super(DocenteEstudio.class);
    }

    public List<DocenteEstudio> findByIdSigobsolUsuario(long idSigobsolUsuario) {
        List<DocenteEstudio> estudios = getEntityManager()
                .createNamedQuery("DocenteEstudio.findByIdSigobsolUsuario")
                .setParameter("idSigobsolUsuario", idSigobsolUsuario)
                .getResultList();
       return estudios;
    }

    public DocenteEstudio findByIdSigobsolUsuarioAndIndiceTitulo(long idSigobsolUsuario, int indiceTitulo) {
        List<DocenteEstudio> estudios = getEntityManager()
                .createNamedQuery("DocenteEstudio.findByIdSigobsolUsuarioAndIndiceTitulo")
                .setParameter("idSigobsolUsuario", idSigobsolUsuario)
                .setParameter("indiceTitulo", indiceTitulo)
                .getResultList();
        if (estudios.isEmpty()) {
            return null;
        } else {
            return estudios.get(0);
        }
    }

    public Long annioGraduacionConvert(String annioGraduacion) {
        Long annioVal = null;
        if (annioGraduacion != null) {
            try {
                annioVal = Long.valueOf(annioGraduacion);
            } catch (Exception e) {
            }
        }
        return annioVal;
    }

    @Transactional
    public DocenteEstudio obtenerEstudio(NuevosDatosExpediente p, String currentUser, int indiceTitulo) {
        DocenteEstudio de = findByIdSigobsolUsuarioAndIndiceTitulo(p.getCodigoDeSolicitante().longValue(), indiceTitulo);
        if (de == null) {
            de = new DocenteEstudio();
            String annioGraduacion = XClassUtil.getStringByNombreAndIndice(p,
                    "annioDeGraduacion", indiceTitulo);
            Long annioVal = annioGraduacionConvert(annioGraduacion);
            de.setAnnioGraduacion(annioVal);
            de.setIndiceTitulo(indiceTitulo);
            de.setDocente(docenteRepository.find(p.getCodigoDeSolicitante().longValue()));
            String especialidad = XClassUtil.getStringByNombreAndIndice(p,
                    "especialidad", indiceTitulo);
            de.setEspecialidad(especialidad != null ?
                    especialidadRepository.findByNombre(especialidad) : null);
            String gradoAcademico = XClassUtil.getStringByNombreAndIndice(p,
                    "gradoAcademico", indiceTitulo);
            de.setGradoAcademico(gradoAcademico != null ?
                    gradoAcademicoRepository.findByNombre(gradoAcademico) : null);
            String institucionEducativa = XClassUtil.getStringByNombreAndIndice(p,
                    "institucionEducativa", indiceTitulo);
            de.setInstitucionesEducativa(institucionEducativa != null ?
                    institucionEducativaRepository.findByNombre(institucionEducativa) : null);
            Boolean valido = XClassUtil.getBooleanByNombreAndIndice(p,
                    "datosValidosEstudiosRealizados", indiceTitulo);
            if (valido != null) {
                de.setValido(valido);
            }
            String plazasHomologadas = XClassUtil.getStringByNombreAndIndice(p,
                    "plazasHomologadasEstudiosRealizados", indiceTitulo);
            de.setPlazasHomologadas(plazasHomologadas != null ? plazasHomologadas : "");
            if(plazasHomologadas!=null && !plazasHomologadas.equals("") && valido==null){
                de.setValido(Boolean.TRUE);
            }
            if(plazasHomologadas==null && valido==null){
                de.setValido(Boolean.FALSE);
            }
            de.setFechaActualizacion(new Timestamp(new Date().getTime()));
            de.setUsuarioActualizacion(currentUser);
            String especialidadCorregida = XClassUtil.getStringByNombreAndIndice(p,
                    "especialidadCorregida", indiceTitulo);
            de.setEspecialidadCorregida(especialidadCorregida != null ? especialidadCorregida : "");

        } else {
            Boolean valido = XClassUtil.getBooleanByNombreAndIndice(p,
                    "datosValidosEstudiosRealizados", indiceTitulo);
            if (valido != null) {
                de.setValido(valido);
            }
            String plazasHomologadas = XClassUtil.getStringByNombreAndIndice(p,
                    "plazasHomologadasEstudiosRealizados", indiceTitulo);
            de.setPlazasHomologadas(plazasHomologadas != null ? plazasHomologadas : "");
            if(plazasHomologadas!=null && !plazasHomologadas.equals("") && valido==null){
                de.setValido(Boolean.TRUE);
            }
            if(plazasHomologadas==null && valido==null){
                de.setValido(Boolean.FALSE);
            }
            de.setFechaActualizacion(new Timestamp(new Date().getTime()));
            de.setUsuarioActualizacion(currentUser);
            String especialidadCorregida = XClassUtil.getStringByNombreAndIndice(p,
                    "especialidadCorregida", indiceTitulo);
            de.setEspecialidadCorregida(especialidadCorregida != null ? especialidadCorregida : "");
        }
        return de;
    }

    public List<DocenteEstudio> fromNuevosDatosExpediente_2_DocenteEstudio(NuevosDatosExpediente p, String currentUser) {
        List<DocenteEstudio> data = new ArrayList<>();
        List<Integer> list = List.of(1, 2, 3, 4);
        list.stream().forEach(indiceTitulo -> data.add(obtenerEstudio(p, currentUser, indiceTitulo)));
        data.removeAll(Collections.singleton(null));
        return data;
    }

    @Transactional
    public void merge(DocenteEstudio de) {
        if (findByIdSigobsolUsuarioAndIndiceTitulo(de.getDocente().getIdSigobsolUsuario(),de.getIndiceTitulo())==null) {
            this.create(de);
        } else {
            this.edit(de);
        }
    }

    @Transactional
    public void mergeList(List<DocenteEstudio> lista) {
        lista.stream().forEach(de -> this.merge(de));
    }

}
