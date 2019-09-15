package com.shopping_mall.entity;

public class Price extends DomainObject {
    //To solve the discount price in feature B;

    public Price(int price){
        this.price = price;

    }
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
