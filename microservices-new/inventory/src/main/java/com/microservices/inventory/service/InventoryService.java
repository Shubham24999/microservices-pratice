package com.microservices.inventory.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.inventory.entity.Inventory;
import com.microservices.inventory.helper.RequestResponse;
import com.microservices.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

    private static final Logger logger = LogManager.getLogger(InventoryService.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    public RequestResponse checkInventory(String skuCode) {

        RequestResponse returnValue = new RequestResponse();

        try {

            Optional<Inventory> isInventoryPresent = inventoryRepository.findBySkuCode(skuCode);

            if (isInventoryPresent.isPresent()) {

                returnValue.setData(isInventoryPresent);
                returnValue.setMesssage("Inventory data is :");
            } else {

                returnValue.setMesssage("Inventory not present :");
            }

            returnValue.setStatus(0);

        } catch (Exception e) {
            logger.error("Error while searching inventory is :{} {} ", e.getMessage(), e);
            returnValue.setMesssage("Error is : {} " + e);
            returnValue.setStatus(-1);
        }

        return returnValue;

    }

}
