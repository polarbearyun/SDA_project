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


@WebServlet("/user/address/add")
public class AddAddressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String state = request.getParameter("contact_name");
        String detail_address = request.getParameter("address");
        String post_code = request.getParameter("post_code");

        Address address = new Address();
        address.setAddress(detail_address);
        address.setPost_code(post_code);
        address.setState(state);

        User user = (User)request.getSession().getAttribute("curr_mbr");
        address.setUser(user);

        AddressService service = new AddressService();
        service.createAddress(address);

        User mbr = (User) request.getSession().getAttribute("curr_mbr");
        List<Address> list = service.viewAllAddressOfUser(mbr.getId());

        request.setAttribute("addressList", list);
        request.getRequestDispatcher("/orderConfirm.jsp").forward(request, response);
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
