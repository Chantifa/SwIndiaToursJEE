package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Tour;
import ch.swindiatours.services.ToursService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Search servlet for tours using HTTP GET.
 *
 * @author chant
 * @version 1.0
 */
@WebServlet(name="tourSearch",value="/tourSearch")
public class TourSearchServlet extends HttpServlet {

    /**
     * GET request to search tour
     *
     * @param request  containing following parameter:
     *                 query - Search query as String
     * @param response HTML String to display search results
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchquery = request.getParameter("query");
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        ToursService toursService = new ToursService();
        List<Tour> tourList = toursService.search(searchquery);
        PrintWriter out = response.getWriter();

        String result = "nothing found";

        if (tourList.size() == 1)
            result = "found one";
        else if (!tourList.isEmpty())
            result = "found (" + (tourList.size()) + ")";

        out.print("<h2>" + result + " searched: \"" + searchquery + "\"</h2>");
        TourOutputBuilder.build(tourList, out, customer);
    }
}
