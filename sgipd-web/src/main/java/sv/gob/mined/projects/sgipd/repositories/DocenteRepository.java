package sv.gob.mined.projects.sgipd.repositories;

import org.keycloak.representations.AccessToken;
import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class DocenteRepository extends GenericRepository<Docente> {
    @Inject
    MunicipioRepository municipioRepository;

    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteRepository() {
        super(Docente.class);
    }


    public Docente prepareNew(NuevosDatosExpediente p,String currentUser) {
        Docente d = new Docente();
        d.setIdSigobsolUsuario(p.getCodigoDeSolicitante().longValue());
        d.setApellidos(p.getApellidos() != null ? p.getApellidos() : "");
        d.setCorreoE(p.getCorreo() != null ? p.getCorreo() : "");
        d.setDepartamento(p.getDepartamento() != null ? p.getDepartamento() : "");
        d.setDireccionPostal(p.getDireccionActualDeResidencia() != null ? p.getDireccionActualDeResidencia() : "");
        d.setDiscapacidad(p.getDiscapacidad() != null ? p.getDiscapacidad() : "");
        d.setDui(p.getDui() != null ? p.getDui() : "");
        d.setIdTramite(p.getCodigoDeTramite().longValue());
        d.setMunicipio(p.getMunicipio() != null ? p.getMunicipio() : "");
        d.setNip(p.getNip() != null ? p.getNip() : "");
        d.setNivelDocente(p.getNivelDocente() != null ? p.getNivelDocente() : "");
        d.setNombres(p.getNombres() != null ? p.getNombres() : "");
        d.setTelCelular(p.getTelefonoCelular() != null ? p.getTelefonoCelular() : "");
        d.setTelFijo(p.getTelefonoFijo() != null ? p.getTelefonoFijo() : "");
        if (p.getMunicipio() != null && p.getDepartamento() != null) {
            d.setMunicipioBean(municipioRepository.findByNombreMuniAndNobreDepto(p.getMunicipio(), p.getDepartamento()));
        } else {
            d.setMunicipioBean(new Municipio(Municipio.NO_DEFINIDO));
        }
        d.setTipoTramiteBean(new TipoTramite(p.getCodigoDeTipoDeTramite().longValue()));
        d.setRechazado(Docente.NO_RECHAZADO);
        d.setNipVerificado(p.getNipVerificado() != null ? p.getNipVerificado() : "");
        d.setDuiVerificado(p.getDuiVerificado() != null ? p.getDuiVerificado() : "");
        d.setInterino(p.getInterino());
        d.setValidacionDeInterino(p.getValidacionDeInterino());
        if (p.getFaseActualSigob() != null) {
            d.setFaseActualSIGOB(p.getFaseActualSigob());
        }
        d.setFechaActualizacion(new Timestamp(new Date().getTime()));
        d.setUsuarioActualizacion(currentUser);
        return d;
    }

    public Docente updateOne(NuevosDatosExpediente p, Docente d,String currentUser) {
        d.setNipVerificado(p.getNipVerificado() != null ? p.getNipVerificado() : "");
        d.setDuiVerificado(p.getDuiVerificado() != null ? p.getDuiVerificado() : "");
        d.setInterino(p.getInterino());
        d.setValidacionDeInterino(p.getValidacionDeInterino());
        if (p.getFaseActualSigob() != null) {
            d.setFaseActualSIGOB(p.getFaseActualSigob());
        }
        d.setFechaActualizacion(new Timestamp(new Date().getTime()));
        d.setUsuarioActualizacion(currentUser);

        return d;
    }


    @Transactional
    public Docente fromNuevosDatosExpediente_2_Docente(NuevosDatosExpediente p, String currentUser) {
        Docente d = find(p.getCodigoDeSolicitante().longValue());
        if (d != null) {
            d = updateOne(p,d,currentUser);
        } else {
            d = prepareNew(p,currentUser);
        }
        return d;
    }

    @Transactional
    public void merge(Docente n) {
        if (find(n.getIdSigobsolUsuario()) == null) {
            this.create(n);
        } else {
            this.edit(n);
        }
    }

    public List<Docente> findAllNoRechazados(){
        return getEntityManager().createNamedQuery("Docente.findAllNoRechazados")
                .getResultList();
    }

    public Docente fromVexpedienteDocentesE2Cv_2_Docente(VexpedienteDocentesE2Cv d,String currentUser){
        Docente docente = find(d.getCodigoDeSolicitante().longValue());
        if(docente!=null){
            docente.setElegible(Boolean.TRUE);
            docente.setObservacionElegible("ELEGIBLE");
        }
        return docente;
    }

    public Docente fromDocente_2_Docente(Docente d,String currentUser){
        Docente docente = find(d.getIdSigobsolUsuario());
        if(docente!=null){
            docente.setElegible(Boolean.FALSE);
            docente.setObservacionElegible("NO ELEGIBLE");
        }
        return docente;
    }

    public List<Docente> findNoElegibles(){
        return getEntityManager()
                .createNamedQuery("Docente.findNoElegibles")
                .getResultList();
    }

}
