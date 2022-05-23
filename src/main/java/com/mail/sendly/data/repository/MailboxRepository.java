package com.mail.sendly.data.repository;

import com.mail.sendly.data.model.MailBox;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailboxRepository extends MongoRepository<MailBox, String> {
    Optional<MailBox> findAllByEmail(String email);
}
