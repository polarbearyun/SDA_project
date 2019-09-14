package com.shopping_mall.web;

import com.shopping_mall.entity.User;
import com.shopping_mall.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Register User Servlet
 */
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get user data from web page
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");


        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPhone(phone);
        if (password == passwordConfirm)
            newUser.setPassword(password);
        else
            request.setAttribute("add", "Two password are not same!");
        newUser.setType(0);

        //business logic
        UserService userService = new UserService();

        // find whether this email exists in the database
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Judge whether this email exists or not
        if(user != null){

            request.setAttribute("msg", "Register failed! This email has already existed!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }else{

            try {
                userService.createUser(newUser);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // GOTO the login web page
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
