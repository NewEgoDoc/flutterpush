package com.example.flutterpush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.flutterpush.entity.DeviceApp;
import com.example.flutterpush.entity.User;

public interface DeviceAppRepository extends JpaRepository<DeviceApp, Long> {
	@Query("SELECT da FROM DeviceApp da WHERE da.user.userid = :userId AND da.isActive = true")
	List<DeviceApp> findByUserIdAndIsActiveTrue(String userId);
}
