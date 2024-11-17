package com.order.service.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestModel {

    private List<OrderLineItemsModel> orderLineItemsModelList;
    
}
