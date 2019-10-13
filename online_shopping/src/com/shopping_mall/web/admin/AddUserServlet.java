package com.shopping_mall.web.admin;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.User;
import com.shopping_mall.security.AuthenticationEnforcer;
import com.shopping_mall.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(AuthenticationEnforcer.checkAuthentication(request,"addUser") == Params.HAS_RIGHT) {

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
            newUser.setPassword(password);

            // only one admin role, so admin only ba able to add the new normal user
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
            if (user != null) {
                request.setAttribute("msg", "Add new user failed! This email has already existed!");
                request.getRequestDispatcher("/admin/add_user").forward(request, response);
            } else {

                try {
                    userService.createUser(newUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // GOTO the user management web page
                response.sendRedirect(request.getContextPath() + "/admin/user_list");
            }
        }else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('No Right！');</script></body></html>");
            response.getWriter().close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
