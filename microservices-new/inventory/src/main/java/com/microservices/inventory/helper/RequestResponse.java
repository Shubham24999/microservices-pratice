package com.microservices.inventory.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponse {

    private String messsage;

    private Integer status;

    private Object data;
    
}
