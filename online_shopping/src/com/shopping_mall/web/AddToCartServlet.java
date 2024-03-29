package com.shopping_mall.web;

import com.shopping_mall.entity.Product;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService service = new ProductService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idStr = request.getParameter("id");
		String numStr = request.getParameter("num");
		Integer id = Integer.valueOf(idStr);
		Integer num = Integer.valueOf(numStr);

		Product prod = service.findById(id);

		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
		if(cart == null){
			cart = new ConcurrentHashMap<Product, Integer>();
			session.setAttribute("cart", cart);
		}

		Integer oldNum = cart.get(prod);
		if(oldNum != null){
			cart.put(prod, Integer.valueOf(oldNum.intValue() + num.intValue()));
		}else{
			cart.put(prod, num);
		}

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
