package com.shopping_mall.web.admin;

import com.shopping_mall.datatransfer.UserAssembler;
import com.shopping_mall.datatransfer.UserDTO;
import com.shopping_mall.datatransfer.UserFacade;
import com.shopping_mall.entity.Address;
import com.shopping_mall.entity.User;
import com.shopping_mall.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/editUser")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String addr_detail = request.getParameter("address");
        String state = request.getParameter("state");
        String post_code = request.getParameter("post_code");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setType(0);

        Address address = new Address();
        address.setAddress(addr_detail);
        address.setState(state);
        address.setPost_code(post_code);
        user.setAddress(address);

        UserDTO dto = UserAssembler.createUserDTO(user);

        String userStr = UserDTO.serialize(dto);

        UserFacade facade = new UserFacade();
        facade.updateUserJSON(userStr);

        //UserService userService = new UserService();
        //userService.updateUser(user);

        response.sendRedirect(request.getContextPath() + "/admin/user_list");

    }
}
