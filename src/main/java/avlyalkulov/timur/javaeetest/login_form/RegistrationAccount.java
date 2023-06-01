package avlyalkulov.timur.javaeetest.login_form;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:postgresql://localhost:5432/login_form";
        String name = "postgres";
        String pass = "1504";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(url, name, pass)) {
            PreparedStatement insertUser = connection.prepareStatement("insert into users (password, email, user_name) values (?,?,?)");
            String sentName = request.getParameter("uname");
            String sentPassword = request.getParameter("psw");
            String sentEmail = request.getParameter("email");
            insertUser.setString(1, sentPassword);
            insertUser.setString(2, sentEmail);
            insertUser.setString(3, sentName);
            insertUser.executeUpdate();
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><title>Registered account</title><body>");
            printWriter.println("<h1>You have succesfully registered your account!</h1>");
            printWriter.println("<h1> Hello it is your name - " + sentName + " </h1>");
            printWriter.println("<h1> Hello it is your password - " + sentPassword + " </h1>");
            printWriter.println("<h1> Hello it is your email - " + sentEmail + " </h1>");
            printWriter.println("<a href = /login> Return to login form </a>");
            printWriter.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
