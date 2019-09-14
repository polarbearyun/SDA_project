package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.entity.Item;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemMapper implements DataMapper {

    @Override
    public void insert(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Item) : "obj is not a item object";
        Item item = (Item) obj;

        Item targetItem = new Item();
        IdentityMap<Item> itemMap = IdentityMap.getInstance(targetItem);

        String createItemString = "INSERT INTO public.item"+"(id, order_id, product_id, amount, total_price)" +"VALUES (?, ?, ?, ?, ?)";
        PreparedStatement createStatement = DBConnection.prepare(createItemString);

        try {
            createStatement.setInt(1, item.getId());
            createStatement.setInt(2, item.getOrderId());
            createStatement.setInt(3, item.getProductId());
            createStatement.setInt(4, item.getAmount());
            createStatement.setFloat(5, item.getTotal_price());
            createStatement.execute();
            System.out.println(createStatement.toString());

            DBConnection.close(createStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        itemMap.put(item.getId(), item);
    }

    @Override
    public void update(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Item) : "obj is not a item object";
//        Item item = (Item) obj;
//
//        Item targetItem = new Item();
//        IdentityMap<Item> itemMap = IdentityMap.getInstance(targetItem);
//
//        String updateOrderString = "UPDATE ITEM SET AMOUNT = ? "
//                + "WHERE ORDERID = " + item.getOrderId();
//
//        PreparedStatement updateStatement = DBConnection.prepare(updateOrderString);
//
//        try {
//            updateStatement.setInt(1, item.getId());
//            updateStatement.execute();
//            System.out.println(updateStatement.toString());
//
//            DBConnection.close(updateStatement);
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        itemMap.put(item.getId(), item);
    }

    @Override
    public void delete(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Item) : "obj is not a item object";
        Item item = (Item) obj;

        Item targetItem = new Item();
        IdentityMap<Item> orderMap = IdentityMap.getInstance(targetItem);

        String deleteOrderString = "DELETE FROM public.item"
                + "WHERE id = " + item.getId();

        PreparedStatement deleteStatement = DBConnection.prepare(deleteOrderString);

        try {
            deleteStatement.execute();
            System.out.println(deleteStatement.toString());

            DBConnection.close(deleteStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        orderMap.put(item.getId(), null);

    }




}
