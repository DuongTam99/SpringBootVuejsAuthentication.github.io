package com.spring.security.mongodb.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection= "users")
public class UserModel {
    @Id
    private String id;
    @NotNull
    @Size(min = 1,max = 10)
private String username;
    @NotNull
    @Size(min = 1,max = 10)
private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();

    public UserModel() {

    }



    public String getId() {
        return id;
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
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
