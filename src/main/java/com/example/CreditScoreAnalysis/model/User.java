package com.example.CreditScoreAnalysis.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String username;

	    @Column(nullable = false)
	    private String passwordHash;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String role; // e.g., "ROLE_ADMIN", "ROLE_USER"

	    @Column(nullable = false)
	    private LocalDateTime createdAt;

	    private LocalDateTime lastLogin;

	    @Column(nullable = false)
	    private String status; // e.g., "ACTIVE", "INACTIVE"
	    
	    
	    
	    public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getPasswordHash() {
			return passwordHash;
		}



		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getRole() {
			return role;
		}



		public void setRole(String role) {
			this.role = role;
		}



		public LocalDateTime getCreatedAt() {
			return createdAt;
		}



		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}



		public LocalDateTime getLastLogin() {
			return lastLogin;
		}



		public void setLastLogin(LocalDateTime lastLogin) {
			this.lastLogin = lastLogin;
		}



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}



	
}
