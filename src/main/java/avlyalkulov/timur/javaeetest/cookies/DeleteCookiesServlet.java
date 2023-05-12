package avlyalkulov.timur.javaeetest.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //для удаления куки надо его перезаписать
        Cookie cookie = new Cookie("some_id", "");

        cookie.setMaxAge(0); // мы взяли такое же куки с таким айди и теперь мы перезаписали его и удалили его то есть за 0 сек оно исчезнет
        //cookie.setMaxAge(-1); //валидное значение, при таком значение удаляются куки когда клиент закроет бразуер

        response.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
