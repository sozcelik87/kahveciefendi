package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to application.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

	private final Jwt jwt = new Jwt();

	public Jwt getJwt() {
		return jwt;
	}

	public static class Jwt {
		private String key;
		private Long expiration;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Long getExpiration() {
			return expiration;
		}

		public void setExpiration(Long expiration) {
			this.expiration = expiration;
		}
	}
}
