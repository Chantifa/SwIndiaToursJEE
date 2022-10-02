package ch.swindiatours.persistance;

import ch.swindiatours.model.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CustomerFacade extends Facade<Customer> {

    @PersistenceContext(unitName = "ch.swindiatours")
    private EntityManager em;

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List findAllCities() {

        return em.createNamedQuery("Customer.findAllCities").getResultList();
    }
}
