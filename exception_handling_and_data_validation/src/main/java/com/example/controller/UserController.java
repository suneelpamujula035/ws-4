package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.serviceImpl.UserServiceImple;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/api")
public class UserController {

	@Autowired
	private UserServiceImple serviceImpl;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(serviceImpl.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(serviceImpl.getUsers(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return new ResponseEntity<User>(serviceImpl.getUser(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> updateUsers(@RequestBody @Valid User user) throws UserNotFoundException {
		return new ResponseEntity<User>(serviceImpl.updateUser(user), HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) throws UserNotFoundException {
		return new ResponseEntity<String>(serviceImpl.deleteUser(id), HttpStatus.OK);
	}

}
