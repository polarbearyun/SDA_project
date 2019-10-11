package com.shopping_mall.mapper;

import com.shopping_mall.common.*;
import com.shopping_mall.entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressMapper implements DataMapper {

    // Find the address and add one address of a user in the database
    public void insert(DomainObject obj) {
        assert !(obj instanceof Address) : "obj is not a address object";
        Address address = (Address)obj;
        String createAddress = "INSERT INTO public.address "
                + "(address, contact_name, post_code, user_id)"
                + "VALUES (?,?,?,?)";
        PreparedStatement stmt = DBConnection.prepare(createAddress);

        try {
            stmt.setString(1, address.getAddress());
            stmt.setString(2, address.getState());
            stmt.setInt(3, Integer.valueOf(address.getPost_code()));
            stmt.setInt(4, address.getUser().getId());
            stmt.execute();
            System.out.println(stmt.toString());

            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        }
    }


    // Find the address and update one address of a user in the database
    public void update(DomainObject obj)  {

        assert !(obj instanceof Address) : "obj is not a address object";
        Address address = (Address) obj;

        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String updateAddress = "UPDATE address SET public.address='" + address.getAddress() +
                "', + state='" + address.getState() +
                //"', + user_id='" + address.getUser_id() +
                "', + post_code='" + address.getPost_code() +
                "' WHERE id='" + address.getId() + "'";

        PreparedStatement stmt = DBConnection.prepare(updateAddress);

        try {
            stmt.execute();
            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        }
        addressIdentityMap.put(address.getId(), address);
    }


    // Find the address and delete one address of a user in the database
    public void delete(DomainObject obj) {

        assert !(obj instanceof Address) : "obj is not a address object";
        Address address = (Address)obj;

        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String deleteAddress = "DELETE * public.address WHERE "
                + "id = '" + address.getId() + "'";

        PreparedStatement stmt = DBConnection.prepare(deleteAddress);

        try {
            stmt.execute();
            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Database Operation Error!");
            e.printStackTrace();
        }
        addressIdentityMap.put(address.getId(), null);
    }


    /**
     * Find all addresses of a user in the Address table of database
     */
    public static ArrayList<Address> findAddressByUserId(int userId) {

        Address address = null;
        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String findAllAddress = "SELECT * from public.address "
                + "WHERE user_id = " + userId;
        PreparedStatement stmt = DBConnection.prepare(findAllAddress);
        ArrayList<Address> addressList = new ArrayList<Address>();

        try {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                address = load(rs);

                addr = addressIdentityMap.get(address.getId());
                if (addr == null) {
                    addressList.add(address);
                    addressIdentityMap.put(address.getId(), address);
                } else {
                    addressList.add(addr);
                }
            }
            DBConnection.close(stmt);
            rs.close();


        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        return addressList;
    }

    public static Address findAddressById(int addressId){
        Address address = null;
        Address addr = new Address();
        IdentityMap<Address> addressIdentityMap = IdentityMap.getInstance(addr);

        String findAllAddress = "SELECT * from public.address "
                + "WHERE id = " + addressId;
        PreparedStatement stmt = DBConnection.prepare(findAllAddress);
        Address addressRes = new Address();

        try {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                address = load(rs);

                addr = addressIdentityMap.get(address.getId());
                if (addr == null) {
                    addressRes = addr;
                    addressIdentityMap.put(address.getId(), address);
                } else {
                    addressRes = addr;
                }
            }
            DBConnection.close(stmt);
            rs.close();


        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        return addressRes;
    }


    public static Address load(ResultSet rs) {

        Address addr = null;
        try {
            int id = rs.getInt("id");
            int user_id = rs.getInt("user_id");
            String address = rs.getString("address");
            String state = rs.getString("contact_name");
            String post_code = rs.getString("post_code");

            addr = new Address(id,  address, state, post_code);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addr;
    }

}
