package avlyalkulov.timur.javaeetest.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //пример проверки корзины пользователя через сесси
        /*HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        String nameProduct = request.getParameter("nameProduct");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (basket == null) {
            basket = new Basket();
            basket.setNameProduct(nameProduct);
            basket.setQuantity(quantity);
        }
        session.setAttribute("basket", basket);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showBasket.jsp");
        dispatcher.forward(request, response);*/

        //пример авторизации
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user == null) {
            //response для анонимного польозователя логин или регистрация
            //session.setAttribute("current_user", ID);
        } else {
            //response для авторизованого пользователя
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
