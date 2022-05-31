package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBoxes;
import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.model.TypeOfMail;
import com.mail.sendly.data.repository.MailboxesRepository;
import com.mail.sendly.data.repository.UserRepository;
import com.mail.sendly.dtos.requests.CreateMailbox;
import com.mail.sendly.dtos.requests.CreateMailboxes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MailboxesServiceImpl implements MailboxesService{
    @Autowired
    private MailboxesRepository mailboxesRepository;

    @Autowired
    MailboxService mailboxService;


    @Override
    public void saveMailboxes(CreateMailboxes createMailboxes) {
        CreateMailbox createMailbox = new CreateMailbox(TypeOfMail.INBOX, Collections.singletonList(new Message()));
        CreateMailbox createMailboxOutbox = new CreateMailbox(TypeOfMail.SENT, Collections.singletonList(new Message()));

//        createMailbox.setMessages(Collections.singletonList(new Message()));
        mailboxService.saveMailbox(createMailbox);
        mailboxService.saveMailbox(createMailboxOutbox);

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
