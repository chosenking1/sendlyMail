package com.mail.sendly.data.repository;

import com.mail.sendly.data.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends MongoRepository<Message,String> {
    @Override
    Optional<Message> findById(String iD);
}
