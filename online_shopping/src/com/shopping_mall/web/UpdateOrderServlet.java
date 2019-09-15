package com.shopping_mall.web;

import com.shopping_mall.entity.Address;
import com.shopping_mall.entity.Order;
import com.shopping_mall.entity.User;
import com.shopping_mall.service.AddressService;
import com.shopping_mall.service.OrderService;
import com.shopping_mall.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/pay")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OrderService orderService;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		String address_id = request.getParameter("address_id");
		String remark = request.getParameter("remark");
		
		
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("current_order");
		
		User user = (User)session.getAttribute("curr_mbr");

		order.setUserId(user.getId());
		order.setRemark(remark);
		
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		order.setNumber(df.format(new Date()));
		order.setStatus(2);
		order.setItemLoaded(true);


		OrderService ordersService = new OrderService();
		ordersService.save(order);

		//clean the cart
		session.removeAttribute("cart");
		
		response.sendRedirect(request.getContextPath() + "/user/orders");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
