package ch.swindiatours.persistance;

import ch.swindiatours.model.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class InvoiceFacade extends Facade<Invoice>{
    @PersistenceContext(unitName = "ch.swindiatours")
    private EntityManager em;

    public InvoiceFacade() {
        super(Invoice.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Invoice> findByCustomer(Integer customerId) {

        Query query = em.createNamedQuery("Invoice.findByCustomerId");
        query.setParameter("customerId", customerId);

        return query.getResultList();
    }
}
