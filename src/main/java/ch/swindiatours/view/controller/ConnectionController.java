package ch.swindiatours.view.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    public static Connection getConnection() throws SQLException { //making a static connection,shares to all classes
        Connection conn = null;
        try {
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            javax.sql.DataSource ds = (javax.sql.DataSource)
                    ctx.lookup("jdbc/swindiatours");
            java.sql.Connection con = ds.getConnection();

        } catch (Exception e) {
            conn.close();
            //throws an error if at all its unable to create an connection
            System.out.println(e);
        }
        return conn; // returns the connection.
    }
}
