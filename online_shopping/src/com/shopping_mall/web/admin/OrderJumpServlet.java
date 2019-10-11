package com.shopping_mall.web.admin;

import com.shopping_mall.entity.Order;
import com.shopping_mall.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/jumpOrder")
public class OrderJumpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("id");
        int id = Integer.parseInt(order_id);

        Order order = new Order();

        OrderService service = new OrderService();
        order = service.findById(id);
        request.setAttribute("order", order);

        request.getRequestDispatcher("/admin/edit_order.jsp").forward(request, response);

    }
}
