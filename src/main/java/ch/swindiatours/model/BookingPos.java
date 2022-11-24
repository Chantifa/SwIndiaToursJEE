package ch.swindiatours.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Class for entity OrderPos in WebShop. Storing data for each order position.
 * @author chant
 * @version 1.0
 */
@Entity
public class BookingPos {
    @GeneratedValue
    @Id
    private Long bookingPosId;
    @ManyToOne
    private Booking bookingId;
    @ManyToOne
    private Tour tourId;
    @Basic
    private int quantity;
    @Basic
    private BigDecimal price;
    @Basic
    private BigDecimal priceTotal;

    public BookingPos() {
    }

    public Long getBookingPosId() {
        return bookingPosId;
    }
    public void setBookingPosId(Long bookingPosId) {
        this.bookingPosId = bookingPosId;
    }

    public Booking getBookingId() {
        return bookingId;
    }
    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public Tour getTourId() {
        return tourId;
    }
    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addOneTour() {
        this.quantity++;
        this.priceTotal = price.add(getPrice());
    }

    public BigDecimal getPriceTotal(){
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal){
        this.priceTotal = priceTotal;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
