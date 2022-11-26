package ch.swindiatours.view.controller;

import ch.swindiatours.model.Cart;
import ch.swindiatours.services.ToursService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "tours", value = "/Tours")
public class TourServlet extends HttpServlet {

    @Inject
    private ToursService toursService;

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        String command = request.getParameter("submit");

        Cart cartEntity = (Cart) session.getAttribute("cart");
        // Determine which command to perform
        if (command.equals("Add to Basket")) {
            // Get the item from the request
            String tourId = request.getParameter("tourId");
            String tour = request.getParameter("tour");

            String desc = request.getParameter("description");
            String price = request.getParameter("price");

            // Add the selected item to the cartEntity
            toursService.findAll();

            cartEntity.addItem(tourId, tour, desc, price, 1);

            System.out.println(tourId);
            System.out.println(tourId);

            System.out.println(desc);

            System.out.println(price);

            System.out.println("I'm in TourServlet");
            System.out.println(cartEntity);
        }

        // Redirect the response
        // after adding an item to the cartEntity.
        response.sendRedirect("index.jsp");
    }

    //Get Servlet information
    public String getServletInfo() {

        return "TourServlet Information";
    }
}
