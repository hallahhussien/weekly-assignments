package com.controller;

import com.entity.User;
import com.persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "Login",
        urlPatterns = {"/login"}

)

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao userDao = new UserDao();

        User user = userDao.getUserByUserName(request.getUserPrincipal().getName());

        request.getSession().setAttribute("user", user);

        response.sendRedirect("/");

    }

}