package ch.swindiatours.services;

import ch.swindiatours.model.Customer;
import ch.swindiatours.persistance.CustomerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

@Stateless(name = "LoginService")
@Local
public class LoginServices implements ILoginService {
        @EJB
        private CustomerFacade customerFacade;

        @Override
        public Customer find(Customer entity) {
            customerFacade.find(entity);
            return entity;
        }

        @Override
        public Customer find(Object id) {
            return customerFacade.find(id);
        }
}
