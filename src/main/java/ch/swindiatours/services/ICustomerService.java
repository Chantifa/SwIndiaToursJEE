package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import jakarta.inject.Inject;

import java.util.List;


public interface ICustomerService  {
    void create(Customer entity);

    void edit(Customer entity);

    void remove(Customer entity);

    Customer find(Object id);

    Customer find(Customer entity);

    List<Customer> getAll();
}
