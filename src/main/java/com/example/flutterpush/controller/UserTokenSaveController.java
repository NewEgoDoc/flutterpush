package com.example.flutterpush.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flutterpush.controller.dto.UserTokenSaveRequest;
import com.example.flutterpush.entity.UserToken;
import com.example.flutterpush.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tokens")
@RequiredArgsConstructor
public class UserTokenSaveController {

	private final UserTokenService userTokenService;

	@PostMapping
	public ResponseEntity<UserToken> saveToken(@RequestBody UserTokenSaveRequest userTokenSaveRequest) {
		System.out.println(userTokenSaveRequest.getToken());
		return new ResponseEntity<>(userTokenService.saveToken(userTokenSaveRequest.getToken()), HttpStatus.CREATED);
	}
}
