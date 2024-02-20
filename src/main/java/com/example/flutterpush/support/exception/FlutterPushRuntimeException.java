package com.example.flutterpush.support.exception;

/**
 * 버그 및 공격 상황 처리를 위한 커스텀 예외
 * <br> e.g.) 없는 아이디로 조회를 요청하는 경우
 */
public class FlutterPushRuntimeException extends RuntimeException {

	public FlutterPushRuntimeException(final String message) {
		super(message);
	}

	public FlutterPushRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
