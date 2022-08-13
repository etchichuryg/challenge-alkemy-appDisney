package com.alkemy.challenge.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.email.EmailSender;
import com.alkemy.challenge.model.RegistrationRequest;
import com.alkemy.challenge.model.User;
import com.alkemy.challenge.model.UserRole;
import com.alkemy.challenge.security.EmailValidator;
import com.alkemy.challenge.security.token.ConfirmationToken;
import com.alkemy.challenge.security.token.ConfirmationTokenService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	UserService userService;
	@Autowired
	EmailValidator emailValidator;
	@Autowired
	ConfirmationTokenService confirmationTokenService;
	@Autowired
	EmailSender emailSender;

	@Override
	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if (!isValidEmail) { 
			throw new IllegalStateException("email not valid");
		}

		String token = userService.signUpUser(new User(request.getFirstName(), request.getLastName(),
				request.getEmail(), request.getPassword(), UserRole.USER));
		return token;

	}

	@Transactional
	public String confirmToken(String token) {
		ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
				.orElseThrow(() -> new IllegalStateException("token not found"));

		if (confirmationToken.getConfirmedAt()!= null) {
			throw new IllegalStateException("email already confirmed");
		}
		LocalDateTime expiredAt = confirmationToken.getExpiresAt();
		if (expiredAt.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("token expired");
		}

		confirmationTokenService.setConfirmedAt(token);
		userService.enableUser(confirmationToken.getUser().getEmail());
		return "confirmed";
	}

	@Override
	public String buildEmail(String name, String link) {
		// TODO Auto-generated method stub
		return null;
	}

}
