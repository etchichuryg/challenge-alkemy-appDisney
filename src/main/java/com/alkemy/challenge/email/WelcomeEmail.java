package com.alkemy.challenge.email;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.challenge.model.RegistrationRequest;

@Component 
public class WelcomeEmail {
	
	@Autowired 
	public  EmailService emailService; 
	
	
	public void sendNewUserEmailWelcome(@Valid RegistrationRequest registrationRequest) {
		String to = registrationRequest.getEmail();
		String from = "appDisnet <auto-confirm@appDisney.com>";
		String subject = registrationRequest.getFirstName() + ", welcome to appDisney!";
		String body = registrationRequest.getFirstName() + ", welcome to appDisney!\r\n" + "\r\n"
			+ "Explore your movies according to your favorite genre and find all your characters.\r\n" + "\r\n";
		emailService.sendSimpleMessage(to, from, subject, body);
	}
}
