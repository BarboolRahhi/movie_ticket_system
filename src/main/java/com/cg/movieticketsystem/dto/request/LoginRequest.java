package com.cg.movieticketsystem.dto.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Password must not be empty")
    private String password;
    
    public LoginRequest() {
		
	}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
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
}
