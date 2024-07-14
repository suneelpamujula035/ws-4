package com.mapping;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapping.entity.Order;
import com.mapping.entity.Product;
import com.mapping.repository.OrderRepository;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner{

	@Autowired
	private OrderRepository orderRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		orderRepository.save(new Order("AWB134557", 8750, Arrays.asList(new Product("keyboard",5),new Product("mouse",7),new Product("battery",3))));
		orderRepository.save(new Order("AWB876545", 16000, Arrays.asList(new Product("earphones",6),new Product("powerbank",8))));

	}

}
