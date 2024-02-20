package com.example.flutterpush.entity;

import static lombok.AccessLevel.*;

import com.example.flutterpush.support.entity.BaseIdEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "users")
@Entity
public class User extends BaseIdEntity {

	//기본값은 255
	@Column(nullable = false, unique = true)
	private String token;

	public User(String token) {
		this.token = token;
	}

	// getters and setters
	public static User create(String token) {
		return new User(token);
	}

	// public 생성자




}
