package com.example.controller;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserDetails;
import com.example.service.UserDetailsService;

@RestController
public class UserController {
	@Autowired
	private UserDetailsService service;

	@GetMapping("/getuser")
	public ResponseEntity<UserDetails> getUser(@RequestParam String userid) {
		try {
			UserDetails user = service.getUser(userid);
			return new ResponseEntity<UserDetails>(user,HttpStatus.OK);	
		}catch(NoSuchElementException ex) {
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/addUser")
	public void addUserDetails(@RequestBody UserDetails user) {
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		user.setUserId(uuidAsString);
		service.save(user);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserDetails> updateUser(@RequestParam String userid) {
		try {
			UserDetails user =service.getUser(userid);
			service.save(user);
			return new ResponseEntity<UserDetails>(user,HttpStatus.OK); 
		}catch(NoSuchElementException ex) {
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
	}
	
}
