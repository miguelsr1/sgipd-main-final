package sv.gob.mined.projects.sgipd.repositories;

import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class GenericRepositorySigobsol<T> {
    public static final String PU="sigobsol-PU";
    private static Logger logger = Logger.getLogger(GenericRepositorySigobsol.class);

    private Class<T> entityClass;

    public GenericRepositorySigobsol(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public static Logger getLogger() {
        return logger;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public T executeNamedQuerySingleResult(String namedQuery, Map<String, Object> params) {
        T entity = null;
        try {
            Query query = getEntityManager().createNamedQuery(namedQuery);
            for (String key : params.keySet()) {
                query = query.setParameter(key, params.get(key));
            }
            List<T> entities = entities = query.getResultList();
            if (!entities.isEmpty()) {
                entity = entities.get(0);
            }
        } catch (Exception e) {
            getLogger().error("Error executing Query: "
                            + namedQuery + " with Params: " + params,
                    e);
        }
        return entity;
    }

    public List<T> executeNamedQueryResultList(String namedQuery, Map<String, Object> params) {
        List<T> entities = new ArrayList<>();
        try {
            Query query = getEntityManager().createNamedQuery(namedQuery);
            for (String key : params.keySet()) {
                query = query.setParameter(key, params.get(key));
            }
            entities = entities = query.getResultList();
        } catch (Exception e) {
            getLogger().error("Error executing Query: "
                            + namedQuery + " with Params: " + params,
                    e);
        }
        return entities;
    }
}