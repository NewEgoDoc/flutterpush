package com.example.flutterpush.service;

import org.springframework.stereotype.Service;

import com.example.flutterpush.repository.UserRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{

	private final UserRepository userRepository;
	private final FirebaseMessaging firebaseMessaging;

	public String sendNotification(Long userId, String title, String body) throws FirebaseMessagingException {
		String token = userRepository
			.findById(userId)
			.get()
			.getToken();
		System.out.println("token = " + token);
		Message message = Message.builder()
			.putData("title", title)
			.putData("body", body)
			.setToken(token)
			.build();

		// 메시지 보내기
		return firebaseMessaging.send(message);
	}
}
