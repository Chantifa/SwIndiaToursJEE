package ch.swindiatours.persistance;


import ch.swindiatours.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

public class LoginFacade extends Facade<Customer> implements Serializable {
    @PersistenceContext
    private EntityManager em;

    public LoginFacade() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Customer> findByCustomer(String username) {

        Query query = em.createNamedQuery("Customer.findByUserName");
        query.setParameter("username", username);

        return query.getResultList();
    }
}
