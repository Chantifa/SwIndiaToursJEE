package ch.swindiatours.model;

public class Order {
    private int id;
    private double totalPrice;
    private Customer customer;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
