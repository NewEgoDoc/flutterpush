package com.example.flutterpush.service;

import com.google.firebase.messaging.FirebaseMessagingException;

public interface NotificationService {
	public String sendNotification(Long userId, String title, String body) throws FirebaseMessagingException;
}
