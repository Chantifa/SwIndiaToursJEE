package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Tour;

import java.io.PrintWriter;
import java.util.List;

/**
 * Builder for Tours to present on page, using a 3xN grid of Tours.
 *
 * @author chant
 * @version 1.0
 */
public class TourOutputBuilder {

    /**
     * Creating a jsp string containing a view of all Tour
     *
     * @param tourList with all Tour to be displayed
     * @param out         PrintWriter to load the HTML String into
     * @param customer        current user to prevent ordering without login
     */
    public static void build(List<Tour> tourList, PrintWriter out, Customer customer) {
        if (tourList.isEmpty()) {
            out.print("<div class=\"container\">");
            if (customer == null)
                out.println("<p>Please login for the booking</p>");
            out.print("<div class=\"row\">");
            out.print("<p> No tour available</p>");
            out.print("</div>");
        } else {
            int i = 0;
            out.print("<div class=\"container\">");
            if (customer == null)
                out.println("<p>Please login to book</p>");
            for (Tour tour : tourList) {
                if (i % 3 == 0) {
                    out.print("<div class=\"row\">");
                }
                String imgString = new String(tour.getImg());
                out.print("<div class=\"col\">");
                //Tour
                out.print("<h2>" + tour.getTitel() + "</h2>");
                out.print("<div class=\"row\">");
                out.print("<div class=\"col\">");
                out.print("<img class=\"img-thumbnail\" id=\"imageID_" + tour.getId() + "\" src=\"data:image/jpg;base64," + imgString + "\">");
                out.print("</div>");// End div class=COL
                out.print("<div class=\"col\">");
                out.print("<div>" + tour.getDescription() + "</div>");
                out.print("<div>Preis: " + tour.getPrice() + " CHF </div>");
                if (customer != null)
                    out.print("<button type=\"button\" class=\"btn btn-outline-primary\" onclick=\"order(" + tour.getId() + ")\">Book</button>");
                out.print("</div>");// End div class=COL
                out.print("</div>");// End div class=row
                out.print("</div>");// End div class=COL
                if (i > 0 && i % 3 == 0) {
                    out.print("</div>");// End div class=row
                }
                i++;
            }
            while (i % 3 != 0) {
                out.print("<div class=\"col-sm\">");
                out.print("</div>");
                i++;
            }
        }
        out.print("</div>");
    }
}
