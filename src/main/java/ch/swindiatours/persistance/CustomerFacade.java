package ch.swindiatours.persistance;

import ch.swindiatours.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class CustomerFacade extends Facade<Customer> implements Serializable {
    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;

    protected CustomerFacade(Class<CustomerFacade> entityClass) {

        super(Customer.class);
    }

    public HashMap<String, Customer> getAllUsersMap() {
        HashMap<String, Customer> users = new HashMap<>();
        for (Customer user : getAll()) {
            users.put(user.getUsername(), user);
        }
        return users;
    }

    public List<Customer> getAllCustomers() {
        return em.createNamedQuery("customer.getAll", Customer.class).getResultList();
    }

    public Customer getUserByID(int userId) {
        return em.createNamedQuery("customer.getById", Customer.class).setParameter("id", userId).getSingleResult();
    }

    public Customer getUserByUsername(String username) {
        return em.createNamedQuery("customer.getByUsername", Customer.class).setParameter("username", username).getSingleResult();
    }

    public void create(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.flush();
        em.refresh(customer);
        em.getTransaction().commit();
    }

    public void edit(Customer customer) {
        em.getTransaction().begin();
        em.refresh(customer);
        em.flush();
        em.refresh(customer);
        em.getTransaction().commit();
    }

    public void remove(Customer customer) {
        em.getTransaction().begin();
        em.remove(customer);
        em.flush();
        em.getTransaction().commit();
    }
}
