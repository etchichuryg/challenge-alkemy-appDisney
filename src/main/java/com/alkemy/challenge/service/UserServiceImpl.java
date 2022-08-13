package com.alkemy.challenge.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.model.User;
import com.alkemy.challenge.repository.UserRepository;
import com.alkemy.challenge.security.token.ConfirmationToken;
import com.alkemy.challenge.security.token.ConfirmationTokenService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	
	 	
	 @Autowired
	  private UserRepository userRepository;
	 @Autowired
	  private BCryptPasswordEncoder bCryptPasswordEncoder;
	 @Autowired 
	  private ConfirmationTokenService confirmationTokenService;

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(email)) ;
	}
	
	@Override
	public String signUpUser(User user) {
		boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
		if(userExists) {
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		String token = UUID.randomUUID().toString();
		//ConfirmationToken confirmationToken = new ConfirmationToken(token,LocalDateTime.now(), LocalDateTime.now().plusMinutes(15));
		//ConfirmationTokenService.saveConfirmationToken(confirmationToken);
		return token;
	}

	@Override
	public int enableUser(String email) {
		// TODO Auto-generated method stub
		return 0;
	}



}

