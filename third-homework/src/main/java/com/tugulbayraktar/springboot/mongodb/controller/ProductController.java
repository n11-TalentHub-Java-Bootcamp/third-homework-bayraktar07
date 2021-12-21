package com.tugulbayraktar.springboot.mongodb.controller;

import com.tugulbayraktar.springboot.mongodb.dto.ProductDto;
import com.tugulbayraktar.springboot.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public ProductDto findProductById (@PathVariable String id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto) {
        productDto = productService.saveProduct(productDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productDto.getId())
                .toUri();
        if(productDto.getId() != null) {
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto) {
        productDto = productService.updateProduct(productDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productDto.getId())
                .toUri();
        if(productDto.getId() != null) {
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProductById(@RequestParam String id) {
        Long deletedCount = productService.deleteProductById(id);
        if(deletedCount > 0) {
            return ResponseEntity.ok("ID: " + id + "\n " + deletedCount + " entry found and deleted.");
        }
        return ResponseEntity.notFound().header("message", "Entry " + id + " does not exist.").build();
    }
}
