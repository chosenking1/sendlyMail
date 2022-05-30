package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.MailBoxes;

import com.mail.sendly.data.repository.MailboxRepository;
import com.mail.sendly.dtos.requests.*;
import com.mail.sendly.dtos.responses.FindMailResponse;
import com.mail.sendly.dtos.responses.SentEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class MailboxServiceImpl implements MailboxService {
    @Autowired
    MailboxRepository emailRepository;


    @Override
    public void saveMailbox(CreateMailbox createMailbox) {
        MailBox mailBox = new MailBox();
//        mailBox.setEmail(createMailbox.get());
        mailBox.setMessage(createMailbox.getMessages());
        mailBox.setType(Collections.singletonList(createMailbox.getTypeOfMail()));
        emailRepository.save(mailBox);
    }
    @Override
    public SentEmailResponse sendEmail(SendEmailRequest emailMessage) {
        return null;
    }


    @Override
    public MailboxRepository getRepository() {
        return emailRepository;
    }

    @Override
    public List<FindMailResponse> findMessageByEmail(String userEmail) {
        return null;
    }

    @Override
    public String deleteInbox(MailBoxes id, DeleteInboxRequest deleteInbox) {
        return null;
    }

    @Override
    public String deleteInbox(MailBox id, DeleteInboxRequest deleteInbox) {
        return null;
    }

    @Override
    public String deleteInbox(String id, DeleteInboxRequest deleteInbox) {
        return null;
    }

    @Override
    public String deleteOutbox(MailBoxes id, DeleteOutboxRequest deleteOutbox) {
        return null;
    }

    @Override
    public String deleteOutbox(String id, DeleteOutboxRequest deleteOutbox) {
        return null;
    }

    @Override
    public String deleteAllMail(MailBox id, DeleteAllEmails deleteAllEmails) {
        return null;
    }
}
