package com.dcastles.products_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ProductDto {

    private String sku;
    private String name;
    private String description;
    private double price;
    private boolean status;


    public ProductDto(String sku, String name, String description, double price, boolean status) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }
}
