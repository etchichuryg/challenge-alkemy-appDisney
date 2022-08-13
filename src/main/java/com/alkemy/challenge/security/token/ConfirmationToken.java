package com.alkemy.challenge.security.token;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alkemy.challenge.model.User;

@Entity
public class ConfirmationToken {

	    @Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY )
	    
	    private Integer id;

	    @Column(nullable = false)
	    private String token;

	    @Column(nullable = false)
	    private LocalDateTime createdAt;

	    @Column(nullable = false)
	    private LocalDateTime expiresAt;

	    private LocalDateTime confirmedAt;

	    @ManyToOne
	    @JoinColumn(nullable = false, name = "user_id")
	    private User user;
	    
	    public ConfirmationToken() {
	    	
	    }
	    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, User user) {
	        this.token = token;
	        this.createdAt = createdAt;
	        this.expiresAt = expiresAt;
	        this.user = user;
	    }
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public LocalDateTime getExpiresAt() {
			return expiresAt;
		}
		public void setExpiresAt(LocalDateTime expiresAt) {
			this.expiresAt = expiresAt;
		}
		public LocalDateTime getConfirmedAt() {
			return confirmedAt;
		}
		public void setConfirmedAt(LocalDateTime confirmedAt) {
			this.confirmedAt = confirmedAt;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		@Override
		public String toString() {
			return "ConfirmationToken [id=" + id + ", token=" + token + ", createdAt=" + createdAt + ", expiresAt="
					+ expiresAt + ", confirmedAt=" + confirmedAt + ", user=" + user + "]";
		}
	    

		
}
