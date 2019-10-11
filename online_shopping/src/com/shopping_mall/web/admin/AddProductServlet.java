package com.shopping_mall.web.admin;

import com.shopping_mall.entity.Price;
import com.shopping_mall.entity.Product;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addProduct")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get user data from web page
        String name = request.getParameter("name");
        String picture = request.getParameter("picture");
        Integer inventory = Integer.valueOf(request.getParameter("inventory"));
        Integer price = Integer.valueOf(request.getParameter("price"));
        String detail = request.getParameter("detail");

        Price newPrice = new Price(price);


        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPicture(picture);
        newProduct.setInventory(inventory);
        newProduct.setPrice(newPrice);
        newProduct.setDetail(detail);
        newProduct.setSold_number(0);



        //business logic
        ProductService productService = new ProductService();
        try {
            productService.createProduct(newProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/admin/product");

    }
}
