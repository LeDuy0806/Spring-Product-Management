package com.overpower.ProductManagementApi.repository;


import com.overpower.ProductManagementApi.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
//    Optional<User> findById(String Id);
}
