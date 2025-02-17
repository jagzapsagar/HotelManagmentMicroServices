package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffsController {
	
	@GetMapping
	public List<String> get(){
		List<String> list = List.of("abc","xyz");
		return list;
	}

}
