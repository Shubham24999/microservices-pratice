package com.order.service.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.entity.Order;
import com.order.service.entity.OrderLineItems;
import com.order.service.helper.RequestResponse;
import com.order.service.model.OrderLineItemsModel;
import com.order.service.model.OrderRequestModel;
import com.order.service.repository.OrderLineItemsRepository;
import com.order.service.repository.OrderRepository;

@Service
public class OrderService {

    private static Logger logger=LogManager.getLogger(OrderService.class);

    @Autowired
    private OrderLineItemsRepository orderLineItemsRepository;

    @Autowired
    private OrderRepository orderRepository;

    public RequestResponse postOrder(OrderRequestModel orderRequestData) {

        RequestResponse returnValue = new RequestResponse();

        List<OrderLineItems> listData = new ArrayList<>();

        try {
            Order newOrder = new Order();

            List<OrderLineItemsModel> totalOrderList = orderRequestData.getOrderLineItemsModelList();

            for (OrderLineItemsModel singleItem : totalOrderList) {
                OrderLineItems newItem = new OrderLineItems();

                newItem.setPrice(singleItem.getPrice());
                newItem.setQuantity(singleItem.getQuantity());
                newItem.setSkuCode(singleItem.getSkuCode());

                listData.add(newItem);
                orderLineItemsRepository.save(newItem);
                logger.info("Single Item saved Successfully {} ",singleItem);
            }

            newOrder.setOrderLineItemsList(listData);

            returnValue.setData(orderRepository.save(newOrder));
            returnValue.setStatus(0);   

        } catch (Exception e) {
            
            logger.error("Error While saving order detials : {} {}",e.getMessage(),e);
            returnValue.setStatus(-1);
            returnValue.setMessage("Error is : "+e.getMessage());
        }

        return returnValue;

    }

}
