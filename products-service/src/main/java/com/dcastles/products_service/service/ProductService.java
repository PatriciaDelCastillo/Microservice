package com.dcastles.products_service.service;


import com.dcastles.products_service.dto.ProductDto;
import com.dcastles.products_service.entity.Product;
import com.dcastles.products_service.exception.NotFoundException;
import com.dcastles.products_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Product getByIdProduct(Long id){
        return productRepository.findById(id).orElseThrow(()-> new NotFoundException("Product not found"));
    }

    public Product saveProduct(ProductDto productDto){
        Product product = Product.builder()
                      .sku(productDto.getSku())
                      .name(productDto.getName())
                      .description(productDto.getDescription())
                      .price(productDto.getPrice())
                      .build();
        return productRepository.save(product);

    }
    public Product updateProduct(Long id,ProductDto productDto){
        Product product= getByIdProduct(id);
        product.setSku(productDto.getSku());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStatus(productDto.isStatus());
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}