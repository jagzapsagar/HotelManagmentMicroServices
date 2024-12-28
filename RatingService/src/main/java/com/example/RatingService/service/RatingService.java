package com.example.RatingService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RatingService.entity.Rating;


public interface RatingService {
	
	Rating post(Rating rating);
	
	List<Rating> getall();
	
	Rating get(String id);
	
	List<Rating> getRatingByUserId(String userid);
	List<Rating> getRatingByHotelId(String hotelid);
	

}
