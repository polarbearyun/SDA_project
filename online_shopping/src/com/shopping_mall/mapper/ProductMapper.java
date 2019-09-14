package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.entity.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductMapper implements DataMapper {

    @Override
    public void insert(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Product) : "obj is not a product object";
        Product product = (Product) obj;

        Product targetProduct = new Product();
        IdentityMap<Product> productMap = IdentityMap.getInstance(targetProduct);

        String createItemString = "INSERT INTO public.product"
                + "(id, name, picture, inventory, sold_number, price, detail)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement createStatement = DBConnection.prepare(createItemString);

        try {
            createStatement.setInt(1, product.getId());
            createStatement.setString(2, product.getName());
            createStatement.setString(3, product.getPicture());
            createStatement.setInt(4, product.getInventory());
            createStatement.setInt(5, product.getSold_number());
            createStatement.setFloat(6, product.getPrice());
            createStatement.setString(7, product.getDetail());
            createStatement.execute();
            System.out.println(createStatement.toString());

            DBConnection.close(createStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Product) : "obj is not a product object";
        Product product = (Product) obj;

        Product targetProduct = new Product();
        IdentityMap<Product> productMap = IdentityMap.getInstance(targetProduct);

        String updateOrderString = "UPDATE public.product SET name=?, picture=?, inventory=?, sold_number=?, price=?, detail=?"
                + "WHERE id = " + product.getId();

        PreparedStatement updateStatement = DBConnection.prepare(updateOrderString);

        try {
            updateStatement.setString(1, product.getName());
            updateStatement.setString(2, product.getPicture());
            updateStatement.setInt(3, product.getInventory());
            updateStatement.setInt(4, product.getSold_number());
            updateStatement.setFloat(5, product.getPrice());
            updateStatement.setString(6, product.getDetail());

            updateStatement.execute();
            System.out.println(updateStatement.toString());

            DBConnection.close(updateStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(DomainObject obj) {
        // TODO Auto-generated method stub
        assert !(obj instanceof Product) : "obj is not a product object";
        Product product = (Product) obj;

        Product targetProduct = new Product();
        IdentityMap<Product> productMap = IdentityMap.getInstance(targetProduct);

        String deleteOrderString = "DELETE FROM public.product"
                + "WHERE id = " + product.getId();

        PreparedStatement deleteStatement = DBConnection.prepare(deleteOrderString);

        try {
            deleteStatement.execute();
            System.out.println(deleteStatement.toString());

            DBConnection.close(deleteStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        productMap.put(product.getId(), null);

    }

}
