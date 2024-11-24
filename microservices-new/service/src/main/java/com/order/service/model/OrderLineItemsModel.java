package com.order.service.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLineItemsModel {

    private Long id;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

}
