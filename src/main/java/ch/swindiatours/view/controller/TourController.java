package ch.swindiatours.view.controller;
import ch.swindiatours.model.Cart;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;

@WebServlet(name = "tours", value = "/tours")
public class TourController extends HttpServlet {

    public void init(ServletConfig config)
                throws ServletException {
            super.init(config);
        }

        //Process the HTTP Post request
        public void doPost(HttpServletRequest request,
                           HttpServletResponse response)
                throws ServletException, IOException {

            HttpSession session = request.getSession();
            String command = request.getParameter("submit");

            Cart cart = (Cart)session.getAttribute("cart");
            // Determine which command to perform
            if ( command.equals("Add to Basket") ) {
                // Get the item from the request
                String id = request.getParameter("tourId");

                String desc = request.getParameter("description");
                String price =  request.getParameter("price");

                // Add the selected item to the cart
                cart.addItem(id, desc, price, 1);

                System.out.println(id);

                System.out.println(desc);

                System.out.println(price);

                System.out.println("I'm in TourServlet");
                System.out.println(cart);
                // }
            }

            // Redirect the response
            // after adding an item to the cart.
            response.sendRedirect("index.jsp");
        }

        //Get Servlet information
        public String getServletInfo() {

            return "TourController Information";
        }
}
