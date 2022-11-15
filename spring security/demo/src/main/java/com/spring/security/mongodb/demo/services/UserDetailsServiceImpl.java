package com.spring.security.mongodb.demo.services;

import com.spring.security.mongodb.demo.models.UserModel;
import com.spring.security.mongodb.demo.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
    @Transactional
    public ArrayList<UserModel> loadAllUsername() throws UsernameNotFoundException {
        ArrayList<UserModel > user = new ArrayList<UserModel>();
         user = (ArrayList<UserModel>) userRepository.findAll();

        return user;
    }




}
