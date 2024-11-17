package com.microservices.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.inventory.helper.RequestResponse;
import com.microservices.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    
    @GetMapping("/{skuCode}")
    public ResponseEntity<RequestResponse> checkInvent(@PathVariable String skuCode){

        RequestResponse returnValue=inventoryService.checkInventory(skuCode);

        if (returnValue.getStatus()==0) {
            return ResponseEntity.ok(returnValue);
        } else {
            return new ResponseEntity<>(returnValue,HttpStatus.BAD_REQUEST);
        }

    }
    
}
