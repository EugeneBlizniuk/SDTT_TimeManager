package by.bsuir.manager.web.servlet;

import by.bsuir.manager.controller.Controller;
import by.bsuir.manager.controller.factory.ControllerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static by.bsuir.manager.constants.Constants.*;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/WelcomePage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("signUpButton") != null) {
            response.sendRedirect("/sign-up");
        } else if(request.getParameter("signInButton") != null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            System.out.println("login: " + login + "\nPassword: " + password + "\n");

            if(login != null && password != null) {
                PrintWriter printWriter = response.getWriter();
                if(!login.equals("") && !password.equals("")) {
                    String result;
                    Controller controller = ControllerFactory.getInstance().getController();
                    result = controller.executeTask("Sign_In" + "-" + login + "-" + password);
                    if(result.equals(CORRECT_PASSWORD)) {
                        response.sendRedirect("/main-page");
                    } else if(result.equals(login)) {
                        printWriter.print(WRONG_LOGIN_JS);
                    } else {
                        printWriter.print(WRONG_PASSWORD_JS);
                    }
                } else {
                    printWriter.print(EMPTY_FIELD_JS);
                }
            }
        } else if(request.getParameter("justTryButton") != null) {
            response.sendRedirect("/main-page");
        }
    }
}
