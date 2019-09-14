package com.shopping_mall.web.user;

import com.shopping_mall.entity.Address;
import com.shopping_mall.entity.User;
import com.shopping_mall.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/address/list")
public class AddressListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        User mbr = (User) request.getSession().getAttribute("curr_mbr");


        //
        AddressService service = new AddressService();
        List<Address> list = service.viewAllAddressOfUser(mbr.getId());

        //
        request.setAttribute("list", list);
        request.getRequestDispatcher("/user/address.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
