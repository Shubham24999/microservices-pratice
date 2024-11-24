package com.microservice.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product_service.model.ProductRequest;
import com.microservice.product_service.model.RequestResponse;
import com.microservice.product_service.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<RequestResponse> createProdcut(@RequestBody ProductRequest productData) {

        RequestResponse returnValue = productService.createNewProduct(productData);

        if (returnValue.getStatus() == 0) {
            return ResponseEntity.ok(returnValue);
        } else {
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<RequestResponse> getAllProduct() {

        RequestResponse returnValue = productService.getAllProducts();

        if (returnValue.getStatus() == 0) {
            return ResponseEntity.ok(returnValue);
        } else {
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }

    }

}
