package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user") //user
public class UserController {
	
	@Autowired
	private UserService userService;
	

	
	@GetMapping("/get")
	public List<User> getall(){
		return userService.getall();
		
	}
	
	@GetMapping("/get/{id}")
	public User getById(@PathVariable String id) {
		System.out.println("---------------------Get Id Caleed---------------");

		return userService.getById(id);
	}
	
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user){
		User saved = userService.save(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

}
