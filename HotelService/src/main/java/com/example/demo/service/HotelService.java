package com.example.demo.service;

import java.util.List;

import com.example.demo.enity.Hotel;

public interface HotelService {
	
	List<Hotel> getAll();
	Hotel get(String id);
	Hotel post(Hotel hotel);

}
