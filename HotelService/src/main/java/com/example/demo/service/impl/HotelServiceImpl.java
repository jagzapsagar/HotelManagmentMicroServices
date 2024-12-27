package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enity.Hotel;
import com.example.demo.repo.HotelRepo;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return hotelRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found"));
	}

	@Override
	public Hotel post(Hotel hotel) {
		// TODO Auto-generated method stub
		String idd = UUID.randomUUID().toString();
		hotel.setId(idd);
		return hotelRepo.save(hotel);
	}

}
