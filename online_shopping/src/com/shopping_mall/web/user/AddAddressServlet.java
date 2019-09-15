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
        //获取请求的参数数据
        String state = request.getParameter("contact_name");
        String detail_address = request.getParameter("address");
        String post_code = request.getParameter("post_code");


        //把散装数据封装成对象
        Address address = new Address();
        address.setAddress(detail_address);
        address.setPost_code(post_code);
        address.setState(state);


        //设置这个要新增的地址所属的会员ID
        User user = (User)request.getSession().getAttribute("curr_mbr");
        address.setUser(user);

        //业务逻辑处理
        AddressService service = new AddressService();
        service.createAddress(address); //保存新增的地址,address的ID就有值了


        //跳转(重定向)
        //理解：Servlet中的两种跳转方式：重定向、请求分派

        User mbr = (User) request.getSession().getAttribute("curr_mbr");
        List<Address> list = service.viewAllAddressOfUser(mbr.getId());

        request.setAttribute("addressList", list);
        //response.sendRedirect(request.getContextPath() + "/orders.jsp");
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
