package ch.swindiatours.services;

import ch.swindiatours.model.Customer;

import java.util.Collection;

public interface ICustomerService extends IToursService<Customer> {
    Customer find(Customer entity);

    public Collection<String> findAllCities();
}
