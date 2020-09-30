package com.cg.movieticketsystem.dto.request;

import javax.validation.constraints.*;

public class SignupRequest {

    @NotBlank(message = "User Name must not be empty")
    private String username;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @Size(message="Password Must be equal or greater than 8 and less than 20", min = 8, max = 20)
    private String password;

    @NotBlank(message = "Contact Must not be empty")
    private String contact;
    
    public SignupRequest() {
	
	}

    public SignupRequest(String username, String email, String password, String contact) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
