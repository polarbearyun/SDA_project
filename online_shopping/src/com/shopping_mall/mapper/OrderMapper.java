package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.entity.Order;
import com.shopping_mall.entity.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderMapper implements DataMapper{

    public void insert(DomainObject obj) {
        assert !(obj instanceof Order) : "obj is not an order object";
        Order order = (Order)obj;

        //Order targetOrder = new Order();
       // IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String createOrder = "INSERT INTO public.t_order"
                + "(id,user_id, total_price, remark, status, order_number)"
                + "VALUES (?,?,?,?,?,?)";


        PreparedStatement stmt = DBConnection.prepare(createOrder);

        try {

            stmt.setInt(1, order.getId());
            stmt.setInt(2, order.getUser_id());
            stmt.setFloat(3, order.getTotal_price());
            stmt.setString(4, order.getRemark());
            stmt.setInt(5, order.getStatus());
            stmt.setString(6, order.getNumber());
            stmt.execute();
            System.out.println(stmt.toString());
            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        }
        //orderIdentityMap.put(order.getId(), order);
    }


    public void update(DomainObject obj) {

        assert !(obj instanceof Order) : "obj is not an order object";
        Order order = (Order)obj;
        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String updateOrder = "UPDATE public.t_order SET status='" + order.getStatus() +
                "' WHERE id='" + order.getId() + "'";
        PreparedStatement stmt = DBConnection.prepare(updateOrder);
        try {
            stmt.execute();
            DBConnection.close(stmt);
        } catch (SQLException e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        }

        orderIdentityMap.put(order.getId(), order);
    }


    public void delete(DomainObject obj) {
        assert !(obj instanceof Order) : "obj is not an order object";
        Order order = (Order)obj;

        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String deleteOrder = "DELETE FROM public.t_order WHERE "
                + "id = '" + order.getId() + "'";

        PreparedStatement stmt = DBConnection.prepare(deleteOrder);
        try {
            stmt.execute();
            DBConnection.close(stmt);
        } catch (Exception e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        }
        orderIdentityMap.put(order.getId(), null);
    }




    /**
     * Find all order by the user id in the database
     */
    public static ArrayList<Order> findOrdersByUserId(int user_id) {

        Order order = null;
        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String findOrdersByUserId = "SELECT * FROM public.t_order where user_id=" + "'" + user_id + "'";

        PreparedStatement stmt = DBConnection.prepare(findOrdersByUserId);
        ArrayList<Order> orderList = new ArrayList<Order>();

        try {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                order = load(rs);
                targetOrder = orderIdentityMap.get(order.getId());
                if (targetOrder == null) {
                    orderList.add(order);
                    orderIdentityMap.put(order.getId(), order);
                } else {
                    orderList.add(targetOrder);
                }
            }
            DBConnection.close(stmt);
            rs.close();

        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }

        //lazy load;
        for(Order oder : orderList){
            oder.reloadItem();
        }
        return orderList;
    }

    public static ArrayList<Order> findAllOrders(){

        Order order = null;
        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);
        String findOrders = "SELECT * FROM public.t_order where status < 5";
        PreparedStatement stmt = DBConnection.prepare(findOrders);
        ArrayList<Order> orderList = new ArrayList<Order>();

        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                order = load(rs);
                targetOrder = orderIdentityMap.get(order.getId());
                if (targetOrder == null) {
                    orderList.add(order);
                    orderIdentityMap.put(order.getId(), order);
                } else {
                    orderList.add(targetOrder);
                }
            }
            DBConnection.close(stmt);
            rs.close();

        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        return orderList;
    }

    public static Order findById(int orderId){

        Order targetOrder = new Order();
        IdentityMap<Order> orderMap = IdentityMap.getInstance(targetOrder);
        targetOrder = orderMap.get(Long.valueOf(orderId));
        if(targetOrder != null){
            return targetOrder;
        }


        String findOrderString ="SELECT * FROM public.t_order WHERE id = " + orderId;
        System.out.println(findOrderString);
        PreparedStatement findAllStatement = DBConnection.prepare(findOrderString);
        Order order = null;

        try {
            ResultSet rs = findAllStatement.executeQuery();
            while(rs.next()) {
                order = load(rs);
            }
            DBConnection.close(findAllStatement);
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return order;
    }


    public static Order load(ResultSet rs) {

        Order order = null;
        try {
            int id = rs.getInt("id");
            int user_id = rs.getInt("user_id");
            String order_number = rs.getString("order_number");
            int total_price  = rs.getInt("total_price");
            Date create_time = rs.getDate("create_time");
            Date payment_time = rs.getDate("payment_time");
            String remark = rs.getString("remark");
            int status = rs.getInt("status");

            order = new Order(id, order_number, user_id, total_price, create_time, payment_time, remark, status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

}
