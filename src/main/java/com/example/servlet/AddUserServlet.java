package com.example.servlet;


import com.example.User;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import static com.example.Warehouse.getInstance;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    //write your code here!
    public AddUserServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User(firstName, lastName);
        getInstance().addUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add.jsp");
        dispatcher.forward(request, response);
    }

}
