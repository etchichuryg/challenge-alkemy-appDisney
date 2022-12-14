package com.alkemy.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.model.User;
import com.alkemy.challenge.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			User user = userRepository.findUserByEmail(email);
	        List<GrantedAuthority> authorityList = new ArrayList<>();
	        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
	        return new User(user.getEmail(), user.getPassword(), authorityList);
	}
	
	

}
