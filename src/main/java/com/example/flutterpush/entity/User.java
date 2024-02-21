package com.example.flutterpush.entity;

import static lombok.AccessLevel.*;

import java.time.LocalDateTime;
import java.util.List;

import com.example.flutterpush.support.entity.BaseIdEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "users")
@Entity
public class User extends BaseIdEntity {

	@Column(name = "user_id")
	private String userid;

	@Column
	private String password;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String role;

	@Column(name = "project_no")
	private Integer projectNo;

	@Column(name = "direct_link")
	private String directLink;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DeviceApp> deviceApps;

	@Column
	private String description;

	@Column(name = "slide_nos")
	private String slideNos; // 슬라이드 번호들이 복수일 수 있으므로 문자열로 처리, 적절한 타입으로 변경 가능

	@Column(name = "auto_save")
	private Boolean autoSave;

	@Column(name = "slide_limit")
	private Integer slideLimit;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
