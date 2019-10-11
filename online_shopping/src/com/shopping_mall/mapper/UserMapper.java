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

    public void insert(DomainObject obj)  {
        assert !(obj instanceof User) : "obj is not a user object";
        User user = (User)obj;

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String createUser = "INSERT INTO public.member "
                + "(email, name, password, type, phone)"
                + " VALUES (?,?,?,?,?)";

        PreparedStatement stmt = DBConnection.prepare(createUser);

        try {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getType());
            stmt.setString(5, user.getPhone());
            stmt.execute();
            System.out.println(stmt.toString());

            DBConnection.close(stmt);

        } catch (SQLException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        userIdentityMap.put(user.getId(), user);

    }


    public void update(DomainObject obj) {

        assert !(obj instanceof User) : "obj is not a user object";
        User user = (User)obj;

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);


        String updateUserString = "UPDATE public.member SET "+
                "email=?, name=?, password=?, type=?, phone=?  WHERE id =" + user.getId();
        PreparedStatement updateStatement = DBConnection.prepare(updateUserString);

        try {
            updateStatement.setString(1,user.getEmail());
            updateStatement.setString(2,user.getName());
            updateStatement.setString(3,user.getPassword());
            updateStatement.setInt(4,user.getType());
            updateStatement.setString(5,user.getPhone());
            updateStatement.execute();
            System.out.println(updateStatement.toString());

            DBConnection.close(updateStatement);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        userIdentityMap.put(user.getId(), user);


    }


    public void delete(DomainObject obj)  {

        assert !(obj instanceof User) : "obj is not a user object";
        User user = (User)obj;

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String deleteUser = "DELETE * public.member WHERE "
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
    public static User findUserByName(String username) {

        User user = null;
        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findUserByName = "SELECT * FROM public.member "
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
    public static User findUserByEmail(String email) {

        User user = null;
        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findUserByEmail = "SELECT * FROM public.member "
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
     * Find a user by the user's email
     */
    public static User findUserById(int id) {

        User user = null;
        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findUserById = "SELECT * FROM public.member "
                + "WHERE id = '" + id + "'";

        PreparedStatement stmt = DBConnection.prepare(findUserById);

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
    public static ArrayList<User> findAllUsers() {

        User targetUser = new User();
        IdentityMap<User> userIdentityMap = IdentityMap.getInstance(targetUser);

        String findAllUsers = "SELECT * FROM public.member";
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
