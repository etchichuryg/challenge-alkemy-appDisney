package com.alkemy.challenge.model;

import java.io.Serializable;
//import java.util.Collection;
//import java.util.Collections;

import javax.persistence.Entity;

import javax.persistence.*;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/


@Entity
@NamedQuery(name = "user.findAll", query = "SELECT user FROM User user")
@Table
public class User implements Serializable/*, UserDetails*/ {
	private static final long serialVersionUID = 1L;
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	private Boolean locked = false;
	private Boolean enabled = false;

	public User() {

	}

	public User(Integer id, String firstName, String lastName, String email, String password, UserRole userRole) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	
	}
/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
    }
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

*/

}
