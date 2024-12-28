package com.example.RatingService.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RatingService.entity.Rating;
import com.example.RatingService.repo.RatingRepo;
import com.example.RatingService.service.RatingService;

@Service
public class RatingserviceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating post(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getall() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public Rating get(String id) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found Element"));
	}

	@Override
	public List<Rating> getRatingByUserId(String userid) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userid);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelid) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelid);
	}

}
