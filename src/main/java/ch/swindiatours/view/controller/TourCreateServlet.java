package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Role;
import ch.swindiatours.model.Tour;
import ch.swindiatours.services.ToursService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;

/**
 * Servlet to create new Tour using HTTP POST.
 * Using encoder-type "multipart/form-data" because image is transmitted as well.
 *
 * @author chant
 * @version 1.0
 */
@MultipartConfig
@WebServlet("/tourCreate")
public class TourCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    private ToursService toursService;

    /**
     * POST to create an Artikel, use enctype="multipart/form-data" to allow transfer of image as file.
     * Only possible for logged in user with Role = Role.ADMIN
     *
     * @param request  containing following parameters:
     *                 title = Title of Artikel
     *                 description = Description of Artikel
     *                 price = Price of Artikel as float or int
     *                 articleimp = Image of artikel
     * @param response forward dispatcher to index.html
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            if (customer.getRole().equals(Role.ADMIN)) {
                String title = request.getParameter("title");
                String desc = request.getParameter("description");
                String price = request.getParameter("price");
                Part filepart = request.getPart("tourimp");
                byte[] encodefile = Base64.getEncoder().encode(filepart.getInputStream().readAllBytes());

                Tour tour = new Tour();
                tour.setTitel(title);
                tour.setDescription(desc);
                tour.setPrice(BigDecimal.valueOf(Double.valueOf(price)));
                tour.setImg(encodefile);

                toursService.findAll();
                toursService.create(tour);
            }
        }
        // "../index.html" weil root auf /api/ zeigt
        dispatcher.forward(request, response);
    }
}
