package ch.swindiatours.model;

public class CartItem {
    private String quantity;
    private Customer customer;
    private Tour tour;
    private String price;
    private String description;
    private double dblTotalCost;

   public CartItem(Tour tour) {
    this.tour = tour;
    quantity = "1";
  }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
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
      int q = Integer.parseInt(quantity);
       q++;
    }

    public void decrementQuantity() {
      int q = Integer.parseInt(quantity);
      q --;
    }

    public double getTotal() {
        double amount = 0;
        //   amount = (this.getQuantity() * item.getPrice());
        return amount;
    }
      public double getTotalCost() {
        return dblTotalCost;
      }

   public void setTotalCost(double dblTotalCost) {
    this.dblTotalCost = dblTotalCost;
   }
    public String toString(){
        return "" + description+ ";" +quantity+";" +price+ "";
    }
}
