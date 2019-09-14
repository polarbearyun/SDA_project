package com.shopping_mall.service;

import com.shopping_mall.entity.Product;
import com.shopping_mall.mapper.ProductMapper;

public class ProductService {

    public Product findById(int productId){

        return ProductMapper.findById(productId);
    }

}
