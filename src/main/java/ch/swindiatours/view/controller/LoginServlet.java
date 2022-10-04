package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="login", value="/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            //getting userid and password from user

            Customer c = new Customer();

            c.setUsername(email);  //setting them to setters and getters
            c.setPassowrd(password);

            List<Customer> list = new ArrayList<>(); //take a list
            list.add(c);
            // send the values id and password to vadlidate class of getCustomer method and storing the resultset in list
            if (!(list.isEmpty())) {
                //if list has some values then you are logged in
                request.getRequestDispatcher("index.jsp").include(request, response);
                //HttpSession session = request.getSession();
                //session.setAttribute("customer_id", c.getUsername());
                for (Customer i : list)
                    out.print("<h4 align='left'>Welcome " + i.getUsername() + "</h4>");

            } else {
                //if no values are found then the User does not exist
                request.getRequestDispatcher("login.jsp").include(request, response);
                out.print("<p align='center'>Wrong Username/Password. Please try again");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("login.jsp").include(request, response);
            out.print("<p>Please Enter Valid Details To Login</p>");
//executes when user enters invalid details
        }
    }
}
