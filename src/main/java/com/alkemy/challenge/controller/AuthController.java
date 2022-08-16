package com.alkemy.challenge.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.alkemy.challenge.dto.LoginRequestDTO;
import com.alkemy.challenge.dto.RegisterRequestDTO;
import com.alkemy.challenge.model.User;
import com.alkemy.challenge.model.UserRole;
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
		Map<String, Object> responseMap = new HashMap<>();
		try {
		User user = userRepository.findUserByEmail(loginRequestDTO.getEmail());
		Boolean isValid = BCrypt.checkpw(loginRequestDTO.getPassword()  ,user.getPassword());
		if(isValid) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getEmail());
		String token = jwtTokenUtil.generateToken(userDetails);
		responseMap.put("error", false);
		responseMap.put("email", loginRequestDTO.getEmail());
		responseMap.put("message", "Account created successfully");
		responseMap.put("token", token);
		return ResponseEntity.ok(responseMap);

		}else {
				responseMap.put("error", true);
				responseMap.put("message", "Invalid Credentials");
				return ResponseEntity.status(401).body(responseMap);
			}
		} catch (DisabledException e) {
			e.printStackTrace();
			responseMap.put("error", true);
			responseMap.put("message", "User is disabled");
			return ResponseEntity.status(500).body(responseMap);
		} catch (BadCredentialsException e) {
			responseMap.put("error", true);
			responseMap.put("message", "Invalid Credentials");
			return ResponseEntity.status(401).body(responseMap);
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("error", true);
			responseMap.put("message", "Something went wrong");
			return ResponseEntity.status(500).body(responseMap);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody RegisterRequestDTO registerRequestDto) {
		Map<String, Object> responseMap = userService.saveUser(registerRequestDto);
		return ResponseEntity.ok(responseMap);
	}
}
