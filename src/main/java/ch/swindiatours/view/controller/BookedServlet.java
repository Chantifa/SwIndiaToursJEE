package ch.swindiatours.view.controller;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.Customer;
import ch.swindiatours.model.BookingState;
import ch.swindiatours.services.BookingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet for setting status of order to delivered using HTTP GET
 *
 * @author Lisia Ponti / Philipp Frey
 * @version 1.0
 */
@WebServlet("/TourBooked")
public class BookedServlet extends HttpServlet {

    /**
     * GET Method to set order to delivered, only valid if Benutzer is signed in
     *
     * @param request  forward to booking.html on valid users (Benutzer), if not signed in forward to login.html
     * @param response -
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        RequestDispatcher dispatcher;
        // Check if user is logged in
        if (customer != null) {
            // Try getting the pending order
            BookingService bookingService = new BookingService();
            Booking booking;

            String bookingId = request.getParameter("orderId");
            if (!bookingId.isEmpty()) {
                // Create order if none existing
                try {
                    booking = bookingService.findById(bookingId);
                    if (booking.getBookingState() == BookingState.PAID) {
                        booking.setBookingState(BookingState.BOOKED);
                        bookingService.remove(booking);
                        bookingService.create(booking);
                    }
                } catch (Exception ex) {

                }
            }
            dispatcher = request.getRequestDispatcher("booking.html");
        } else {
            dispatcher = request.getRequestDispatcher("login.html");
        }
        dispatcher.forward(request, response);
    }
}

