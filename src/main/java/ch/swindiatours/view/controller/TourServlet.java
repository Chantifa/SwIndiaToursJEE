package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Role;
import ch.swindiatours.model.Tour;
import ch.swindiatours.services.ToursService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

/**
 * Servlet to create new Tour using HTTP POST.
 * Using encoder-type "multipart/form-data" because image is transmitted as well.
 *
 * @author chant
 * @version 1.0
 */
@MultipartConfig
@WebServlet(name="tour", value="/tour")
public class TourServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ToursService toursService;

    /**
     * POST to create an tour, use enctype="multipart/form-data" to allow transfer of image as file.
     * Only possible for logged in user with Role = Role.ADMIN
     *
     * @param request  containing following parameters:
     *                 title = Title of tour
     *                 description = Description of tour
     *                 price = Price of tour as bigdecimale
     *                 tourimp = Image of tour
     * @param response forward dispatcher to index.jsp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        final RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        final HttpSession session = request.getSession();
        ToursService toursService = new ToursService();
        List<Tour> tours = toursService.findAll();

        if (!(tours.isEmpty())) {
            request.getRequestDispatcher("tour.jsp").include(request, response);
            for (Tour i : tours)
                out.print("<h2 align='left'>tour: " + i.getTitel() + "</h2>"
                        + "<h4 align='left'> descirption: " + i.getDescription() + "</h4>"
                        + "<h4 align='left'> price: " + i.getPrice() + "</h4>"
                        + "<h4 align='left'>" + i.getImg() + "</h4>");
        } else {
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
                    tour.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
                    tour.setImg(encodefile);

                    toursService.findAll();
                    toursService.create(tour);
                }
            }
            dispatcher.forward(request, response);
        }
    }
}
