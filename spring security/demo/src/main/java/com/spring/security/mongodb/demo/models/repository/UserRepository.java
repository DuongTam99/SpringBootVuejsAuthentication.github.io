package com.spring.security.mongodb.demo.models.repository;

import com.spring.security.mongodb.demo.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
    Optional<UserModel> findByUsername(String username);
    Boolean existsByUsername(String username);


}

