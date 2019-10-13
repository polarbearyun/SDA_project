package com.shopping_mall.web.admin;

import com.shopping_mall.common.Params;
import com.shopping_mall.entity.Price;
import com.shopping_mall.entity.Product;
import com.shopping_mall.mapper.LockingMapper;
import com.shopping_mall.mapper.ProductMapper;
import com.shopping_mall.security.AuthenticationEnforcer;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/editProduct")
public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(AuthenticationEnforcer.checkAuthentication(request,"editProduct")== Params.HAS_RIGHT) {

            Integer id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String picture = request.getParameter("picture");
            Integer inventory = Integer.valueOf(request.getParameter("inventory"));
            Integer price = Integer.valueOf(request.getParameter("price"));
            String detail = request.getParameter("detail");


            Price newPrice = new Price(price);


            Product newProduct = new Product();
            newProduct.setId(id);
            newProduct.setName(name);
            newProduct.setPicture(picture);
            newProduct.setInventory(inventory);
            newProduct.setPrice(newPrice);
            newProduct.setDetail(detail);


            ProductMapper mapper = new ProductMapper();
            LockingMapper lockingMappermapper = new LockingMapper(mapper);
            lockingMappermapper.update(newProduct);


            //ProductService service = new ProductService();
            //service.updateProduct(newProduct);

            response.sendRedirect(request.getContextPath() + "/admin/product");
        }else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('No Right！');</script></body></html>");
            response.getWriter().close();
        }
    }
}
