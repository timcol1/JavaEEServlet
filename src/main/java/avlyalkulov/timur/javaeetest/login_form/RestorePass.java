package avlyalkulov.timur.javaeetest.login_form;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RestorePass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = "jdbc:postgresql://localhost:5432/login_form";
        String name = "postgres";
        String pass = "1504";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(url, name, pass)) {
            String email = request.getParameter("email");
            PrintWriter pw = response.getWriter();
            PreparedStatement checkLogin = connection.prepareStatement("select user_name from users\n" +
                    "where email = ?");
            checkLogin.setString(1, email);
            ResultSet resultSet = checkLogin.executeQuery();
            if (resultSet.next()) {
                pw.println("<h1>An email has been sent to your email to reset your password</h1>");
                pw.println("<form>\n" +
                        "    <main>\n" +
                        "        <label for=\"uname\"><b>Enter your code</b></label>\n" +
                        "        <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>\n" +
                        "        <br><br>\n" +
                        "        <button type=\"submit\">Login</button>\n" +
                        "   </main>\n" +
                        "</form>");
            } else {
                pw.println("<h1>This email does not exist</h1>");
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
