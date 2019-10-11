package com.shopping_mall.web.admin;


import com.shopping_mall.entity.Product;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/jumpProduct")
public class ProductJumpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("id");
        int id = Integer.parseInt(product_id);

        Product product = new Product();

        ProductService productService = new ProductService();
        product = productService.findById(id);
        request.setAttribute("product", product);

        request.getRequestDispatcher("/admin/edit_product.jsp").forward(request, response);

    }
}