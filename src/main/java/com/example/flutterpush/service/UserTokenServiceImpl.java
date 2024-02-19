package com.example.flutterpush.service;

import org.springframework.stereotype.Service;

import com.example.flutterpush.entity.UserToken;
import com.example.flutterpush.repository.UserTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTokenServiceImpl implements UserTokenService {
	private final UserTokenRepository userTokenRepository;

	@Override
	public UserToken saveToken(String token) {

		return userTokenRepository.save(UserToken.create(token));
	}

}
