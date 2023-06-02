package avlyalkulov.timur.javaeetest.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ForwardRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        PrintWriter pw = response.getWriter();

        pw.println("<html><title>Base Servlet</title><body>");
        pw.println("<h1> Hello it is your request name - " + name + " </h1>");
        pw.println("<h1> Hello it is your surname - " + surname + " </h1>");
        pw.println("</body></html>");

        //Example of Redirect
        //response.sendRedirect("https://www.google.com");
        //response.sendRedirect("/testJSP.jsp");
        //Forward  - форвард может перенаправлять, только на внутрение сервера сервера, нельзя на гугл отправлять
        RequestDispatcher dispatcher = request.getRequestDispatcher("/testJSP.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}