package com.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.helper.RequestResponse;
import com.order.service.model.OrderRequestModel;
import com.order.service.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/post")
    public  ResponseEntity<RequestResponse> postOrders(@RequestBody OrderRequestModel orderRequestData){

         RequestResponse returnValue = orderService.postOrder(orderRequestData);

        if (returnValue.getStatus() == 0) {
            return ResponseEntity.ok(returnValue);
        } else {
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }
    }
    
}
