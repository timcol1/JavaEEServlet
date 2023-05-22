package avlyalkulov.timur.javaeetest.login_form;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class CheckLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:postgresql://localhost:5432/jdbc-test";
        String name = "postgres";
        String pass = "1504";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(url, name, pass)) {
            Statement statement = connection.createStatement();
            String sentName = request.getParameter("uname");
            PrintWriter pw = response.getWriter();
            pw.println("<html><title>Base Servlet</title><body>");
            pw.println("<h1> Hello it is your request name - " + sentName + " </h1>");
            pw.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}