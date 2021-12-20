package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.converter.ProductConverter;
import com.tugulbayraktar.springboot.mongodb.dto.ProductDto;
import com.tugulbayraktar.springboot.mongodb.service.entityservice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductEntityService productEntityService;

    @Override
    public List<ProductDto> findAll() {
        return productEntityService.findAll();
    }

    @Override
    public ProductDto findProductById(String id) {
        return productEntityService.findProductById(id);
    }

    @Override
    public Long deleteProductById(String id) {
    return productEntityService.deleteProductById(id);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return ProductConverter.INSTANCE.convertProductToProductDto(productEntityService.saveProduct(productDto));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return ProductConverter.INSTANCE.convertProductToProductDto(productEntityService.updateProduct(productDto));
    }
}
