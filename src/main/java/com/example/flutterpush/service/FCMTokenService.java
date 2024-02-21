package com.example.flutterpush.service;

import com.example.flutterpush.service.dto.DeleteTokenCommand;
import com.example.flutterpush.service.dto.RegisterTokenCommand;

public interface FCMTokenService {
	void registerToken(RegisterTokenCommand command);
	void deleteToken(DeleteTokenCommand command);
}
