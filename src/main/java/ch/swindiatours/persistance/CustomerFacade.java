package ch.swindiatours.persistance;

import ch.swindiatours.model.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

@Stateless
public class CustomerFacade extends Facade<Customer> implements Serializable {
    @PersistenceContext
    private EntityManager em;

    public CustomerFacade(Class<CustomerFacade> entityClass) {

        super(Customer.class);
    }

    public HashMap<String, Customer> getAllUsersMap(){
        HashMap<String, Customer> users = new HashMap<>();
        for(Customer user : getAll()){
            users.put(user.getUsername(), user);
        }
        return users;
    }

    public Collection<Customer> getAllCustomers(){
        return em.createNamedQuery("customer.getAll", Customer.class).getResultList();
    }

    public Customer getUserByID(int id){
        return em.createNamedQuery("customer.getById", Customer.class).setParameter("id", id).getSingleResult();
    }

    public Customer getUserByUsername(String username){
        return em.createNamedQuery("customer.getByUsername", Customer.class).setParameter("username", username).getSingleResult();
    }

    public void create(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.flush();
        em.refresh(customer);
        em.getTransaction().commit();
    }
}
