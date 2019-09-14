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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/submit_order")
public class submitOrderServlet extends HttpServlet {
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
        List<Item> items = new ArrayList<Item>();

        int length = idStrs == null ? 0 : idStrs.length;
        for(int i = 0; i < length; i++){
            Integer id = Integer.valueOf(idStrs[i]);
            int amount = Integer.parseInt(amountStrs[i]);
            allAmount += amount; //计算购物的总数量

            //效率有点低
            Product product = service.findById(id);

            //把购物车中的每个商品都转换成一个订单项对象
            Item item = new Item();
            item.setAmount(amount);
            item.setProduct(product);


            int number = amount;
            int item_total_price = product.getPrice()*number;
            item.setTotal_price(item_total_price);

            items.add(item);//

            total_price = total_price + item_total_price; //计算总金额

            //改购物车中的相应商品的数量
            @SuppressWarnings("unchecked")
            Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
            cart.put(product, Integer.valueOf(amount));
        }

        //订单实体类
        Order order = new Order();
        //order.setItems(items); //订单的每个订单项
        //order.setTotal_amount(allAmount); //订单的总物品数量
        order.setTotal_price(total_price);//订单的总金额
       // order.setPayment_price(allPaymentPrice); //订单的实际支付金额
        order.setCreate_time(new Date());

        //把当前订单数据存储到session中
        session.setAttribute("curr_order", order);



        //判断用户有没有登录
        User user = (User)session.getAttribute("curr_mbr");
        if(user == null){ //没有登录，就跳转到登录页面

            request.setAttribute("msg", "提交订单前,请先登录!");
            request.getRequestDispatcher("/member_login.jsp").forward(request, response);

        }else{//登录后的，跳转结算页面
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
