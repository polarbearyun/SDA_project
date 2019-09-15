package com.shopping_mall.entity;

public class Address extends DomainObject {

    private String address;

    private String state;

    private String post_code;

    private User user;



    public Address (){

    }

    public Address(int addressId, String address, String state,String post_code){
        super();
        this.id = addressId;
        this.address = address;
        this.state = state;
        this.post_code = post_code;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
