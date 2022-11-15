package com.spring.security.mongodb.demo.models.responseRequest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthenticationRequest {
    @NotNull
    @Size(min = 1,max = 10)
    private String username;
    @NotNull
    @Size(min = 1,max = 10)

    private String password;

    public AuthenticationRequest() {
    }

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
