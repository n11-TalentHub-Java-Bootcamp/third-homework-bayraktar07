package com.tugulbayraktar.springboot.mongodb.converter;

import com.tugulbayraktar.springboot.mongodb.dto.ProductDto;
import com.tugulbayraktar.springboot.mongodb.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    ProductDto convertProductToProductDto(Product product);

    List<ProductDto> convertAllProductListToProductDtoList(List<Product> productList);

    Product convertProductDtoToProduct(ProductDto productDto);
}
