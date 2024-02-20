package com.example.flutterpush.service;

import com.example.flutterpush.entity.User;

public interface FCMTokenService {
	public User saveToken(String token);
}
