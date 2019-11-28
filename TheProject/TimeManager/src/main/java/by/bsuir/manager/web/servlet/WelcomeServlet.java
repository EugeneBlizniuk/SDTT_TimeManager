package by.bsuir.manager.web.servlet;

import by.bsuir.manager.controller.Controller;
import by.bsuir.manager.controller.factory.ControllerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static by.bsuir.manager.constants.Constants.CORRECT_PASSWORD;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/WelcomePage.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("signUpButton") != null) {
            response.sendRedirect("/sign-up");
        } else if(request.getParameter("signInButton") != null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            System.out.println("login: " + login + "Password: " + password + "\n");

            if(login != null && password != null) {
                String result;
                Controller controller = ControllerFactory.getInstance().getController();
                result = controller.executeTask("Sign_In" + "-" + login + "-" + password);
                if(result.equals(CORRECT_PASSWORD)) {
                    response.sendRedirect("/main-page");
                } else if(result.equals(login)) {
                    //show the login is not correct
                    System.out.println(result);
                } else {
                    //show the password is not correct
                    System.out.println(result);
                }
            }
        } else if(request.getParameter("justTryButton") != null) {
            response.sendRedirect("/main-page");
        }
    }
}
