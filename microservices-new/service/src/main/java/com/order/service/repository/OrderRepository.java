package com.order.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.service.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer>{
    
}
