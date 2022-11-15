package com.spring.security.mongodb.demo.controller;

import com.spring.security.mongodb.demo.models.*;
import com.spring.security.mongodb.demo.models.repository.RoleRepository;
import com.spring.security.mongodb.demo.models.repository.UserRepository;
import com.spring.security.mongodb.demo.models.responseRequest.AuthenticationResponse;
import com.spring.security.mongodb.demo.models.responseRequest.LoginRequest;
import com.spring.security.mongodb.demo.models.responseRequest.SignupRequest;
import com.spring.security.mongodb.demo.jwt.JwtUtils;

import com.spring.security.mongodb.demo.services.UserDetailsImpl;
import com.spring.security.mongodb.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/dashboard")
    public ResponseEntity testingToken() {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 1);
        responseBody.put("data",  userRepository.findAll());
        responseBody.put("message", "Succesful, Welcome to the dashboard " + SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.status(200).body(userRepository.findAll());

    }


    @PostMapping("/register")
    public ResponseEntity<?> subscribeClient(@RequestBody @Valid SignupRequest signUpRequest) {
        Map<String, Object> responseBody = new HashMap<>();
        String username = signUpRequest.getUsername();
        UserModel addUserModel = new UserModel();
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            responseBody.put("status", 0);
            responseBody.put("data", "Null");
            responseBody.put("message", "Error during client Subscription " + username + " because already");
            return ResponseEntity.status(400).body(responseBody);
        }
        try {
            //tao doi tuong de thu chien encodepassword ma hoa mat khau khi dang ki
            addUserModel.setUsername(signUpRequest.getUsername());
            addUserModel.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            Set<String> strRoles = signUpRequest.getRoles();

            Set<Role> roles = new HashSet<>();
            if (strRoles == null) {
                Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            } else {
                strRoles.forEach((role) -> {
                    if ("admin".equals(role)) {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    } else if ("mod".equals(role)) {
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    } else {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                });
            }
            addUserModel.setRoles(roles);
            userRepository.save(addUserModel);
        } catch (Exception e) {
            responseBody.put("status", 0);
            responseBody.put("data", "Null");
            responseBody.put("message", "Error during client Subscription " + username);
            return ResponseEntity.status(400).body(responseBody);
            // return ResponseEntity.ok(new AuthenticationResponse("Error during client Subscription " + username));
        }
        responseBody.put("status", 1);
        responseBody.put("data", "hide");
        responseBody.put("message", "Succesful Subscription for client " + username);
        return ResponseEntity.status(200).body(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity authenticateClient(@RequestBody @Valid LoginRequest loginRequest) {
        Map<String, Object> responseBody = new HashMap<>();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            return ResponseEntity.ok(new AuthenticationResponse("Error during client Authentication " + username));
        }
        UserDetails loadedUser = userDetailsServiceImpl.loadUserByUsername(username);

        String generateToken = jwtUtils.generateToken(loadedUser);
        responseBody.put("Id", userDetails.getId());
        responseBody.put("username", username);
        responseBody.put("status", 1);
        responseBody.put("data", "hide");
        responseBody.put("message", "Succesful for login " + username);
        responseBody.put("Token", generateToken);
        responseBody.put("roles", roles.toString());

        return ResponseEntity.status(200).body(responseBody);
    }
}
