package com.shopping_mall.entity;

public class Item extends DomainObject{

    private Integer amount;

    private Integer order_id;

    private Integer product_id;



    private Integer total_price;

    public Item(){

    }

    public Item(int itemId, int amount, int order,int product,int total_price){
        super();
        this.id = itemId;
        this.amount = amount;
        this.order_id = order;
        this.product_id = product;
        this.total_price = total_price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }


    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }



}
