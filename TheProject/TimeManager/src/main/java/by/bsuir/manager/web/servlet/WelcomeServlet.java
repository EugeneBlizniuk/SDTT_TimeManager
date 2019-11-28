package by.bsuir.manager.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/WelcomePage.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("signUpButton") != null) {
//            response.getWriter().print("It works!");
//            request.getRequestDispatcher("/sign-up").forward(request, response);
            response.sendRedirect("/sign-up");
        } else if(request.getParameter("signInButton") != null) {

        }
    }
}
