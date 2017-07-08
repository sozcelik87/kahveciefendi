package com.example.dto;

public class JWTTokenDTO {

    private String token;

	public JWTTokenDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
}
