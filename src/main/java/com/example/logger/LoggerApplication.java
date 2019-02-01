package com.example.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggerApplication {

	Logger logger1 = LoggerFactory.getLogger("Logger1");
	Logger logger2 = LoggerFactory.getLogger("Logger2");

	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
	}

	@Bean
	public InitializingBean initializingBean() {
		return new InitializingBean() {

			@Override
			public void afterPropertiesSet() throws Exception {
				int n = 10;
				while (n > 0) {
					logger1.info("Logger1 info = " + n);
					logger2.info("Logger2 info = " + n);
					n--;
				}
			}
		};
	}

}
