package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import  ch.swindiatours.persistance.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

import java.util.List;

/**
 *
 * Use stateless name because of ISalesService
 */
@Stateless(name = "CustomerService")
@Local
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
    public List<Customer> findAll() {
        return customerFacade.findAll();
    }

    @Override
    public Customer find(Customer entity) {
        return customerFacade.find(entity);
    }

    public List findAllCities() {

        return customerFacade.findAllCities();
    }
}
