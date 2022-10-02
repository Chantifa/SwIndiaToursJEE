package ch.swindiatours.model;

public class Basket {

    public CartItem getTour(int quantity) {
        CartItem cartItem = new CartItem();
        try {

            cartItem.setQuantity(quantity);
        } catch(Exception e) {
            System.out.println(e);
        }
        // TODO Auto-generated method stub
        return cartItem;
    }

    public Tour getTourById(String id) {
        Tour tour = new Tour();
        try {
            tour.getId();
            tour.getName();
            tour.getDescription();
            tour.getPrice();
            }
        catch (Exception e){
            System.out.println(e);
        }
        // TODO Auto-generated method stub
        return tour;
    }
}
