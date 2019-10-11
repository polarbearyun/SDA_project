package com.shopping_mall.web.admin;

import com.shopping_mall.entity.User;
import com.shopping_mall.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("admin/userInfoJump")
public class JumpUserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("id");
        int id = Integer.parseInt(user_id);


        UserService userService = new UserService();
        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("user", user);

        request.getRequestDispatcher("/admin/edit_user.jsp").forward(request, response);

    }
}
