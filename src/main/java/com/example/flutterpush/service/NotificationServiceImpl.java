package com.example.flutterpush.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flutterpush.entity.DeviceApp;
import com.example.flutterpush.repository.DeviceAppRepository;
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
	private final DeviceAppRepository deviceAppRepository;

	public void sendNotification(String userId, String title, String body) throws FirebaseMessagingException {
		// 사용자 ID를 기반으로 모든 DeviceApp 인스턴스 조회
		List<DeviceApp> deviceApps = deviceAppRepository.findByUserIdAndIsActiveTrue(userId);

		for (DeviceApp deviceApp : deviceApps) {
			String token = deviceApp.getToken(); // 각 DeviceApp에서 토큰 가져오기
			// System.out.println("Sending to token = " + token);

			Message message = Message.builder()
				.putData("title", title)
				.putData("body", body)
				.setToken(token)
				.build();

			firebaseMessaging.send(message);
		}
	}
}
