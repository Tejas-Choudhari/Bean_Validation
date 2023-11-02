package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {

	private static final org.slf4j.Logger logMessage = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userservice;

	// @valid - unable the hibernate validation

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		logMessage.info(" in the user api");
		User saveduser = userservice.createUser(user);
		return new ResponseEntity<User>(saveduser, HttpStatus.CREATED);
	}
}
