package ch.swindiatours.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "booking.getAll", query = "SELECT booking FROM Booking booking"),
        @NamedQuery(name = "booking.findByUserId", query = "SELECT booking FROM Booking booking WHERE booking.userId = :userId"),
        @NamedQuery(name = "booking.findByBookingId", query = "SELECT booking FROM Booking booking WHERE booking.bookingId = :bookingId"),
        @NamedQuery(name = "booking.findOpenBooking", query = "SELECT booking FROM Booking booking where booking.userId=(:userId) AND booking.bookingDate=(:state)")
      })

@Entity
public class Booking {
    @GeneratedValue
    @Id
    @Column(name = "bookingId")
    private Long bookingId;
    @Basic
    @Column(name = "bookingDate")
    private LocalDateTime bookingDate;
    @ManyToOne
    @Column(name = "fk_tourId")
    private Tour tourId;
    @ManyToOne
    @Column(name = "fk_userId")
    private Customer userId;
    @Basic
    @Column(name = "bookingState")
    private BookingState bookingState;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "bookedAtDate")
    private Timestamp bookedAtDate;


    public Booking() {
    }

    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDateTime orderDate) {
        this.bookingDate = orderDate;
    }

    public Customer getCustomerId() {
        return userId;
    }
    public void setCustomerId(Customer customerId) {
        this.userId = customerId;
    }

    public BookingState getBookingState() {
        return bookingState;
    }
    public void setBookingState(BookingState bookingState) {
        this.bookingState = bookingState;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Tour getTourId(){
        return tourId;
    }

    public void setTourId(Tour tourId){
        this.tourId = tourId;
    }

    public Timestamp getBookedAtDate(){
        return bookedAtDate;
    }
    public void setBookedAtDate(){
        this.bookedAtDate = bookedAtDate;
    }
}
