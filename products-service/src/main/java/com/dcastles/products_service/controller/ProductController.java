package com.dcastles.products_service.controller;

import com.dcastles.products_service.dto.ProductDto;
import com.dcastles.products_service.entity.Product;
import com.dcastles.products_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProduct(){
        return new ResponseEntity(productService.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getByIdProduct(@PathVariable Long id){
        return new ResponseEntity(productService.getByIdProduct(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        Product createProduct = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProductDto(createProduct.getSku(),createProduct.getName(),createProduct.getDescription(),createProduct.getPrice(),createProduct.isStatus()));

    }
    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        Product updateProduct=productService.updateProduct(id,productDto);
        return new ProductDto(updateProduct.getSku(),updateProduct.getName(),updateProduct.getDescription(),updateProduct.getPrice(),updateProduct.isStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
