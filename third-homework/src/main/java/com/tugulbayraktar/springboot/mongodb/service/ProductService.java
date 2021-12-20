package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();
    ProductDto findProductById(String id);
    Long deleteProductById(String id);
    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
}
