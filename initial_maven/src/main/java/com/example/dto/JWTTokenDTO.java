package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTTokenDTO {

    private String idToken;

    public JWTTokenDTO(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
