package com.spring.security.mongodb.demo.models.repository;

import java.util.Optional;

import com.spring.security.mongodb.demo.models.ERole;
import com.spring.security.mongodb.demo.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
