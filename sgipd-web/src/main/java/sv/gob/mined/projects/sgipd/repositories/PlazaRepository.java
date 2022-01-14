package sv.gob.mined.projects.sgipd.repositories;

import sv.gob.mined.projects.sgipd.entities.*;
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

@ApplicationScoped
public class PlazaRepository extends GenericRepository<Plaza>{
    @PersistenceContext(unitName = GenericRepository.PU)
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlazaRepository(){
        super(Plaza.class);
    }


}
