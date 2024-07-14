package com.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapping.entity.Address;
import com.mapping.entity.User;
import com.mapping.repository.UserRepository;

@SpringBootApplication
public class OneToOneBidirectionalApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OneToOneBidirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Mahesh");
		Address address1 = new Address("Hyderabad", "Telangana", "India");
		user1.setAddress(address1);
		address1.setUser(user1);
		userRepository.save(user1);
		
		
		User user2 = new User("Charan");
		Address address2 = new Address("Nellore", "Andhra Pradesh", "India");
		user2.setAddress(address2);
		address2.setUser(user2);
		userRepository.save(user2);
	}

}
