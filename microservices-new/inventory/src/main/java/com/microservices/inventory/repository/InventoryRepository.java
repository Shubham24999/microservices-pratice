package com.microservices.inventory.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.inventory.entity.Inventory;


@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Long>{

    Optional<Inventory> findBySkuCode(String skuCode);

    
} 