package com.example.flutterpush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flutterpush.controller.dto.NotificationRequest;
import com.example.flutterpush.service.NotificationService;
import com.example.flutterpush.service.NotificationServiceImpl;
import com.google.firebase.messaging.FirebaseMessagingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NotificationController {

	private final NotificationService notificationServiceImpl;

	@PostMapping("/send-notification")
	public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
		System.out.println("request = " + request.getId());

		try {
			String response = notificationServiceImpl.sendNotification(Long.parseLong(request.getId()), request.getTitle(), request.getBody());
			System.out.println("response = " + response);
			return ResponseEntity.ok("Notification sent successfully. Response: " + response);
		} catch (FirebaseMessagingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send notification");
		}
	}
}