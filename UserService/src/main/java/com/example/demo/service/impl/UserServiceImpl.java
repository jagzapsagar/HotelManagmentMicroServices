package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found"));
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
