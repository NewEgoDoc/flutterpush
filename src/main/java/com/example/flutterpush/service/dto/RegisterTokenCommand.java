package com.example.flutterpush.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterTokenCommand {
	private String userId; // 사용자 ID
	private String os; // 운영체제
	private String token; // 토큰 값
	private String appSerialNumber; // 앱 일련번호
}
