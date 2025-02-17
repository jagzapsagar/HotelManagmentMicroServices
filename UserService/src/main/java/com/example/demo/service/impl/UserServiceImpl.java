package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + id));
		Rating[] forObject = restTemplate.getForObject("http://localhost:8083/rating/get/userid/"+id, Rating[].class);
		List<Rating> rlist = Arrays.stream(forObject).toList();
		
		List<Rating> hotels = rlist.stream().map(r -> {
			ResponseEntity<Hotel> forHotelEntity = restTemplate.getForEntity("http://localhost:8082/hotel/get/"+r.getHotelId(), Hotel.class);
			Hotel hotel = forHotelEntity.getBody();
			r.setHotel(hotel);
			return r;
		}).collect(Collectors.toList());
		logger.info("{}", forObject);
		System.out.println("-----------------");
		logger.info("{}", hotels);
		System.out.println(hotels);
		System.out.println("------------------------");
		user.setRatings(hotels);
		return user;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		String udd = UUID.randomUUID().toString();
		user.setId(udd);
		return userRepo.save(user);
	}

}
