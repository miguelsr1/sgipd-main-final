package sv.gob.mined.projects.sgipd.repositories;

import org.apache.commons.beanutils.BeanUtils;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class NuevosDatosExpedienteRepository extends GenericRepository<NuevosDatosExpediente> {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NuevosDatosExpedienteRepository() {
        super(NuevosDatosExpediente.class);
    }

    public NuevosDatosExpediente convertView2Entity(VexpedienteDocentesE2Cv p){
        NuevosDatosExpediente n = new NuevosDatosExpediente();
        try{
            BeanUtils.copyProperties(n,p);
        }catch (Exception e){
            getLogger().error("Error converting VexpedienteDocentesE2Cv to NuevosDatosExpediente");
        }
        return n;
    }

    @Transactional
    public NuevosDatosExpediente fromVexpedienteDocentesE2Cv_2_NuevosDatosExpediente(VexpedienteDocentesE2Cv p) {
        return convertView2Entity(p);
    }

    @Transactional
    public void merge(NuevosDatosExpediente n){
        if(find(n.getCodigoDeTramite())==null){
            this.create(n);
        }else{
            this.edit(n);
        }
    }
}
