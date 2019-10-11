package com.shopping_mall.service;

import com.shopping_mall.entity.Product;
import com.shopping_mall.mapper.ProductMapper;

public class ProductService {

    private ProductMapper productMapper;

    public ProductService(){
        productMapper = new ProductMapper();

    }

    public void createProduct(Product product) throws Exception {

        productMapper.insert(product);

    }

    public void updateProduct(Product product) {
        productMapper.update(product);
    }

    public void deleteProduct(Product product) {
        productMapper.delete(product);
    }


    public Product findById(int productId){

        return ProductMapper.findById(productId);
    }

}
