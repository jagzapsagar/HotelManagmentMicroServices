package com.example.RatingService.ratingcontroller;

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

import com.example.RatingService.entity.Rating;
import com.example.RatingService.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/post")
	public ResponseEntity<Rating> post(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.post(rating));
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Rating>> getrating(){
		return ResponseEntity.ok(ratingService.getall());
	}
	
	@GetMapping("/get/ratingid/{ratingid}")
	public ResponseEntity<Rating> getRatingByRatingId(@PathVariable String ratingid){
		return ResponseEntity.ok(ratingService.get(ratingid));
	}
	
	@GetMapping("/get/userid/{userid}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userid){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userid));
	}
	
	@GetMapping("/get/hotelid/{hotelid}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelid){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelid));
	}
}
