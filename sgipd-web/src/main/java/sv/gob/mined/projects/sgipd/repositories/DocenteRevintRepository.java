package sv.gob.mined.projects.sgipd.repositories;

import org.apache.commons.beanutils.BeanUtils;
import sv.gob.mined.projects.sgipd.entities.*;
import sv.gob.mined.projects.sgipd.entities.sigobsol.VexpedienteDocentesE2Cv;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DocenteRevintRepository extends GenericRepository<DocentesRevint> {
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteRevintRepository() {
        super(DocentesRevint.class);
    }

    public DocentesRevint findByIdSigobsolUsuarioIndiceTituloTipo( Long idSigobsolUsuario, Integer indiceTitulo,
                                                                   String tipo){
        List<DocentesRevint> l = getEntityManager()
                .createNamedQuery("DocentesRevint.findByIdSigobsolUsuarioIndiceTituloTipo")
                .setParameter("idSigobsolUsuario",idSigobsolUsuario)
                .setParameter("indiceTitulo",indiceTitulo)
                .setParameter("tipo",tipo)
                .getResultList();
        if(l.isEmpty()){
            return null;
        }else {
            return l.get(0);
        }
    }

    @Inject
    DocenteEstudioRepository docenteEstudioRepository;

    @Inject
    DocenteCapacitacionRepository docenteCapacitacionRepository;

    public List<Integer> getIdPlazasDBByIdSigobsolUsuarioFromEstudios(long idSigobsolUsuario) {
        List<DocenteEstudio> estudiosConPlazasHomologadas =
                docenteEstudioRepository.findByIdSigobsolUsuario(idSigobsolUsuario)
                        .stream().filter(
                                de -> (de.getPlazasHomologadas() != null && !de.getPlazasHomologadas().equals("")) &&
                                        (de.getValido() != null && de.getValido().booleanValue())
                        )
                        .collect(Collectors.toList());
        getLogger().info(estudiosConPlazasHomologadas);
        List<String> lista = new ArrayList<>();
        estudiosConPlazasHomologadas.stream().forEach(de ->
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

    @Transactional
    public DocentesRevint obtenerDocenteRevintObject(DocenteEstudio d, String usuario) {

        DocentesRevint rev = findByIdSigobsolUsuarioIndiceTituloTipo(
                d.getDocente().getIdSigobsolUsuario(),d.getIndiceTitulo(),"DocenteEstudio");
        getLogger().info("d="+d.getIdEstudios());
        if(rev==null && d.getPlazasHomologadas()!=null){
            rev = new DocentesRevint();

                rev.setIdSigobsolUsuario(d.getDocente().getIdSigobsolUsuario());
                rev.setIdTramiteCv(d.getDocente().getIdTramite());
                rev.setIndiceTitulo(d.getIndiceTitulo());
                rev.setTipo("DocenteEstudio");
            List<String> lista = new ArrayList<>();
            List<Integer> salida  = new ArrayList<>();
                try{

                    lista.addAll(Arrays.asList(
                            d.getPlazasHomologadas()
                                    .replaceAll("\\r|\\n", "")
                                    .replaceAll("\\.", ",")
                                    .replaceAll("\\s", "")
                                    //.replaceAll("[^0-9\\,]", "")
                                    .trim()
                                    .split(",")
                    ));
                    salida  = lista.stream().filter(c -> !c.equals(""))
                            .map(Integer::valueOf).collect(Collectors.toList());
                    getLogger().info(salida);
                }
                catch(Exception e){
                    getLogger().info("e="+e.getMessage());
                    rev.setPlazasHomologadas(d.getPlazasHomologadas());
                }

        }

        return rev;
    }

    @Transactional
    public DocentesRevint obtenerDocenteRevintCapaObject(DocenteCapacitacion d, String usuario) {

        DocentesRevint rev = findByIdSigobsolUsuarioIndiceTituloTipo(
                d.getIdSigobsolUsuario(),(int)d.getIndiceCapacitacion(),"DocenteCapacitacion");
        getLogger().info("d="+d.getIdCapacitacion());
        if(rev==null && d.getPlazasHomologadas()!=null){
            rev = new DocentesRevint();

            rev.setIdSigobsolUsuario(d.getIdSigobsolUsuario());
            rev.setIdTramiteCv(null);
            rev.setIndiceTitulo((int) d.getIndiceCapacitacion());
            rev.setTipo("DocenteCapacitacion");
            List<String> lista = new ArrayList<>();
            List<Integer> salida  = new ArrayList<>();
            try{

                lista.addAll(Arrays.asList(
                        d.getPlazasHomologadas()
                                .replaceAll("\\r|\\n", "")
                                .replaceAll("\\.", ",")
                                .replaceAll("\\s", "")
                                //.replaceAll("[^0-9\\,]", "")
                                .trim()
                                .split(",")
                ));
                salida  = lista.stream().filter(c -> !c.equals(""))
                        .map(Integer::valueOf).collect(Collectors.toList());
                getLogger().info(salida);
            }
            catch(Exception e){
                getLogger().info("e="+e.getMessage());
                rev.setPlazasHomologadas(d.getPlazasHomologadas());
            }

        }

        return rev;
    }

    @Transactional
    public List<DocentesRevint> fromDocente_2_DocenteRevint(Docente d, String currentUser){
        List<DocentesRevint> data = new ArrayList<>();
        List<DocenteEstudio> listaDE = docenteEstudioRepository.findByIdSigobsolUsuario(d.getIdSigobsolUsuario())
                .stream().filter(
                        de -> (de.getPlazasHomologadas() != null && !de.getPlazasHomologadas().equals(""))
                )
                .collect(Collectors.toList());
        listaDE.stream().forEach(c->data.add(obtenerDocenteRevintObject(c,currentUser)));
        data.removeAll(Collections.singleton(null));
        return data;
    }

    @Transactional
    public List<DocentesRevint> fromDocente_2_DocenteRevintCapa(Docente d, String currentUser){
        List<DocentesRevint> data = new ArrayList<>();
        List<DocenteCapacitacion> listaDE = docenteCapacitacionRepository.findByIdSigobsolUsuario(d.getIdSigobsolUsuario())
                .stream().filter(
                        de -> (de.getPlazasHomologadas() != null && !de.getPlazasHomologadas().equals(""))
                )
                .collect(Collectors.toList());
        listaDE.stream().forEach(c->data.add(obtenerDocenteRevintCapaObject(c,currentUser)));
        data.removeAll(Collections.singleton(null));
        return data;
    }

    @Transactional
    public void merge(DocentesRevint r) {
        getLogger().info(r.getPlazasHomologadas());
        if (findByIdSigobsolUsuarioIndiceTituloTipo(r.getIdSigobsolUsuario(),r.getIndiceTitulo(),r.getTipo())==null) {
            this.create(r);
        } else {
            this.edit(r);
        }
    }

    @Transactional
    public void mergeList(List<DocentesRevint> lista) {
        lista.stream().forEach(c -> this.merge(c));
    }
}
