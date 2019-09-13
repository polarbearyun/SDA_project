package com.shopping_mall.mapper;

import com.shopping_mall.common.*;
import com.shopping_mall.entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressMapper implements DataMapper {

    // Find the address and add one address of a user in the database
    public void insert(DomainObject obj) throws SQLException {
        assert !(obj instanceof Address) : "obj is not a address object";
        Address address = (Address)obj;

        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String createAddress = "INSERT INTO ADDRESS(id,address,state,post_code) VALUES ('"
                + address.getId() + "','"
                + address.getAddress() + "','"
                + address.getState() + "','"
                + address.getPost_code() + "')";

        PreparedStatement createStatement = DBConnection.prepare(createAddress);

        try {
            createStatement.execute();
            System.out.println(createStatement.toString());

        } catch (Exception e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        } finally {
            try{
                if (createStatement != null){
                    createStatement.close();
                }
            } catch (SQLException e){
                System.out.println("Close Error!");
                e.printStackTrace();
            }
        }

        addressIdentityMap.put(address.getId(), address);

    }

    // Find the address and update one address of a user in the database
    public void update(DomainObject obj) throws SQLException {

        assert !(obj instanceof Address) : "obj is not a user object";
        Address address = (Address) obj;

        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String updateAddress = "UPDATE ADDRESS SET address='" + address.getAddress() +
                "', + state='" + address.getState() +
                "', + post_code='" + address.getPost_code() +
                "' WHERE id='" + address.getId() + "'";

        PreparedStatement updateStatement = DBConnection.prepare(updateAddress);

        try {
            updateStatement.execute();

        } catch (Exception e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        } finally {
            try {
                if (updateStatement != null) {
                    updateStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Close Error!");
                e.printStackTrace();
            }
        }

        addressIdentityMap.put(address.getId(), address);
    }


    // Find the address and delete one address of a user in the database
    public void delete(DomainObject obj) throws SQLException {

        assert !(obj instanceof Address) : "obj is not a user object";
        Address address = (Address)obj;

        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String deleteAddress = "DELETE * ADDRESS WHERE "
                + "id = '" + address.getId() + "'";

        PreparedStatement deleteStatement = DBConnection.prepare(deleteAddress);

        try {
            deleteStatement.execute();

        } catch (Exception e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        } finally {
            try{
                if (deleteStatement != null){
                    deleteStatement.close();
                }
            } catch (SQLException e){
                System.out.println("Close Error!");
                e.printStackTrace();
            }
        }

        addressIdentityMap.put(address.getId(), null);
    }


    /**
     * Find all addresses of a user in the Address table of database
     */
    public static ArrayList<Address> findAllAddress(int userId) throws SQLException {
        Address addr = new Address();
        ResultSet rs = null;
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String findAllAddress = "SELECT * ADDRESS "
                + "WHERE user_id = " + userId;
        PreparedStatement findAllStatement = DBConnection.prepare(findAllAddress);
        ArrayList<Address> addressList = new ArrayList<Address>();

        try {
            rs = findAllStatement.executeQuery();

            while(rs.next()) {
                Address address = loadUser(rs);
                addr = addressIdentityMap.get(address.getUser_id());
                if (addr == null) {
                    addressList.add(address);
                    addressIdentityMap.put(address.getUser_id(), address);
                } else {
                    addressList.add(addr);
                }
            }
            return addressList;

        } catch (Exception e) {
            System.out.println("Exception!");
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Close Error!");//
                ex.printStackTrace();
            }
        }
        return addressList;
    }


}
