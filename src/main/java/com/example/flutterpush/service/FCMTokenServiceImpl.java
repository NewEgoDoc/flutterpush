package com.example.flutterpush.service;

import org.springframework.stereotype.Service;

import com.example.flutterpush.entity.User;
import com.example.flutterpush.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FCMTokenServiceImpl implements FCMTokenService {
	private final UserRepository userRepository;

	@Override
	public User saveToken(String token) {

		return userRepository.save(User.create(token));
	}

}
