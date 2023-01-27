package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserDetails;
import com.example.repository.UserRespository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsService{
	
	@Autowired
	private UserRespository repo;
	
	public List<UserDetails> findAll(){
		return repo.findAll();
	}
	
	public void save(UserDetails user) {
		 repo.save(user);
	}
	public UserDetails getUser(String id) { 
		return repo.findById(id).get();
	}
    
}
