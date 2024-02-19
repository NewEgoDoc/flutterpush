package com.example.flutterpush.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationRequest {

	private String id;
	private String title; // 알림 제목
	private String body; // 알림 내용
}
