package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import  ch.swindiatours.persistance.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 *
 * Use stateless name because of ICustomerService
 */
@Stateless(name = "CustomerService")
@Local
@ApplicationScoped
@Transactional
public class CustomerService implements ICustomerService {
    @EJB
    private CustomerFacade customerFacade;

    @Override
    public void create(Customer entity) {
        customerFacade.create(entity);
    }

    @Override
    public void edit(Customer entity) {
        customerFacade.edit(entity);
    }

    @Override
    public void remove(Customer entity) {
        customerFacade.remove(entity);
    }

    @Override
    public Customer find(Object id) {
        return customerFacade.find(id);
    }

    @Override
    public Customer find(Customer entity) {
        return customerFacade.find(entity);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerFacade.getAll();
    }
}
