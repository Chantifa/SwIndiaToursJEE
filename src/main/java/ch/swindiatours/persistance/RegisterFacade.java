package ch.swindiatours.persistance;

import ch.swindiatours.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.sql.*;

public class RegisterFacade extends CustomerFacade implements Serializable {
    private final String url = "";
    private final String user = "";
    private final String password = "";


    @PersistenceContext
    private EntityManager em;

    public RegisterFacade(Class<CustomerFacade> entityClass) {

        super(entityClass);
    }
    public int insert(Customer customer){
        if(!(customer == null)) {
            insert(customer);
        }
        return 1;
    }
}
