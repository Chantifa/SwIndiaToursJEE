package ch.swindiatours.services;

import ch.swindiatours.model.Invoice;
import ch.swindiatours.persistance.InvoiceFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless(name = "InvoiceService")
@Local
public class InvoiceService implements IInvoiceService {

    @EJB
    private InvoiceFacade invoiceFacade;

    @Override
    public void create(Invoice entity) {
        invoiceFacade.create(entity);
    }

    @Override
    public void edit(Invoice entity) {
        invoiceFacade.edit(entity);
    }

    @Override
    public void remove(Invoice entity) {
        invoiceFacade.remove(entity);
    }

    @Override
    public Invoice find(Object id) {
        return invoiceFacade.find(id);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceFacade.findAll();
    }

    @Override
    public List<Invoice> findByCustomer(Integer customerId) {
        return invoiceFacade.findByCustomer(customerId);
    }
}