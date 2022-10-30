package ch.swindiatours.persistance;

import ch.swindiatours.model.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public HashMap<String, Customer> getAllUsersMap(){
        HashMap<String, Customer> users = new HashMap<>();
        for(Customer user : getAll()){
            users.put(user.getUsername(), user);
        }
        return users;
    }

    public Collection<Customer> getAllCustomers(){
        return entityManager.createNamedQuery("customer.getAll", Customer.class).getResultList();
    }

    public Customer getUserByID(int id){
        return entityManager.createNamedQuery("customer.getById", Customer.class).setParameter("id", id).getSingleResult();
    }

    public Customer getUserByUsername(String username){
        return entityManager.createNamedQuery("customer.getByUsername", Customer.class).setParameter("username", username).getSingleResult();
    }

    public void create(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.flush();
        entityManager.refresh(customer);
        entityManager.getTransaction().commit();
    }
}
