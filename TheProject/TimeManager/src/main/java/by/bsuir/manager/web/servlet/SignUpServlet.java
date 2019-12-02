package by.bsuir.manager.web.servlet;

import by.bsuir.manager.controller.Controller;
import by.bsuir.manager.controller.factory.ControllerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static by.bsuir.manager.constants.Constants.*;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/SignUp.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String secondPassword = request.getParameter("secondPassword");


        if(login != null && password != null && secondPassword != null) {
            PrintWriter printWriter = response.getWriter();
            if(!login.equals("") && !password.equals("") && !secondPassword.equals("")) {
                if(password.equals(secondPassword)) {
                    Controller controller = ControllerFactory.getInstance().getController();
                    if(controller.executeTask("Sign_Up" + "-" + login + "-" + password).equals(USER_IS_ADDED)) {
                        response.sendRedirect("/main-page");
                    } else {
                        printWriter.print(LOGIN_EXISTS_JS);
                    }
                } else {
                    printWriter.print(PASSWORDS_DO_NOT_MATCH_JS);
                }
            } else {
                printWriter.print(EMPTY_FIELD_SU_JS);
            }
        }
    }
}
