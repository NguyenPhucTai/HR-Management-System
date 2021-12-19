package com.phuctai.dto;

import java.util.Set;

public class SignupRequest {

    private String userId;
    private String username;
    private String email;
    private String password;
    private Set<String> role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

}