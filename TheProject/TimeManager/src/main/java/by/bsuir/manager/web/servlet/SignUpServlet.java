package by.bsuir.manager.web.servlet;

import by.bsuir.manager.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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


        if(login != null && password.equals(secondPassword)) {
            Controller controller = new Controller();
            String command = "Sign_Up" + "-" + login + "-" + password;
            controller.executeTask(command);
        }
    }
}
