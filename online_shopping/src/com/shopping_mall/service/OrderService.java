package com.shopping_mall.service;

import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.common.UnitOfWork;
import com.shopping_mall.entity.Item;
import com.shopping_mall.entity.Order;
import com.shopping_mall.mapper.ItemMapper;
import com.shopping_mall.mapper.OrderMapper;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private OrderMapper orderMapper;
    private ItemMapper itemMapper;
    private ItemService itemService;
    private UnitOfWork unitOfWork;

    public OrderService(){
        orderMapper = new OrderMapper();
        itemMapper = new ItemMapper();
        itemService = new ItemService();
        unitOfWork = new UnitOfWork();

    }

    public void save(Order order){
        int orderId = getNextOrderId();
        order.setId(orderId);
        orderMapper.insert(order);
        //批量添加订单项


        List<Item> items = order.getItem();
        for(Item item : items){
            item.setOrder_id(orderId);
            unitOfWork.registerNew(item);
            //itemMapper.insert(item);
        }
        unitOfWork.commit();
    }

    public void updateOrder(Order order) {


        unitOfWork.registerDirty(order);
        unitOfWork.commit();

    }

    public void deleteOrder(Order order) {

        unitOfWork.registerDeleted(order);
        unitOfWork.commit();

    }


    /**
     * View all relevant orders of a user in the database
     */
    public ArrayList<Order> viewAllOrderOfUser(int userId){
        ArrayList<Order> orderList = OrderMapper.findOrdersByUserId(userId);
        return orderList;
    }

    public Order findById(int orderId){

            return OrderMapper.findById(orderId);
    }


    private int getNextOrderId() {
        ArrayList<Order> list = OrderMapper.findAllOrders();

        int index = list.size();

        int orderId = index +1;


        return orderId;
    }

}
