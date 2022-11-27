package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import ch.swindiatours.persistance.CustomerFacade;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Model;

import java.util.List;

/**
 *
 * Use stateless name because of IToursService
 */

public class CustomerService implements ICustomerService{
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
        return customerFacade.find(Customer.class, id);
    }

    @Override
    public Customer find(Customer entity) {
        return customerFacade.find(Customer.class, entity);
    }

    @Override
    public List<Customer> getAll() {
        return customerFacade.getAllCustomers();
    }
}
