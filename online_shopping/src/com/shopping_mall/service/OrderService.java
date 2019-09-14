package com.shopping_mall.service;

import com.shopping_mall.common.UnitOfWork;
import com.shopping_mall.entity.Order;
import com.shopping_mall.mapper.OrderMapper;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderService {

    private OrderMapper orderMapper;

    public OrderService(){
        orderMapper = new OrderMapper();

    }

    public void createOrder(Order order) throws Exception {

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerNew(order);
        UnitOfWork.getCurrent().commit();

    }

    public void updateOrder(Order order) throws Exception {

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(order);
        UnitOfWork.getCurrent().commit();

    }

    public void deleteOrder(Order order) throws Exception {

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDeleted(order);
        UnitOfWork.getCurrent().commit();

    }


    /**
     * View all relevant orders of a user in the database
     */
    public ArrayList<Order> viewAllOrderOfUser(int userId) throws SQLException {
        ArrayList<Order> orderList = OrderMapper.findOrdersByUserId(userId);
        return orderList;
    }
}
