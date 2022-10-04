package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Invoice;
import ch.swindiatours.services.IInvoiceService;
import jakarta.ejb.EJB;
import java.io.Serializable;
import java.util.List;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.Visibility;


public class InvoiceController implements Serializable, IController<Invoice> {

    @EJB(beanName = "InvoiceService")
    private IInvoiceService invoiceService;

    private List<Invoice> invoices;
    private TreeNode invoicesByCustomer;

    private int invoiceCount;

    @Override
    public List<Invoice> findAll() {
        return invoiceService.findAll();
    }

    public List<Invoice> getInvoices() {
        invoices = findAll();
        invoiceCount = invoices.size();
        return invoices;
    }

    public int getInvoiceCount() {
        return invoiceCount;
    }

    public void onRowToggle(ToggleEvent event) {

        if (event.getVisibility() == Visibility.VISIBLE) {

            if (event.getData() != null) {

                List<Invoice> list = invoiceService.findByCustomer(((Customer) event.getData()).getUserId());

                invoicesByCustomer = new DefaultTreeNode(new InvoiceTreeNode("AAAA", "BBBB", "CCCC"), null);

                list.forEach(invoice -> {
                    TreeNode tn = new DefaultTreeNode(new InvoiceTreeNode(invoice.getId().toString(), invoice.getCustomer().toString(), invoice.getTotal().toString()), invoicesByCustomer);
                });

                if (!list.isEmpty()) {
                    invoiceCount = list.size();
                }
            }
        }
    }

    public TreeNode getInvoicesByCustomer() {
        return invoicesByCustomer;
    }

    public void setInvoicesByCustomer(TreeNode invoicesByCustomer) {
        this.invoicesByCustomer = invoicesByCustomer;
    }

}