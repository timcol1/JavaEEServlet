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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            ResultSet resultSet = statement.executeQuery("Select title from shop");
            PrintWriter pw = response.getWriter();
            while (resultSet.next())
                pw.println("<p>" + resultSet.getString(1) + "</p>");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}