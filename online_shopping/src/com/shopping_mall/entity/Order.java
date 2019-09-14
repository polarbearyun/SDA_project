package com.shopping_mall.entity;

import com.shopping_mall.mapper.AddressMapper;
import com.shopping_mall.mapper.ItemMapper;

import java.util.ArrayList;
import java.util.Date;

public class Order extends DomainObject {

    private Integer number;

    private User user;

    private Float total_price;

    private Date create_time;

    private Date payment_time;

    private String remark;

    private Integer status;

    private ArrayList<Item> item;

    private Boolean itemLoaded;

    public Order(){

    }

    public Order(int orderId, int number, User user, float total_price, Date create_time,Date payment_time, String remark, Integer status){
        super();
        this.id = orderId;
        this.number = number;
        this.user = user;
        this.total_price = total_price;
        this.create_time = create_time;
        this.payment_time = payment_time;
        this.remark = remark;
        this.status = status;
        this.itemLoaded = false;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public Integer getUserId() {
        return user.getId();
    }

    public User getUser() {
        return user;
    }


    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }




    public ArrayList<Item> getItem() {
        if(!itemLoaded) {
            int orderId = id;
            this.item = ItemMapper.findAddressByUserId(orderId);
            this.itemLoaded = true;
        }
        return item;
    }

    public void reloadAddress() {
        int orderId = id;
        this.item = AddressMapper.findScheduleByFilmId(orderId);
        this.itemLoaded = true;
    }
}
