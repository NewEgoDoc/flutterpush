package com.example.flutterpush.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@Configuration
public class FCMConfig {

	@Bean
	public FirebaseMessaging firebaseMessaging() throws IOException {
		// 클래스패스 내의 파일에 접근할 경로를 정의합니다.
		String path = "firebase/flutter-push-6b7cc-firebase-adminsdk-1vigy-131adda468.json";

		// 클래스패스 리소스 경로를 사용하여 FileInputStream을 생성합니다.
		FileInputStream serviceAccount = new FileInputStream(new ClassPathResource(path).getFile());

		FirebaseApp firebaseApp = null;
		List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
		if (!firebaseApps.isEmpty()) {
			for (FirebaseApp app : firebaseApps) {
				if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
					firebaseApp = app;
					break;
				}
			}
		} else {
			FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

			firebaseApp = FirebaseApp.initializeApp(options);
		}

		return FirebaseMessaging.getInstance(firebaseApp);
	}

}
