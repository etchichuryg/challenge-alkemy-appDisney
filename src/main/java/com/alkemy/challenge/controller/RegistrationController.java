package com.alkemy.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.alkemy.challenge.model.RegistrationRequest;
import com.alkemy.challenge.service.RegistrationService;

@RestController
@RequestMapping(path="auth/register")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping 
	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
	}
	
	@GetMapping
	public String confirm(@RequestParam ("token") String token) {
		return registrationService.confirmToken(token);
	}
}
