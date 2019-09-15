package com.shopping_mall.service;

import com.shopping_mall.entity.Item;

import java.util.ArrayList;

public class ItemService {
    private ArrayList<Item> newItems;
    private ArrayList<Item> updatedItems;
    private ArrayList<Integer> deletedItems;

    public ItemService() {
        newItems = new ArrayList<>();
        updatedItems = new ArrayList<>();
        deletedItems = new ArrayList<>();
    }


}
