package com.mail.sendly.data.repository;

import com.mail.sendly.data.model.MailBoxes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailboxesRepository extends MongoRepository<MailBoxes, String> {
    MailBoxes findAllByEmail(String s);

}
