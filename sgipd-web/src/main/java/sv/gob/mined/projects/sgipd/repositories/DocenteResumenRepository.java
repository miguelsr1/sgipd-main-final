package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.utils.MathUtil;
import sv.gob.mined.projects.sgipd.utils.XClassUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Column;
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
public class DocenteResumenRepository extends GenericRepository<DocenteResumen>{
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }
    @Inject
    private DocenteAplicacionRepository docenteAplicacionRepository;
    @Inject
    private CalificacionRepository calificacionRepository;

    public DocenteResumenRepository(){
        super(DocenteResumen.class);
    }

    public DocenteResumen findByIdTramiteAplic(Long idTramiteAplic){
        List<DocenteResumen> lista = getEntityManager()
                .createNamedQuery("DocenteResumen.findByIdTramiteAplic")
                .setParameter("idTramiteAplic",idTramiteAplic)
                .getResultList();
        if(lista.isEmpty()){
            return null;
        }else{
            return lista.get(0);
        }
    }

    @Transactional
    public int updatePosicion(){
        return  getEntityManager()
                .createQuery("UPDATE DocenteResumen dr SET dr.posicion=NULL")
                .executeUpdate();
    }

    @Transactional
    public DocenteResumen fromDocente2DocenteResumen(DocenteAplicacion da,String currentUser){
        List<Calificacion> notas = calificacionRepository.getAllCalificacionesByIdTramiteAplic(da.getIdTramiteAplic());
        Docente d = da.getDocente();
        DocenteResumen r = this.findByIdTramiteAplic(da.getIdTramiteAplic());
        if(r==null){
            r=new DocenteResumen(da.getIdTramiteAplic(),
                    d.getIdSigobsolUsuario(),
                    d.getNip());
            r.setNombreCompleto(d.getNombreCompleto());
            r.setFechaIngreso(new Timestamp(new Date().getTime()));
            r.setUsuarioIngreso(currentUser);
            r.setObservacion("Generado en: "+new Date()+" by: "+currentUser);
            r.setIdSecuencialPlaza(da.getPlaza().getIdSecuencial());
        }
        double total = 0.00;
        for (Calificacion nota:notas) {
            String indiceCriterio = nota.getCriterio().getIndiceCriterio();
            BigDecimal valor = nota.getValorCalif();
            BigDecimal ponderacion = nota.getValorPonderacion();
            XClassUtil.setBigDecimalByNombreAndIndiceCriterio(r,"nota",indiceCriterio,valor);
            XClassUtil.setBigDecimalByNombreAndIndiceCriterio(r,"ponderacion",indiceCriterio,ponderacion);
            total = total + (ponderacion!=null? ponderacion.doubleValue(): 0.00);
        }
        r.setNotaFinal( MathUtil.roundBigDecimal(BigDecimal.valueOf(total)));
        if(r.getNotaFinal().doubleValue()>=6.00){
            r.setAprobacion(Boolean.TRUE);
        }else{
            r.setAprobacion(Boolean.FALSE);
        }
        r.setFechaActualizacion(new Timestamp(new Date().getTime()));
        r.setUsuarioActualizacion(currentUser);
        return r;
    }

    public List<DocenteResumen> fromDocente_2_DocenteResumenList(Docente d,String currentUser){
        List<DocenteResumen> resumenList = new ArrayList<>();
        List<DocenteAplicacion> aplicaciones = docenteAplicacionRepository
                .findByIdSigobsolUsuarioNoRechazadas(d.getIdSigobsolUsuario());
        aplicaciones.stream().forEach(da->resumenList.add(fromDocente2DocenteResumen(da,currentUser)));
        return resumenList;
    }

    @Transactional
    public void merge(DocenteResumen dr) {
        if (find(dr.getIdTramiteAplic())==null) {
            this.create(dr);
        } else {
            this.edit(dr);
        }
    }

    @Transactional
    public void mergeList(List<DocenteResumen> lista) {
        lista.stream().forEach(dr -> this.merge(dr));
    }


    public List<DocenteResumen> findByPlaza(long idSecuencial){
        return getEntityManager()
                .createNamedQuery("DocenteResumen.findByPlaza")
                .setParameter("idSecuencial",idSecuencial)
                .getResultList();
    }

    public List<DocenteResumen> findByPlazaTop10(long idSecuencial){
        return getEntityManager()
                .createNamedQuery("DocenteResumen.findByPlazaTop10")
                .setParameter("idSecuencial",idSecuencial)
                .getResultList();
    }

    public List<DocenteResumen> findByPlazaNonTop10(long idSecuencial){
        return getEntityManager()
                .createNamedQuery("DocenteResumen.findByPlazaNonTop10")
                .setParameter("idSecuencial",idSecuencial)
                .getResultList();
    }


    @Transactional
    public List<DocenteResumen> fromPlaza_2_DocenteResumenList(Plaza plaza, String currentUser){
        List<DocenteResumen> data = findByPlaza(plaza.getIdSecuencial());
        AtomicLong posicion = new AtomicLong(0);
        data.stream().forEach(dr->{
            dr.setPosicion(posicion.incrementAndGet());
            dr.setFechaActualizacion(new Timestamp(new Date().getTime()));
            dr.setUsuarioActualizacion(currentUser);
        });
        return data;
    }
}
