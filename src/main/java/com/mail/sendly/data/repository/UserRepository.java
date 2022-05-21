package com.mail.sendly.data.repository;

import com.mail.sendly.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<?> findByEmail(String email);
}
