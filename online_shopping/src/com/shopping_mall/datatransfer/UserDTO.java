package com.shopping_mall.datatransfer;

import com.google.gson.Gson;

public class UserDTO {

    private int id;

    private String email;

    private String name;

    private String phone;

    private String password;

    private Integer type;

    private String address;

    private String state;

    private String post_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public static String serialize(UserDTO user) {
        Gson gson = new Gson();
        return gson.toJson(user);
    }
    public static UserDTO deserialize(String userStr) {
        Gson gson = new Gson();
        return gson.fromJson(userStr, UserDTO.class);
    }




}
