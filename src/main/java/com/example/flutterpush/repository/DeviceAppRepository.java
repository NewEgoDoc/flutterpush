package com.example.flutterpush.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flutterpush.entity.DeviceApp;
import com.example.flutterpush.entity.User;

public interface DeviceAppRepository extends JpaRepository<DeviceApp, Long> {
}
