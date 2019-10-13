package com.shopping_mall.web.admin;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.Product;
import com.shopping_mall.mapper.ProductMapper;
import com.shopping_mall.security.AuthenticationEnforcer;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(AuthenticationEnforcer.checkAuthentication(request,"deleteProduct")== Params.HAS_RIGHT) {
            String product_id = request.getParameter("id");
            int id = Integer.parseInt(product_id);

            ProductService productService = new ProductService();
            Product product = productService.findById(id);
            product.setInventory(0);

            productService.updateProduct(product);

            response.sendRedirect(request.getContextPath() + "/admin/product");
        }else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('No Right！');</script></body></html>");
            response.getWriter().close();
        }

    }
}
