package com.shopping_mall.web.user;

import com.shopping_mall.entity.Order;
import com.shopping_mall.entity.User;
import com.shopping_mall.security.AuthenticationEnforcer;
import com.shopping_mall.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/user/orders")
public class ViewOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 2964566478709855605L;
	private OrderService ordersService = new OrderService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.err.println("========2========"+ AuthenticationEnforcer.checkAuthentication(req,"test"));

		int number = 1;
		int size = 10;
		String n = req.getParameter("number");
		if(n != null && !"".equals(n)){
			number = Integer.parseInt(n);
		}
		if(number < 1){
			number = 1;
		}
		String s = req.getParameter("size");
		if(s != null && !"".equals(s)){
			size = Integer.parseInt(s);
		}
		if(size <= 0){
			size = 10;
		}
		
		User user = (User)req.getSession().getAttribute("curr_mbr");
		
		ArrayList<Order> list = ordersService.viewAllOrderOfUser(user.getId());
		req.setAttribute("page", list);
		req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
	}
}
