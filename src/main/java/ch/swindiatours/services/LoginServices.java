package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import ch.swindiatours.persistance.CustomerFacade;
import jakarta.ejb.Local;

@Local
public class LoginServices implements ILoginService {
    private CustomerFacade customerFacade;

    @Override
    public Customer find(Customer entity) {
        customerFacade.find(Customer.class, entity);
        return entity;
    }

    @Override
    public Customer find(Object id) {
        return customerFacade.find(Customer.class, id);
    }
}
