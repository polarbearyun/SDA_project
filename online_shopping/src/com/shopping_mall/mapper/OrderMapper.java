package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.entity.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderMapper implements DataMapper{

    public void insert(DomainObject obj) {
        assert !(obj instanceof Order) : "obj is not an order object";
        Order order = (Order)obj;

        Order targetOrder = new Order();
       // IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String createOrder = "INSERT INTO t_order"
                + "(id,user_id, total_price, remark, status, order_number)"
                + "VALUES (?,?,?,?,?,?)";


        PreparedStatement stmt = DBConnection.prepare(createOrder);

        try {

            stmt.setInt(1, order.getId());
            stmt.setInt(2, order.getUserId());

            stmt.setFloat(3, order.getTotal_price());
//            stmt.setDate(4, (Date) order.getCreate_time());
//            stmt.setDate(5, (Date) order.getPayment_time());
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


    public void update(DomainObject obj) throws SQLException {

        assert !(obj instanceof Order) : "obj is not an order object";
        Order order = (Order)obj;

        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String updateOrder = "UPDATE SHOP.ORDER SET status='" + order.getStatus() +
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


    public void delete(DomainObject obj) throws SQLException {

        assert !(obj instanceof Order) : "obj is not an order object";
        Order order = (Order)obj;

        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String deleteOrder = "DELETE * SHOP.ORDER WHERE "
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


//    /**
//     * Find a user by the user name
//     */
//    public static Order findOrderByName(String username) throws SQLException {
//
//        ResultSet rs = null;
//        Order targetOrder = new Order();
//        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);
//
//        String findOrderByName = "SELECT p.name FROM ORDER as m,USER as p where m.user_id=p.id and p.name=" + username;
//
//        PreparedStatement findOrderByNameStatement = DBConnection.prepare(findOrderByName);
//
//        try {
//            rs = findOrderByNameStatement.executeQuery();
//            Order order = new Order();
//            while(rs.next()) {
//                order.setId(rs.getInt("id"));
//                order.setEmail(rs.getString("email"));
//                order.setName(rs.getString("name"));
//                order.setPhone(rs.getInt("phone"));
//                order.setPassword(rs.getString("password"));
//                order.setType(rs.getInt("type"));
//                break;
//            }
//            if(user != null) {
//                targetUser = userIdentityMap.get(user.getId());
//                if(targetUser == null) {
//                    userIdentityMap.put(user.getId(), user);
//                    return user;
//                }
//                else
//                    return targetUser;
//            }
//
//            return user;
//
//        } catch (Exception e) {
//            System.out.println("Exception!");
//            e.printStackTrace();
//            return null;
//        }finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("Close Error!");//
//                ex.printStackTrace();
//            }
//        }
//    }



    /**
     * Find all order by the user id in the database
     */
    public static ArrayList<Order> findOrdersByUserId(int user_id) {

        Order order = null;
        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String findOrdersByUserId = "SELECT * FROM t_order where user_id=" + "'" + user_id + "'";

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

        for(Order oder : orderList){
            oder.reloadItem();
        }

        return orderList;
    }

    public static ArrayList<Order> findAllOrders(){

        Order order = null;
        Order targetOrder = new Order();
        IdentityMap<Order> orderIdentityMap = IdentityMap.getInstance(targetOrder);

        String findOrders = "SELECT * FROM t_order";

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
