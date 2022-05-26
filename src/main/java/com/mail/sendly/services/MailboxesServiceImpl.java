package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBoxes;
import com.mail.sendly.data.repository.MailboxesRepository;
import com.mail.sendly.data.repository.UserRepository;
import com.mail.sendly.dtos.requests.CreateMailboxes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxesServiceImpl implements MailboxesService{
    @Autowired
    private MailboxesRepository mailboxesRepository;


    @Override
    public void saveMailboxes(CreateMailboxes createMailboxes) {
        MailBoxes mailBoxes = new MailBoxes();
        mailBoxes.setEmail(createMailboxes.getEmail());
        mailBoxes.setMails(createMailboxes.getMailbox());
        mailboxesRepository.save(mailBoxes);

    }

    //    @Override
//    public void saveMailboxes(Class<CreateMailboxes> createMailboxesClass) {
//
//    }
}
