package by.bsuir.manager.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class TestDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class. forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter printWriter = response.getWriter();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/time_manager_db",
                    "postgres", "09102014Qm");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login from users");

            while(resultSet.next()) {
                printWriter.print(resultSet.getString("login"));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
