package com.microservice.product_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponse {

    private String message;

    private Integer status;

    private Object data;
    
}
