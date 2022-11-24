package ch.swindiatours.services;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.BookingState;
import ch.swindiatours.model.Customer;
import ch.swindiatours.persistance.BookingFacade;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;

/**
 * Booking service, responsible for the database access of that entity.
 *
 * @author chant
 * @version 1.0
 */
public class BookingService {

    private BookingFacade bookingFacade;

    /**
     * Constructor for BookingService, providing the common EntityManager.
     */
    public BookingService() {
    }

    /**
     * Create a new booking
     *
     * @param entity new booking to be created
     */
    public void create(Booking entity) {
        bookingFacade.create(entity);
    }

    /**
     * Update an existing Booking
     *
     * @param entity to be updated
     */
    public void edit(Booking entity) {
        bookingFacade.edit(entity);
    }

    /**
     * Remove an existing Booking
     *
     * @param entity to be removed
     */

    public void remove(Booking entity) {
        bookingFacade.remove(entity);
    }

    /**
     * Find Booking by its DB Id
     *
     * @param entity in DB to be found
     * @return Booking found matching the provided id
     */
    public Booking findById(String entity) {
        return bookingFacade.find(Customer.class, entity);
    }

    /**
     * Find all Orders in DB
     *
     * @return List containing all orders in database
     */
    public List<Booking> findAll() {
        return  bookingFacade.getAllBooking();
    }

    /**
     * Find all Booking matching one Customer
     *
     * @param customer to be matched to all Bestellungen.
     * @return List of Bestellung matching that one Benutzer
     */
    public List<Booking> findByUser(Customer customer) {
        return List.of(bookingFacade.find(Customer.class,customer));
    }

    /**
     * Find all open Booking (Status = BookingState.CREATED) matching a Customer.
     *
     * @return Bestellung matching those criteria
     */
    public List<Booking> findOpenByUser() {
        return bookingFacade.findOpenByUser();
    }

}
