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
            String sentName = request.getParameter("uname");
            String sentPassword = request.getParameter("psw");
            PrintWriter pw = response.getWriter();
            PreparedStatement checkLogin = connection.prepareStatement("select user_name from users\n" +
                    "where user_name = ? and password = ?");
            checkLogin.setString(1, sentName);
            checkLogin.setString(2, sentPassword);
            ResultSet resultSet = checkLogin.executeQuery();
            if (resultSet.next())
                pw.println("<h1>You have successfully log in</h1>");
            else {
                pw.println("<h1>You have entered the wrong login or passsword</h1>");
                pw.println("<a href = /login >Return to log in form</a>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}