package ch.swindiatours.services;

import ch.swindiatours.model.Invoice;

import java.util.List;

public interface IInvoiceService {
    void create(Invoice entity);

    void create(Invoice entity);

    void edit(Invoice entity);

    void remove(Invoice entity);

    Invoice find(Object id);

    List<Invoice> findAll();

    List<Invoice> findByCustomer(Integer customerId);
}
