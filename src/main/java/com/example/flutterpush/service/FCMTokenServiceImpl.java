package com.example.flutterpush.service;

import org.springframework.stereotype.Service;

import com.example.flutterpush.entity.DeviceApp;
import com.example.flutterpush.entity.User;
import com.example.flutterpush.repository.DeviceAppRepository;
import com.example.flutterpush.repository.UserRepository;
import com.example.flutterpush.service.dto.DeleteTokenCommand;
import com.example.flutterpush.service.dto.RegisterTokenCommand;
import com.example.flutterpush.support.exception.FlutterPushRuntimeException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FCMTokenServiceImpl implements FCMTokenService {
	private final UserRepository userRepository;
	private final DeviceAppRepository deviceAppRepository;

	@Override
	public void registerToken(RegisterTokenCommand command) {
		try {
			// 사용자 ID로 사용자 엔티티 조회
			User user = userRepository.findUserByUserId(command.getUserId())
				.orElseThrow(() -> new FlutterPushRuntimeException("사용자를 찾을 수 없습니다."));

			// DeviceApp 인스턴스 생성 또는 업데이트 로직
			DeviceApp deviceApp = new DeviceApp(user, command.getOs(), command.getAppSerialNumber(), command.getToken());


			deviceAppRepository.save(deviceApp); // DeviceApp 엔티티 저장
		} catch (Exception e) {
			// 예외 처리
			throw new FlutterPushRuntimeException("토큰 등록 중 오류가 발생했습니다.", e);
		}
	}

	@Override
	public void deleteToken(DeleteTokenCommand command) {

	}
}
