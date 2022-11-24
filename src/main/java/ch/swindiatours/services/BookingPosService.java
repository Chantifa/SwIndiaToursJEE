package ch.swindiatours.services;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.BookingPos;
import ch.swindiatours.model.Tour;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Service class of entity BookingPos, responsible for the database access of that entity.
 *
 * @author chant
 * @version 1.0
 */
public class BookingPosService {
    private EntityManager entityManager;

    /**
     * Constructor for BookingPosService
     */
    public BookingPosService() {
    }

    /**
     * Create a new BookingPos
     *
     * @param bp new BookingPos to be created
     */
    public void create(BookingPos bp) {
        entityManager.getTransaction().begin();
        entityManager.persist(bp);
        entityManager.getTransaction().commit();
    }

    /**
     * Update an existing OrderPosen
     *
     * @param op to be updated
     */
    public void updateExisting(BookingPos op) {
        entityManager.refresh(op);
    }

    /**
     * Remove an existing OrderPos
     *
     * @param op to be removed
     */
    public void removeExisting(BookingPos op) {
        entityManager.remove(op);
    }

    /**
     * Find OrderPos by its DB Id
     *
     * @param orderPosId in DB to be found
     * @return OrderPos found matching the provided id
     */
    public BookingPos findById(long orderPosId) {
        return entityManager.find(BookingPos.class, orderPosId);
    }

    /**
     * Find all OrderPos in DB
     *
     * @return List containing all OrderPos in database
     */
    public List<BookingPos> findAll() {
        TypedQuery<BookingPos> query = entityManager.createQuery(
                "SELECT c FROM BookingPos c", BookingPos.class);
        return (List<BookingPos>) query.getResultList();
    }

    /**
     * Find all OrderPos of a Booking.
     *
     * @param bookingId Booking to be matched
     * @return List of OrderPos matching that Booking
     */
    public List<BookingPos> findAllByOrder(Booking bookingId) {
        TypedQuery<BookingPos> query = entityManager.createQuery(
                "SELECT c FROM BookingPos c where (c.bookingId)=(:orderId)", BookingPos.class);
        query.setParameter("bookingId", bookingId);
        return (List<BookingPos>) query.getResultList();
    }

    /**
     * Find a booking position by tour and booking
     *
     * @param tourId  to be matched in find
     * @param booking to be matched in find
     * @return one booking position matching both criteria
     */
    public BookingPos findByTourAndOrder(Tour tourId, Booking booking) {
        TypedQuery<BookingPos> query = entityManager.createQuery(
                "SELECT c FROM BookingPos c" +
                        " WHERE (c.tourId)=(:tourId) AND (c.bookingId)=(:bookingId)", BookingPos.class);
        query.setParameter("tourId", tourId);
        query.setParameter("bookingId", booking);
        return query.getSingleResult();
    }
}
