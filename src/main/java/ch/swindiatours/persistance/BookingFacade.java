package ch.swindiatours.persistance;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.Tour;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BookingFacade extends Facade<Booking> implements Serializable {
    @PersistenceContext(unitName = "swindiatours")
    private EntityManager em;
    public BookingFacade() {
        super(Booking.class);
    }

    public BookingFacade(Class<Booking> orderClass) {
        super(orderClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HashMap<Long, Booking> getAllBookingMap(){
        HashMap<Long, Booking> orders = new HashMap<>();
        for(Booking booking: getAll()){
            orders.put(booking.getBookingId(), booking);
        }
        return orders;
    }

    public List<Booking> getAllBooking(){
        return em.createNamedQuery("booking.getAll", Booking.class).getResultList();
    }

    public List<Booking> findOpenByUser(){
        return em.createNamedQuery("booking.getAll", Booking.class).getResultList();
    }

    public Booking getBookingByBookingId(int bookingId){
        return em.createNamedQuery("booking.findByBookingId", Booking.class).setParameter("bookingId", bookingId).getSingleResult();
    }

    public Booking getBookingByUserId(int userId){
        return em.createNamedQuery("booking.findByBookingId", Booking.class).setParameter("userId", userId).getSingleResult();
    }


    @Override
    public void create(Booking booking) {
        em.getTransaction().begin();
        em.persist(booking);
        em.flush();
        em.refresh(booking);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Booking booking) {
        em.getTransaction().begin();
        em.refresh(booking);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void remove(Booking booking) {
        em.getTransaction().begin();
        em.remove(booking);
        em.flush();
        em.refresh(booking);
        em.getTransaction().commit();
    }
}
