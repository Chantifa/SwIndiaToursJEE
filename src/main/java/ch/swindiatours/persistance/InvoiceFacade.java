package ch.swindiatours.persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class InvoiceFacade {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

}
