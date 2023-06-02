package avlyalkulov.timur.javaeetest.login_form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

public class RestorePass extends HttpServlet {
    String truePass;
    String url = "jdbc:postgresql://localhost:5432/login_form";
    String name = "postgres";
    String pass = "1504";
    String email;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(url, name, pass)) {
            email = request.getParameter("email");
            PrintWriter pw = response.getWriter();
            PreparedStatement checkLogin = connection.prepareStatement("select user_name from users\n" +
                    "where email = ?");
            checkLogin.setString(1, email);
            ResultSet resultSet = checkLogin.executeQuery();
            if (resultSet.next()) {
                int num = new Random().nextInt(800_000) + 100_000;
                truePass = String.valueOf(num);
                try {
                    new GMailer().sendMail(email, "Restore password", "This is your code to restore pass " + num);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                pw.println("<h1>Code has been sent to your email to reset your password</h1>");
                pw.println("<form>\n" +
                        "    <main>\n" +
                        "        <label for=\"code\"><b>Enter your code</b></label>\n" +
                        "        <input type=\"text\" placeholder=\"Enter code\" name=\"code\" required>\n" +
                        "        <br><br>\n" +
                        "        <button type=\"submit\">Check code</button>\n" +
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
        PrintWriter pw = new PrintWriter(response.getWriter());
        String code = request.getParameter("code");
        String password = request.getParameter("password");
        if (password != null) {
            try (Connection connection = DriverManager.getConnection(url, name, pass);
                 PreparedStatement changePassword = connection.prepareStatement("Update users set password = ? where email = ?")) {
                changePassword.setString(1, password);
                changePassword.setString(2, email);
                changePassword.executeUpdate();
                pw.println("<html><title>Password</title><body>");
                pw.println("<h1> Your password was successfully restored</h1>");
                pw.println("</body></html>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (code.equals(truePass)) {
                pw.println("<html><title>Restore Pass</title><body>");
                pw.println("<h1>Please enter the new password</h1>");
                pw.println("<form>" +
                        "    <main>\n" +
                        "        <label for=\"password\"><b>Enter your new password</b></label>\n" +
                        "        <input type=\"text\" placeholder=\"Enter new password\" name=\"password\" required>\n" +
                        "        <br><br>\n" +
                        "        <button type=\"submit\">Change password</button>\n" +
                        "   </main>\n" +
                        "</form>");
                pw.println("</body></html>");
            } else {
                pw.println("<html><title>Restore Pass</title><body>");
                pw.println("<h1> You enter the wrong value </h1>");
                pw.println("</body></html>");
            }
        }
    }
}
