package com.microservices.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservices.inventory.entity.Inventory;
import com.microservices.inventory.repository.InventoryRepository;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
		System.out.println("Application Started.");
	}
    
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

		return args->{
			Inventory newData1=new Inventory();
			newData1.setSkuCode("Iphone_13");
			newData1.setQuantity(2);


			Inventory newData2=new Inventory();
			newData2.setSkuCode("Iphone_14");
			newData2.setQuantity(1);

			inventoryRepository.save(newData1);
			inventoryRepository.save(newData2);
		};

	}
}
