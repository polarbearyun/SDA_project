package com.shopping_mall.service;


import com.shopping_mall.common.UnitOfWork;
import com.shopping_mall.entity.User;
import com.shopping_mall.mapper.UserMapper;

import java.sql.SQLException;
import java.util.ArrayList;


public class UserService {

    private UserMapper userMapper;

    public UserService(){
        userMapper = new UserMapper();

    }

    public void createUser(User user) throws Exception {

        userMapper.insert(user);

    }

    public void updateUser(User user) {
        userMapper.update(user);
    }

    public void deleteUser(User user) {
        userMapper.delete(user);
    }


    /**
     * View all user in the database
     */
    public ArrayList<User> viewAllUser() throws SQLException {
        ArrayList<User> userList = UserMapper.findAllUsers();
        return userList;
    }

    public User getUserByUsername(String username) throws SQLException {
        return UserMapper.findUserByName(username);
    }

    public User getUserByEmail(String email) throws SQLException {
        return UserMapper.findUserByEmail(email);
    }

    public User getUserById(int id) throws SQLException {
        return UserMapper.findUserById(id);
    }

}