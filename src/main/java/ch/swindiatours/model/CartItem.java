package ch.swindiatours.model;

import java.math.BigDecimal;

public class CartItem {
    private int quantity;
    private Customer customer;
    private Tour tour;
    private String price;
        private String description;

      public CartItem(Tour tour) {
          this.tour = tour;
      }
      public CartItem(){
      }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

     public void incrementQuantity() {
        quantity++;
   }
   public void decrementQuantity() {
        quantity--;
    }

    public Double getTotal() {
        Double amount = 0.0;
        amount = (this.getQuantity() * tour.getPrice());
        return amount;
    }

}
