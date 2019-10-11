package com.shopping_mall.web.admin;

import com.shopping_mall.entity.Order;
import com.shopping_mall.mapper.OrderMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin/order_list")
public class ViewOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //OrderMapper orderMapper = new OrderMapper();
        ArrayList<Order> orderList = OrderMapper.findAllOrders();
        request.setAttribute("orders", orderList);

        request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
    }
}
