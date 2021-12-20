package com.tugulbayraktar.springboot.mongodb.service.entityservice;

import com.tugulbayraktar.springboot.mongodb.converter.ProductConverter;
import com.tugulbayraktar.springboot.mongodb.dto.ProductDto;
import com.tugulbayraktar.springboot.mongodb.entity.Product;
import com.tugulbayraktar.springboot.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return ProductConverter.INSTANCE.convertAllProductListToProductDtoList(productRepository.findAll());
    }

    public ProductDto findProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(ProductConverter.INSTANCE::convertProductToProductDto).orElse(null);
    }

    public Long deleteProductById (String id) {
        return productRepository.deleteProductById(id);
    }

    public Product saveProduct(ProductDto productDto) {
       return productRepository.insert(ProductConverter.INSTANCE.convertProductDtoToProduct(productDto));
    }

    public Product updateProduct(ProductDto productDto){
        return productRepository.save(ProductConverter.INSTANCE.convertProductDtoToProduct(productDto));
    }
}
