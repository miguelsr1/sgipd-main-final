package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.utils.CalendarUtil;
import sv.gob.mined.projects.sgipd.utils.MathUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class PlazasAprobadaRepository extends GenericRepository<PlazasAprobada>{
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }
    @Inject
    private DocenteAplicacionRepository docenteAplicacionRepository;
    @Inject
    private CalificacionRepository calificacionRepository;
    @Inject
    private DocenteResumenRepository docenteResumenRepository;
    @Inject
    private DocenteRepository docenteRepository;

    public PlazasAprobadaRepository(){
        super(PlazasAprobada.class);
    }

    @Transactional
    public void merge(PlazasAprobada pa) {
        if (find(pa.getId())==null) {
            this.create(pa);
        } else {
            this.edit(pa);
        }
    }

    private String getBackupQuery(){
        return "SELECT dp.* INTO Plazas_Aprobadas_"+
                CalendarUtil.formatSGIPD(new Date())
                +"  FROM Plazas_Aprobadas dp ";
    }

    @Transactional
    public void makeBackup(){
        getEntityManager()
                .createNativeQuery(getBackupQuery()).executeUpdate();
    }

    @Transactional
    public int deleteAll(){
        return  getEntityManager()
                .createQuery("DELETE FROM PlazasAprobada dp")
                .executeUpdate();
    }

    @Transactional
    public void mergeList(List<PlazasAprobada> lista) {
        lista.stream().forEach(pa -> this.merge(pa));
    }

    @Transactional
    public PlazasAprobada fromDocentesPlaza_2_PlazasAprobada(DocentesPlaza dp, String currentUser){
        PlazasAprobada pa = new PlazasAprobada();
        Docente d = docenteRepository.find(dp.getIdSigobsolUsuario().longValue());
        pa.setId(dp.getId());
        pa.setIdDePlaza(dp.getIdSecuencialPlaza());
        pa.setCodigoDeSolicitante(dp.getIdSigobsolUsuario());
        pa.setNip(dp.getNip());
        pa.setNipCorregido(d.getNipVerificado()!=null?d.getNipVerificado():"");
        pa.setDuiCorregido(d.getDuiVerificado()!=null?d.getDuiVerificado():dp.getDui());
        pa.setNombreCompletoSegunRegistroPlataforma(dp.getNombreCompleto());
        pa.setResultadopruebapsicomAsp(dp.getNota1());
        pa.setPuntajeppsicomAsp(dp.getPonderacion1());
        pa.setResultadopctAsp(dp.getNota2());
        pa.setPuntajepctAsp(dp.getPonderacion2());
        pa.setNotaexpcomprdocAsp(dp.getNota3());
        pa.setPuntajeexpcompdocAsp(dp.getPonderacion3());
        pa.setNotatitespecdocAsp(dp.getNota4());
        pa.setPuntajetitespdocAsp(dp.getPonderacion4());
        pa.setNotalugresidpersAsp(dp.getNota5());
        pa.setPuntajelugresidpersAsp(dp.getPonderacion5());
        pa.setNotatotalAsp(dp.getNotaFinal());
        pa.setNumeroposicionenplazaAsp(dp.getPosicion());
        return pa;
    }
}
