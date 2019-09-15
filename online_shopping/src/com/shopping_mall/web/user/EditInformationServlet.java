package com.shopping_mall.web.user;


import com.shopping_mall.entity.User;
import com.shopping_mall.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/edit")
public class EditInformationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //System.out.println("进来了");
        //step1: 获取请求中的参数数据
        String name = request.getParameter("name");
        //String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //String type = request.getParameter("type");


        //step2: 处理业务逻辑
        User user = (User)request.getSession().getAttribute("curr_mbr");
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);


        UserService service = new UserService();
        service.updateUser(user);

        //step3: 响应文本
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("ok");
        out.flush();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
