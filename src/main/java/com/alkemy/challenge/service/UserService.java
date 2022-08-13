package com.alkemy.challenge.service;

import com.alkemy.challenge.model.User;

public interface UserService {
	
	 public String signUpUser(User user);
	 public int enableUser(String email);
	
}
