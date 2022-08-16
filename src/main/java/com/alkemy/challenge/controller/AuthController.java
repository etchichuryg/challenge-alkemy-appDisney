package com.alkemy.challenge.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import com.alkemy.challenge.dto.LoginRequestDTO;
import com.alkemy.challenge.dto.RegisterRequestDTO;
import com.alkemy.challenge.repository.UserRepository;
import com.alkemy.challenge.security.util.JwtTokenUtil;
import com.alkemy.challenge.service.JwtUserDetailsService;
import com.alkemy.challenge.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUserDetailsService userDetailsService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@Autowired
	UserService userService;
	

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
			return userService.loginUser(loginRequestDTO);
	}

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody RegisterRequestDTO registerRequestDto) {
		Map<String, Object> responseMap = userService.saveUser(registerRequestDto);
		return ResponseEntity.ok(responseMap);
	}
}
