package avlyalkulov.timur.javaeetest.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookieId = new Cookie("some_id", "123");
        Cookie cookieName = new Cookie("some_name", "Tom");
        cookieId.setMaxAge(24 * 60 * 60);
        cookieName.setMaxAge(24 * 60 * 60);//даже при закрытии бразузера будут сохраняться

        response.addCookie(cookieId);//добавляем в браузер нашу куки
        response.addCookie(cookieName);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
