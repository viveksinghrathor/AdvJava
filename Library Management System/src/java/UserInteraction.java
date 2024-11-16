/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

//import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import java.sql.*;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/UserInteraction"})
public class UserInteraction extends HttpServlet {

  

 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String action = request.getParameter("action"); // Retrieve the action parameter

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish database connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS", "root", "Vinit@6203");

        if ("view".equals(action)) { // Check if action is to view
            // Retrieve parameters from the request
            String bookname = request.getParameter("bookn");
            String authorname = request.getParameter("authorname");

            if (bookname == null || bookname.isEmpty()) {
                response.getWriter().println("Please provide a valid book name.");
                return;
            }

            // Prepare the SQL statement
            pst = conn.prepareStatement("SELECT * FROM LMSTABLE WHERE BOOKNAME = ?");
            pst.setString(1, bookname);

            // Execute the query
            rs = pst.executeQuery();

            // Process the result set
            boolean found = false;
            while (rs.next()) {
                found = true;
                String bookn = rs.getString("BOOKNAME");
                String bookid = rs.getString("BOOKID");
                String auth = rs.getString("AUTHOR");
                String category = rs.getString("CATEGORY");

                // Write response
                response.getWriter().println("Book Name: " + bookn);
                response.getWriter().println("Book ID: " + bookid);
                response.getWriter().println("Author: " + auth);
                response.getWriter().println("Category: " + category);
            }

            if (!found) {
                response.getWriter().println("No books found with the provided name.");
            }

        } else if ("delete".equals(action)) { // Check if action is to delete
            String bookname = request.getParameter("bookn");
            if (bookname == null || bookname.isEmpty()) {
                response.getWriter().println("Please provide a valid book name for deletion.");
                return;
            }
            pst = conn.prepareStatement("DELETE FROM LMSTABLE WHERE BOOKNAME = ?");
            pst.setString(1, bookname);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                response.getWriter().println("Row Deleted Successfully");
            } else {
                response.getWriter().println("No row found to delete.");
            }
        } else {
            response.getWriter().println("Invalid action specified.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.getWriter().println("An error occurred: " + e.getMessage());
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            String bookid = request.getParameter("bookid");
            String bookname = request.getParameter("bookname");
            String author = request.getParameter("author");
            String category = request.getParameter("category");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS", "root", "Vinit@6203");
            pst = conn.prepareStatement("Insert into LMSTABLE Values (?,?,?,?)");
            pst.setString(1, bookid);
            pst.setString(2, bookname);
            pst.setString(3, author);
            pst.setString(4, category);
            PrintWriter out = response.getWriter();
            int rows = pst.executeUpdate();
            if (rows > 0) {
                out.println("Rows Inserted");
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }

    }

}
