package com.mmdoss.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmdoss.document.User;

public interface UserRepository extends MongoRepository<User, String> {

}
