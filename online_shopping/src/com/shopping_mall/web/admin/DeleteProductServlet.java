package com.shopping_mall.web.admin;

import com.shopping_mall.entity.Product;
import com.shopping_mall.mapper.ProductMapper;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteProductByAdmin")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id");
        int id = Integer.parseInt(product_id);

        Product product = new Product();
        product.setId(id);

        ProductService productService = new ProductService();
        productService.deleteProduct(product);

    }
}
