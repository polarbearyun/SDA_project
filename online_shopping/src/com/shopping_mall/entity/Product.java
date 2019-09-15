package com.shopping_mall.entity;

public class Product extends DomainObject{

    private String name;

    private String picture;

    private Integer inventory;

    private Integer sold_number;

    private Price price;

    private String detail;



    public Product() {

    }

    public Product(int productId, String name, String picture, Integer inventory, Integer sold_number,
                   Price price, String detail) {
        super();
        this.id = productId;
        this.name = name;
        this.picture = picture;
        this.inventory = inventory;
        this.sold_number = sold_number;
        this.price = price;
        this.detail = detail;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSold_number() {
        return sold_number;
    }

    public void setSold_number(Integer sold_number) {
        this.sold_number = sold_number;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
