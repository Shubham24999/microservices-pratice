package com.microservice.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.product_service.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String>{
    
}