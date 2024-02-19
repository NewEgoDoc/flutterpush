package com.example.flutterpush.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class UserToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//기본값은 255
	@Column(nullable = false, unique = true)
	private String token;

	public UserToken(String token) {
		this.token = token;
	}

	public UserToken() {

	}

	// getters and setters
	public static UserToken create(String token) {
		return new UserToken(token);
	}

	// public 생성자




}
