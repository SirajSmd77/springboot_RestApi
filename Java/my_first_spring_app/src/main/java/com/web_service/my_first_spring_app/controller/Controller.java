package com.web_service.my_first_spring_app.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_service.my_first_spring_app.model.RestUser;

@RestController
@RequestMapping("/users")

public class Controller {
	
	
	Map<String,RestUser> allUsers = new HashMap<>();
	
	@GetMapping
	public Collection<RestUser> getMethod() {
		return allUsers.values();
	}

	@PostMapping
	public String postMethod(@RequestBody RestUser userdetails) {
		RestUser addValues = new RestUser();
		addValues.setUserId(userdetails.getUserId());
		addValues.setName(userdetails.getName());
		addValues.setEmail(userdetails.getEmail());
		
		allUsers.put(userdetails.getUserId(),addValues);
		
		return "User details are added";
	}
	
	@PutMapping(path="/{userId}")
	public String putMethod(@PathVariable String userId,@RequestBody RestUser userdetails) {
		
		if(allUsers.containsKey(userId)) {
			RestUser addValues = new RestUser();
			addValues.setUserId(userdetails.getUserId());
			addValues.setName(userdetails.getName());
			addValues.setEmail(userdetails.getEmail());
			
			allUsers.put(userId,addValues);
			return "Edit is done";
		}else {
		return "UserId not found";
		}
	}
	
	@DeleteMapping(path="/{userId}")
	public String deleteMethod(@PathVariable String userId) {
		if(allUsers.containsKey(userId)) {
			allUsers.remove(userId);
		return "User delted SuccessFully";
		}else {
			return "userId not found";
		}
	}
}
