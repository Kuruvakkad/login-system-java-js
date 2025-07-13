package com.myloginapp.login_backend;

// This class is a simple Plain Old Java Object (POJO) to hold login credentials
// received from the frontend. Spring Boot will automatically map JSON to this object.
public class LoginRequest {
    private String username;
    private String password;

    // Default constructor is important for Spring to deserialize JSON
    public LoginRequest() {
    }

    // Constructor with fields for convenience
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters for username and password
    // These are crucial for Spring to access the data from the JSON body.
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

