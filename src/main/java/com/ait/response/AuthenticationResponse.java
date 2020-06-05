package com.ait.response;

public class AuthenticationResponse {

    private String token;
    private String role;

    public AuthenticationResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public AuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
