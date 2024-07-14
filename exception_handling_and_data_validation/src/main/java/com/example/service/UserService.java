package com.example.service;

import java.util.List;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;

public interface UserService {

	User saveUser(User user);
	List<User> getUsers();
	User getUser(int id) throws UserNotFoundException;
	User updateUser(User user) throws UserNotFoundException;
	String deleteUser(int id) throws UserNotFoundException;
}
