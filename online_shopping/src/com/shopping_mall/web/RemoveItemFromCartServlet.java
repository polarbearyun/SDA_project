package com.shopping_mall.web;

import com.shopping_mall.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/removeItem")
public class RemoveItemFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Integer id = Integer.valueOf(idStr);

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
        if(cart != null){

            Product temp = null;
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                if(entry.getKey().getId().equals(id)){
                    temp = entry.getKey();
                    break;
                }
            }

            if(temp != null){
                cart.remove(temp);
            }
        }

        request.getRequestDispatcher("/cart.jsp").forward(request, response);
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
