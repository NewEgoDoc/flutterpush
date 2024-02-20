package com.example.flutterpush.entity;

import static lombok.AccessLevel.*;

import com.example.flutterpush.support.entity.BaseIdEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "device_app")
@Entity
public class DeviceApp extends BaseIdEntity {

	@Column(nullable = false)
	private String user_id;

	@Column(nullable = false)
	private String os;

	@Column(nullable = false)
	private String appSerialNumber;

	@Column(nullable = false)
	private String token;
}
