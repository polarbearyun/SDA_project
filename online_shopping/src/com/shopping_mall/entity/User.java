package com.shopping_mall.entity;

import com.shopping_mall.mapper.AddressMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class User extends DomainObject{
    private String email;

    private String name;

    private String phone;

    private String password;

    private Integer type;

    private ArrayList<Address> address;

    private Boolean addressLoaded;

    private ArrayList<Order> order;

    private Boolean orderLoaded;

    public User(){

    }


    public User(int userId,String email,String name, String phone,String password, Integer type){
        this.id = userId;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.addressLoaded = false;
        this.orderLoaded = false;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ArrayList<Address> getAddress() {
        if(!addressLoaded) {
            int userId = id;
            this.address = AddressMapper.findAddressByUserId(userId);
            this.addressLoaded = true;
        }
        return address;
    }

    public void reloadAddress() {
        int userId = id;
        this.address = AddressMapper.findAddressByUserId(userId);
        this.addressLoaded = true;
    }

}
