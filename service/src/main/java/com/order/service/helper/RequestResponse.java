package com.order.service.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponse {

    private String message;

    private Integer status;

    private Object data;
    
}

