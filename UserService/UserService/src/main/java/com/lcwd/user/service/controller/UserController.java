package com.lcwd.user.service.controller;

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

import com.lcwd.user.service.entities.User;

import com.lcwd.user.service.services.UserServices;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user2 = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		System.out.println("getUserById");
		User singleUser = userServices.getSingleUser(userId);
		return new ResponseEntity(singleUser, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userServices.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updateUser = userServices.updateUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity deleteUser(@PathVariable String userId) {
		userServices.deleteUser(userId);
		return ResponseEntity.ok().build();
	}
}
