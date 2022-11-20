package ch.swindiatours.model;

public class Order {
    private int id_order;
    private double totalPrice;
    private Customer customer;

    public int getId() {
        return id_order;
    }
    public void setId(int id_order) {
        this.id_order = id_order;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double TotalPrice) {
        this.totalPrice = totalPrice;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
