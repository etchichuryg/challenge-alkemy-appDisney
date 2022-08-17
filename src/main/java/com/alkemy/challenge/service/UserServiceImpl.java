package com.alkemy.challenge.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.LoginRequestDTO;
import com.alkemy.challenge.dto.RegisterRequestDTO;
import com.alkemy.challenge.email.WelcomeEmail;
import com.alkemy.challenge.model.RegistrationRequest;
import com.alkemy.challenge.model.User;
import com.alkemy.challenge.model.UserRole;
import com.alkemy.challenge.repository.UserRepository;
import com.alkemy.challenge.security.util.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUserDetailsService userDetailsService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@Autowired
	WelcomeEmail welcomeEmail;

	
	@Override
	public Map<String, Object> saveUser(RegisterRequestDTO registerRequestDto) throws Exception {
		Map<String, Object> responseMap = new HashMap<>();
		User user = new User();
		user.setFirstName(registerRequestDto.getFirstName());
		user.setLastName(registerRequestDto.getLastName());
		user.setEmail(registerRequestDto.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(registerRequestDto.getPassword()));
		user.setUserRole(UserRole.USER);
		user.setUsername(registerRequestDto.getUserName());
		userRepository.save(user);
		UserDetails userDetails = userDetailsService.loadUserByUsername(registerRequestDto.getEmail());
		String token = jwtTokenUtil.generateToken(userDetails);
		responseMap.put("error", false);
		responseMap.put("email", registerRequestDto.getEmail());
		responseMap.put("message", "Account created successfully");
		responseMap.put("token", token);
		try {
			RegistrationRequest rq = new RegistrationRequest(registerRequestDto.getFirstName(), registerRequestDto.getLastName(), registerRequestDto.getEmail(), registerRequestDto.getPassword());	
			welcomeEmail.sendNewUserEmailWelcome(rq);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return responseMap;
	}


	@Override
	public ResponseEntity<?> loginUser(LoginRequestDTO loginRequestDTO) {
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

}
