package com.example.flutterpush.entity;

import static lombok.AccessLevel.*;

import com.example.flutterpush.support.entity.BaseIdEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "device_app")
@Entity
public class DeviceApp extends BaseIdEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(nullable = false)
	private String os;

	@Column(nullable = false)
	private String appSerialNumber;

	@Column(nullable = false)
	private String token;

	// 사용 유무를 나타내는 컬럼 추가
	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;

	// 사용자 정의 생성자
	public DeviceApp(User user, String os, String appSerialNumber, String token) {
		this.user = user;
		this.os = os;
		this.appSerialNumber = appSerialNumber;
		this.token = token;
		// isActive는 기본값으로 true가 설정되어 있으므로 별도로 초기화하지 않습니다.
	}
}
