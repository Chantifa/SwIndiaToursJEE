package ch.swindiatours.view.controller;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.BookingPos;
import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Tour;
import ch.swindiatours.services.BookingPosService;
import ch.swindiatours.services.BookingService;
import ch.swindiatours.services.ToursService;
import jakarta.persistence.NoResultException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Servlet to order an Artikel putting it into basket of user using HTTP POST.
 * Only possible when user logged in.
 * Will search all open orders of that user and add it, if no open order available an order will be created.
 * If same Artikel is already in basket it will increment the quantity by one.
 *
 * @author chant
 * @version 1.0
 */
@WebServlet("/booking")
public class TourBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * POST to add Tour to basket.
     *
     * @param request  conatining following parameter:
     *                 tourId - Tour Id of Artikel to be added
     * @param response if user not logged in, forward to login.jsp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("benutzer");

        // Check if user is logged in
        if (customer != null) {
            Integer tourId = Integer.parseInt(request.getParameter("tourId"));
            // Try getting the pending order
            BookingService bookingService = new BookingService();
            Booking booking = null;
            // Create order if none existing
            try {
                List<Booking> bookings = bookingService.findOpenByUser();
            } catch (NoResultException ex) {
                Booking newBooking = new Booking();
                bookingService.create(newBooking);
            }

            session.setAttribute("basket", booking);

            // Try getting the tour
            ToursService tourService = new ToursService();
            Tour tour = tourService.find(tourId);

            // Set orderposition only when tour valid
            if (tour != null) {
                BookingPosService bookingPosService = new BookingPosService();
                BookingPos bookingPos;
                // Search if position already exists -> only increment quantity by one
                try {
                    bookingPos = bookingPosService.findByTourAndOrder(tour, booking);
                    bookingPos.addOneTour();
                    bookingPosService.removeExisting(bookingPos);
                    bookingPosService.create(bookingPos);
                } catch (NoResultException ex) {
                    bookingPos = new BookingPos();
                    bookingPosService.create(bookingPos);
                }
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
