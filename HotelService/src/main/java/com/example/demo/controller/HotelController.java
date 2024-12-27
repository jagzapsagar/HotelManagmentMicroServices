package com.example.demo.controller;

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

import com.example.demo.enity.Hotel;
import com.example.demo.service.HotelService;


@RestController
@RequestMapping("/home")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/getall")
	public List<Hotel> getall(){
		return hotelService.getAll();
		
	}
	
	@GetMapping("/get/{id}")
	public Hotel getById(@PathVariable String id) {
		System.out.println(id);
		return hotelService.get(id);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Hotel> post(@RequestBody Hotel hotel){
		Hotel savedhotel = hotelService.post(hotel);
	return ResponseEntity.status(HttpStatus.CREATED).body(savedhotel);
	}

}
