package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ItemMapper implements DataMapper {

    public void insert(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Item) : "obj is not a item object";
        Item item = (Item) obj;

        //Item targetItem = new Item();
        //IdentityMap<Item> itemMap = IdentityMap.getInstance(targetItem);

        String createItemString = "INSERT INTO item" + "( order_id, product_id, amount, total_price)" +"VALUES ( ?, ?, ?, ?)";
        PreparedStatement createStatement = DBConnection.prepare(createItemString);

        try {
            //createStatement.setInt(1, item.getId());
            createStatement.setInt(1, item.getOrder_id());
            createStatement.setInt(2, item.getProduct_id());
            createStatement.setInt(3, item.getAmount());
            createStatement.setFloat(4, item.getTotal_price());
            createStatement.execute();
            System.out.println(createStatement.toString());

            DBConnection.close(createStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //itemMap.put(item.getId(), item);
    }


    public void update(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Item) : "obj is not a item object";

    }


    public void delete(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Item) : "obj is not a item object";
        Item item = (Item) obj;

        Item targetItem = new Item();
        IdentityMap<Item> orderMap = IdentityMap.getInstance(targetItem);

        String deleteOrderString = "DELETE FROM item"
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

    public static ArrayList<Item> findAddressByUserId(int order_id){
        Item item = null;
        Item targetItem = new Item();
        IdentityMap<Item> itemIdentityMap = IdentityMap.getInstance(targetItem);

        String findOrdersByUserId = "SELECT * FROM item where order_id=" + "'" + order_id + "'";

        PreparedStatement stmt = DBConnection.prepare(findOrdersByUserId);
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                item = load(rs);
                targetItem = itemIdentityMap.get(item.getId());
                if (targetItem == null) {
                    itemList.add(item);
                    itemIdentityMap.put(item.getId(), item);
                } else {
                    itemList.add(targetItem);
                }
            }
            DBConnection.close(stmt);
            rs.close();
        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        return itemList;
    }

    public static Item load(ResultSet rs) {
        Item item = null;
        try {
            int itemId = rs.getInt("id");
            int amount = rs.getInt("amount");
            int order = rs.getInt("order_id");
            int product  = rs.getInt("product_id");
            int total_price = rs.getInt("total_price");
            item = new Item(itemId, amount, order, product, total_price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
