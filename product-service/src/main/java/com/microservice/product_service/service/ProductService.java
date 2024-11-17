package com.microservice.product_service.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.product_service.entity.Product;
import com.microservice.product_service.model.ProductModel;
import com.microservice.product_service.model.ProductRequest;
import com.microservice.product_service.model.RequestResponse;
import com.microservice.product_service.repository.ProductRepository;

@Service
public class ProductService {

    private static Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public RequestResponse createNewProduct(ProductRequest productDetails) {

        RequestResponse returnValue = new RequestResponse();

        try {

            Product newProduct = new Product();

            newProduct.setName(productDetails.getName());
            newProduct.setDescription(productDetails.getDescription());
            newProduct.setPrice(productDetails.getPrice());

            // productRepository.save(newProduct);
            returnValue.setData(productRepository.save(newProduct));
            returnValue.setMessage("New Product Created Successfully.");
            returnValue.setStatus(0);

        } catch (Exception e) {
            returnValue.setMessage("Error While Creating Product." + e.getMessage());
            returnValue.setStatus(-1);

            logger.error("Error While Creating Product {} {}", e.getMessage(), e);

        }

        return returnValue;

    }

    public RequestResponse getAllProducts() {

        RequestResponse returnValue = new RequestResponse();

        List<ProductModel> responseList = new ArrayList<>();

        try {

            List<Product> productList = productRepository.findAll();
            ProductModel responseValue = new ProductModel();

            if (productList.isEmpty()) {

                returnValue.setMessage("Product list is Empty.");

            } else {

                for (Product singleProduct : productList) {

                    responseValue.setId(singleProduct.getId());
                    responseValue.setDescription(singleProduct.getDescription());
                    responseValue.setName(singleProduct.getName());
                    responseValue.setPrice(singleProduct.getPrice());

                    responseList.add(responseValue);
                }

                returnValue.setMessage("All Product list are.");
                returnValue.setData(responseList);
            }
            returnValue.setStatus(0);

        } catch (Exception e) {

            returnValue.setMessage("Error While fetching All Product list." + e.getMessage());
            returnValue.setStatus(-1);
            logger.error("Error While fetching All Product list {} {}", e.getMessage(), e);

        }

        return returnValue;

    }

}
