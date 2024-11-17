package com.order.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.service.entity.OrderLineItems;

@Repository
public interface OrderLineItemsRepository extends CrudRepository<OrderLineItems, Long> {

}
