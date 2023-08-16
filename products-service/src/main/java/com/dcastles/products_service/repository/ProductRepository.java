package com.dcastles.products_service.repository;

import com.dcastles.products_service.dto.ProductDto;
import com.dcastles.products_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    void save(Product.ProductBuilder producto);


}
