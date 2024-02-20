package com.example.flutterpush.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flutterpush.controller.dto.UserTokenSaveRequest;
import com.example.flutterpush.entity.User;
import com.example.flutterpush.service.FCMTokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tokens")
@RequiredArgsConstructor
public class FCMTokenController {

	private final FCMTokenService FCMTokenService;

	@PostMapping
	public ResponseEntity<User> saveToken(@RequestBody UserTokenSaveRequest userTokenSaveRequest) {
		System.out.println(userTokenSaveRequest.getToken());
		return new ResponseEntity<>(FCMTokenService.saveToken(userTokenSaveRequest.getToken()), HttpStatus.CREATED);
	}
}
