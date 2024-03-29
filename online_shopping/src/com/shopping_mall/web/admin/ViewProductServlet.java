package com.shopping_mall.web.admin;

import com.shopping_mall.entity.Product;
import com.shopping_mall.mapper.ProductMapper;
import com.shopping_mall.security.AuthenticationEnforcer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin/product")
public class ViewProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AuthenticationEnforcer.checkAuthentication(request,"viewProduct");

        ProductMapper productMapper = new ProductMapper();
        ArrayList<Product> productList = productMapper.getAllProduct();
        request.setAttribute("products", productList);

        request.getRequestDispatcher("/admin/product_list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

