package com.example.flutterpush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flutterpush.entity.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {
}

