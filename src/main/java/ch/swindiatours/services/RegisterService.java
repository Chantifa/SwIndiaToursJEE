package ch.swindiatours.services;

import ch.swindiatours.model.Customer;

public class RegisterService {
    private final Customer customer;

    public RegisterService(Customer customer){
        this.customer = customer;
    }

    public int addCusomer(Customer customer){
        insert(customer)

    }

}
