package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public User getUser(int id) throws UserNotFoundException {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("User not found with the id : " + id);
		}
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> existingUser = repository.findById(user.getId());
		if (existingUser.isPresent()) {
			User updateUser = new User();
			updateUser.setId(user.getId());
			updateUser.setUserName(user.getUserName());
			updateUser.setEmail(user.getEmail());
			updateUser.setNumber(user.getNumber());
			updateUser.setAge(user.getAge());
			updateUser.setNationality(user.getNationality());
			return repository.save(updateUser);
		} else {
			throw new UserNotFoundException("User not found with the id : " + user.getId());
		}
	}

	@Override
	public String deleteUser(int id) throws UserNotFoundException {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new UserNotFoundException("User not found with the id : " + id);
		}
		return "User deleted with the id : " + id;
	}

}
