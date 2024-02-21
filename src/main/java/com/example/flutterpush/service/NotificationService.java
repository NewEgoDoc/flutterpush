package com.example.flutterpush.service;

import com.google.firebase.messaging.FirebaseMessagingException;

public interface NotificationService {
	void sendNotification(String userId, String title, String body) throws FirebaseMessagingException;
}
