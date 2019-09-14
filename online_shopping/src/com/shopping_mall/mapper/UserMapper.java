package com.shopping_mall.mapper;

import com.shopping_mall.common.DBConnection;
import com.shopping_mall.common.IdentityMap;
import com.shopping_mall.entity.User;
import com.shopping_mall.entity.DomainObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper implements DataMapper{

    public void insert(DomainObject obj) throws SQLException {
        assert !(obj instanceof User) : "obj is not a user object";
        User user = (User)obj;

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String createUser = "INSERT INTO USER "
                + "(id,email,name,phone,password,type)"
                + "VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = DBConnection.prepare(createUser);

        try {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getPassword());
            stmt.setInt(6, user.getType());
            stmt.execute();
            System.out.println(stmt.toString());

            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        userIdentityMap.put(user.getId(), user);

    }


    public void update(DomainObject obj) throws SQLException {

        assert !(obj instanceof User) : "obj is not a user object";
        User user = (User)obj;

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String updateUser = "UPDATE USER SET email='" + user.getEmail() +
                "', + name='" + user.getName() +
                "', + phone='" + user.getPhone() +
                "', + password='" + user.getPassword() +
                "', + type='" + user.getType() +
                "' WHERE id='" + user.getId() + "'";

        PreparedStatement stmt = DBConnection.prepare(updateUser);

        try {
            stmt.execute();
            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        userIdentityMap.put(user.getId(), user);
    }


    public void delete(DomainObject obj) throws SQLException {

        assert !(obj instanceof User) : "obj is not a user object";
        User user = (User)obj;

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String deleteUser = "DELETE * USER WHERE "
                + "id = '" + user.getId() + "'";

        PreparedStatement stmt = DBConnection.prepare(deleteUser);

        try {
            stmt.execute();
            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        userIdentityMap.put(user.getId(), null);
    }


    /**
     * Find a user by the user name
     */
    public static User findUserByName(String username) throws SQLException {

        User user = null;
        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findUserByName = "SELECT * FROM USER "
                + "WHERE name = '" + username + "'";

        PreparedStatement stmt = DBConnection.prepare(findUserByName);

        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                user = load(rs);
            }
            DBConnection.close(stmt);
            rs.close();
        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        if(user != null) {
            targetUser = userIdentityMap.get(user.getId());
            if(targetUser == null) {
                userIdentityMap.put(user.getId(), user);
                return user;
            }
            else
                return targetUser;
        }

        return user;
    }


    /**
     * Find a user by the user's email
     */
    public static User findUserByEmail(String email) throws SQLException {

        User user = null;
        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findUserByEmail = "SELECT * FROM USER "
                + "WHERE email = '" + email + "'";

        PreparedStatement stmt = DBConnection.prepare(findUserByEmail);

        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                user = load(rs);
            }
            DBConnection.close(stmt);
            rs.close();

        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        if(user != null) {
            targetUser = userIdentityMap.get(user.getId());
            if(targetUser == null) {
                userIdentityMap.put(user.getId(), user);
                return user;
            }
            else
                return targetUser;
        }
        return user;
    }


    /**
     * Find all users in the database
     */
    public static ArrayList<User> findAllUsers() throws SQLException {

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findAllUsers = "SELECT * FROM USER";
        PreparedStatement stmt = DBConnection.prepare(findAllUsers);
        ArrayList<User> userList = new ArrayList<User>();

        try {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                User user = load(rs);

                targetUser = userIdentityMap.get(user.getId());
                if (targetUser == null) {
                    userList.add(user);
                    userIdentityMap.put(user.getId(), user);
                } else {
                    userList.add(targetUser);
                }
            }
            DBConnection.close(stmt);
            rs.close();

        } catch (SQLException e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }
        return userList;
    }

    public static User load(ResultSet rs) {

        User user = null;
        try {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String password = rs.getString("password");
            int type = rs.getInt("type");

            user = new User(id, email, name, phone, password,type);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


}
