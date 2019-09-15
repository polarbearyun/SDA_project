package com.shopping_mall.web;

import com.shopping_mall.entity.*;
import com.shopping_mall.service.AddressService;
import com.shopping_mall.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/submit_order")
public class SubmitOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String[] idStrs = request.getParameterValues("id");
        String[] amountStrs = request.getParameterValues("amount");

        //
        HttpSession session = request.getSession();
        ProductService service = new ProductService();

        int allAmount = 0;

        Integer total_price = 0;
        ArrayList<Item> items = new ArrayList<Item>();

        int length = idStrs == null ? 0 : idStrs.length;
        for(int i = 0; i < length; i++){
            Integer id = Integer.valueOf(idStrs[i]);
            int amount = Integer.parseInt(amountStrs[i]);
            allAmount += amount;


            Product product = service.findById(id);

            Item item = new Item();
            item.setAmount(amount);
            item.setProduct_id(id);


            int number = amount;
            int item_total_price = product.getPrice().getPrice() * number;
            item.setTotal_price(item_total_price);

            items.add(item);//

            total_price = total_price + item_total_price;


            Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
            cart.put(product, Integer.valueOf(amount));
        }

        Order order = new Order();
        order.setItem(items);

        order.setTotal_price(total_price);
        order.setCreate_time(new Date());

        session.setAttribute("current_order", order);



        User user = (User)session.getAttribute("curr_mbr");
        if(user == null){

            request.setAttribute("msg", "Please Login First!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }else{
            AddressService addressService = new AddressService();
            List<Address> addressList = addressService.viewAllAddressOfUser(user.getId());
            request.setAttribute("addressList", addressList);

            request.getRequestDispatcher("/orderConfirm.jsp").forward(request, response);
        }
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
