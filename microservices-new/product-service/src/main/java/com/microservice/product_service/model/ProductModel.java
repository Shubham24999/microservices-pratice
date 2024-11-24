package com.microservice.product_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {

    private String id;
    
    private String name;

    private String description;

    private Integer price;

}
