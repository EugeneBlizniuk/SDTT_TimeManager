package by.bsuir.manager.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("manager", "123");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/WelcomePage.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("signUpButton") != null) {
            request.getRequestDispatcher("/WEB-INF/pages/SignUp.html").forward(request, response);
        }
    }
}
