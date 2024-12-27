package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
