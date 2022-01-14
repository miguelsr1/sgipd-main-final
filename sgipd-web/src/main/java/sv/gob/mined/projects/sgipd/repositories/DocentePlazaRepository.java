package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.utils.CalendarUtil;
import sv.gob.mined.projects.sgipd.utils.MathUtil;
import sv.gob.mined.projects.sgipd.utils.XClassUtil;

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
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class DocentePlazaRepository extends GenericRepository<DocentesPlaza>{
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

    public DocentePlazaRepository(){
        super(DocentesPlaza.class);
    }

    @Transactional
    public void merge(DocentesPlaza dp) {
        if (find(dp.getId())==null) {
            this.create(dp);
        } else {
            this.edit(dp);
        }
    }

    private String getBackupQuery(){
        return "SELECT dp.* INTO Docentes_plaza_"+
                CalendarUtil.formatSGIPD(new Date())
                +"  FROM Docentes_plaza dp ";
    }

    @Transactional
    public void makeBackup(){
        getEntityManager()
                .createNativeQuery(getBackupQuery()).executeUpdate();
    }

    @Transactional
    public int deleteAll(){
        return  getEntityManager()
                .createQuery("DELETE FROM DocentesPlaza dp")
                .executeUpdate();
    }

    @Transactional
    public void mergeList(List<DocentesPlaza> lista) {
        lista.stream().forEach(dp -> this.merge(dp));
    }



    public BigDecimal getNota4Avg(DocenteResumen dr){
        BigDecimal total = dr.getNota3a().add(dr.getNota3b());
        return MathUtil.roundBigDecimal(total.divide(BigDecimal.valueOf(2.00)));
    }

    public BigDecimal getNota3Avg(DocenteResumen dr){
        BigDecimal total = dr.getNota3a().multiply(BigDecimal.valueOf(0.66))
                .add(dr.getNota3b().multiply(BigDecimal.valueOf(0.33)))                ;
        return MathUtil.roundBigDecimal(total);
    }

    @Transactional
    public DocentesPlaza fromDocenteResumen2DocentesPlaza(DocenteResumen dr,String currentUser){
        DocentesPlaza dp = new DocentesPlaza();
        Docente d = docenteRepository.find(dr.getIdSigobsolUsuario().longValue());
        dp.setId(dr.getIdTramiteAplic());
        dp.setIdSecuencialPlaza(dr.getIdSecuencialPlaza());
        dp.setIdSigobsolUsuario(dr.getIdSigobsolUsuario());
        dp.setNip(dr.getNip());
        dp.setDui(d.getDui());
        dp.setNombreCompleto(dr.getNombreCompleto());
        dp.setNota1(dr.getNota1());
        dp.setPonderacion1(dr.getPonderacion1());
        dp.setNota2(dr.getNota2());
        dp.setPonderacion2(dr.getPonderacion2());
        dp.setNota5(dr.getNota5());
        dp.setPonderacion5(dr.getPonderacion5());
        dp.setNotaFinal(dr.getNotaFinal());
        dp.setAprobacion(dr.getAprobacion());
        dp.setObservacion("Generado por el usuario: "+currentUser+" on "+new Date());
        dp.setPosicion(dr.getPosicion());
        dp.setFechaIngreso(new Timestamp(new Date().getTime()));
        dp.setUsuarioIngreso(currentUser);
        dp.setFechaActualizacion(new Timestamp(new Date().getTime()));
        dp.setUsuarioActualizacion(currentUser);
        dp.setNota3(getNota3Avg(dr));
        dp.setPonderacion3(MathUtil.roundBigDecimal(dr.getPonderacion3a().add(dr.getPonderacion3b())));
        dp.setNota4(getNota4Avg(dr));
        dp.setPonderacion4(MathUtil.roundBigDecimal(dr.getPonderacion4a().add(dr.getPonderacion4b())));
        return dp;
    }


    @Transactional
    public List<DocentesPlaza> fromPlaza_2_DocentePlazaList(Plaza plaza, String currentUser){
        List<DocenteResumen> top10 = docenteResumenRepository.findByPlazaTop10(plaza.getIdSecuencial());
        List<DocentesPlaza> data = new ArrayList<>();
        top10.stream().forEach(t->data.add(fromDocenteResumen2DocentesPlaza(t,currentUser)));
        return data;
    }
}
