package ch.swindiatours.services;

import ch.swindiatours.model.Customer;

public interface ILoginService {
    Customer find(Customer entity);

    Customer find(Object id);
}
