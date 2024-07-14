package com.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapping.entity.Customer;
import com.mapping.entity.Item;
import com.mapping.repository.CustomerRepository;

@SpringBootApplication
public class OneToOneUnidirectionalApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(OneToOneUnidirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = new Customer("Suneel");
		Item item1 = new Item("Washing Maching");
		customer1.setItem(item1);
		customerRepository.save(customer1);
		
		Customer customer2 = new Customer("Vijay");
		Item item2 = new Item("Refrigirator");
		customer2.setItem(item2);
		customerRepository.save(customer2);
	}

}
