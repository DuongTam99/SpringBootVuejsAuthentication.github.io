package com.spring.security.mongodb.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/all")
    public ResponseEntity allAccess(){
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 1);
        responseBody.put("message","Public Content.");
        return ResponseEntity.status(200).body(responseBody);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity userAccess() {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 1);
        responseBody.put("message","User Content.");
        return ResponseEntity.status(200).body(responseBody);

    }
    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity moderatorAccess() {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 1);
        responseBody.put("message","Moderator Board.");
        return ResponseEntity.status(200).body(responseBody);

    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity adminAccess() {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 1);
        responseBody.put("message","Admin Board.");
        return ResponseEntity.status(200).body(responseBody);

    }
}
