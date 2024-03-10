package com.example.flutterpush.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flutterpush.controller.dto.UserTokenSaveRequest;
import com.example.flutterpush.entity.DeviceApp;
import com.example.flutterpush.entity.User;
import com.example.flutterpush.service.FCMTokenService;
import com.example.flutterpush.service.dto.RegisterTokenCommand;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tokens")
@RequiredArgsConstructor
public class FCMTokenController {

	private final FCMTokenService FCMTokenService;

	@PostMapping
	public ResponseEntity<DeviceApp> saveToken(@RequestBody UserTokenSaveRequest request) {
		return new ResponseEntity<>(
			FCMTokenService.registerToken(
				RegisterTokenCommand.create(
					request.getUserId(),
					request.getToken(),
					request.getOs(),
					request.getAppSerialNumber())), HttpStatus.CREATED);
	}
}
