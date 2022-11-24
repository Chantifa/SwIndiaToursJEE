package ch.swindiatours.persistance;

import ch.swindiatours.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;

import java.io.Serializable;
import java.util.List;

public class Facade<T> implements Serializable {
        private Class<T> entityClass;
        private EntityManager em;
        public Facade(Class<T> customerClass) {
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public void create(T entity) {
            getEntityManager().persist(entity);
        }

        public void edit(T entity) {
            getEntityManager().merge(entity);
        }

        public void remove(T entity) {
            getEntityManager().remove(getEntityManager().merge(entity));
        }

        public T find(Class<Customer> customerClass, Object id) {
            return getEntityManager().find(entityClass, id);
        }

        public List<T> getAll() {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return getEntityManager().createQuery(cq).getResultList();
        }

        public List<T> findRange(int[] range) {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0]);
            q.setFirstResult(range[0]);
            return q.getResultList();
        }
}
