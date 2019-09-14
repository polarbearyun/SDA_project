package com.shopping_mall.service;

import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.common.UnitOfWork;
import com.shopping_mall.entity.Item;
import com.shopping_mall.entity.Order;
import com.shopping_mall.mapper.ItemMapper;
import com.shopping_mall.mapper.OrderMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderService {

    private OrderMapper orderMapper;
    private ItemMapper itemMapper;

    public OrderService(){
        orderMapper = new OrderMapper();
        itemMapper = new ItemMapper();

    }

    public void save(Order order){
        int orderId = getNextOrderId();
        order.setId(orderId);
        orderMapper.insert(order);
        //批量添加订单项
        List<Item> items = order.getItem();
        for(Item item : items){
            item.setOrder_id(orderId);
            itemMapper.insert(item);
        }
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
    public ArrayList<Order> viewAllOrderOfUser(int userId){
        ArrayList<Order> orderList = OrderMapper.findOrdersByUserId(userId);
        return orderList;
    }


    private int getNextOrderId() {
        ArrayList<Order> list = OrderMapper.findAllOrders();

        int index = list.size();

        int orderId = index +1;


        return orderId;
    }

}
