package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.entity.Product;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Product> getAllProduct(){
        String findAllProductString = "SELECT * FROM public.product";
        PreparedStatement findAllStatement = DBConnection.prepare(findAllProductString);
        ArrayList<Product> productList = new ArrayList<>();

        Product targetProduct = new Product();
        IdentityMap<Product> productMap = IdentityMap.getInstance(targetProduct);

        try {
            ResultSet rs = findAllStatement.executeQuery();

            while(rs.next()) {
                Product product = loadProduct(rs);

                targetProduct = productMap.get(product.getId());
                if(targetProduct == null) {
                    productMap.put(product.getId(), product);
                    productList.add(product);
                } else {
                    productList.add(targetProduct);
                }

            }
            DBConnection.close(findAllStatement);
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    public static Product findById(int productId){

        Product targetProduct = new Product();
        IdentityMap<Product> productMap = IdentityMap.getInstance(targetProduct);
        targetProduct = productMap.get(Long.valueOf(productId));
        if(targetProduct != null){
            return targetProduct;
        }


        String findProductString ="SELECT * FROM product WHERE id = " + productId;
        System.out.println(findProductString);
        PreparedStatement findAllStatement = DBConnection.prepare(findProductString);
        Product product = null;

        try {
            ResultSet rs = findAllStatement.executeQuery();
            while(rs.next()) {
                product = loadProduct(rs);
            }
            DBConnection.close(findAllStatement);
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return product;
    }


    public static Product loadProduct(ResultSet rs) {

        Product product = null;

        try {

            int productId = rs.getInt("id");
            String name = rs.getString("name");
            String picture = rs.getString("picture");
            Integer inventory = Integer.valueOf(rs.getString("inventory"));
            Integer sold_number = Integer.valueOf(rs.getString("sold_number"));
            Integer price =  Integer.valueOf(rs.getString("price"));
            String detail =  rs.getString("detail");

            product = new Product(productId, name, picture, inventory, sold_number, price, detail);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return product;
    }

}
