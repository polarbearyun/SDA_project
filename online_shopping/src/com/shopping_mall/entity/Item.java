package com.shopping_mall.entity;

public class Item extends DomainObject{

    private Integer amount;

    private Order order;

    private Product product;

    private Integer total_price;

    public Item(){

    }

    public Item(int itemId, int amount, Order order,Product product,int total_price){
        super();
        this.id = itemId;
        this.amount = amount;
        this.order = order;
        this.product = product;
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

    public Order getOrder() {
        return order;
    }
    public int getOrderId() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductId() {
        return product.getId();
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }



}
