package com.alkemy.challenge.service;

import com.alkemy.challenge.model.RegistrationRequest;

public interface RegistrationService {
	 public String register(RegistrationRequest request);
	 public String confirmToken(String token);
	 String buildEmail(String name, String link);

}
