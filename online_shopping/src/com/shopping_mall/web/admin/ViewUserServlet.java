package com.shopping_mall.web.admin;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.User;
import com.shopping_mall.mapper.UserMapper;
import com.shopping_mall.security.AuthenticationEnforcer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin/user_list")
public class ViewUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(AuthenticationEnforcer.checkAuthentication(request,"viewAllUsers") == Params.HAS_RIGHT) {

            //UserMapper userMapper = new UserMapper();
            ArrayList<User> userList = UserMapper.findAllUsers();
            request.setAttribute("users", userList);

            request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
        }else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('No Right！');</script></body></html>");
            response.getWriter().close();
        }

    }
}
