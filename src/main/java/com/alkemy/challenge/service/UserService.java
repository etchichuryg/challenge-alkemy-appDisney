package com.alkemy.challenge.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;


import com.alkemy.challenge.dto.LoginRequestDTO;
import com.alkemy.challenge.dto.RegisterRequestDTO;

public interface UserService {
	
	public Map<String, Object> saveUser(RegisterRequestDTO registerRequestDto) throws Exception;
	
	public ResponseEntity<?> loginUser(LoginRequestDTO loginRequestDTO);

}
