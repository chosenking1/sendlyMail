package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.MailBoxes;

import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.model.TypeOfMail;
import com.mail.sendly.data.repository.MailboxRepository;
import com.mail.sendly.dtos.requests.*;
import com.mail.sendly.dtos.responses.FindMailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class MailboxServiceImpl implements MailboxService {
    @Autowired
    MailboxRepository emailRepository;


    @Override
    public void saveMailbox(CreateMailbox createMailbox) {
        MailBox mailBox = new MailBox();
        mailBox.setEmail(createMailbox.getEmail());
        mailBox.setMessage(createMailbox.getMessages());
        mailBox.setType(createMailbox.getTypeOfMail());
        emailRepository.save(mailBox);
    }
    @Override
    public void sendEmail(Message emailMessage) {
        List<MailBox> mailBox = new ArrayList<>();
        List<MailBox> receiverMailbox = new ArrayList<>();
       mailBox =  emailRepository.findAllByEmail(emailMessage.getSender());
        for (MailBox mailbox: mailBox
             ) {
            if (mailbox.getType().equals(TypeOfMail.SENT)){
                mailbox.getMessage().add(emailMessage);
                emailRepository.save(mailbox);
            }
        }


        for (String receiver:emailMessage.getReceiver()
             ) {
            receiverMailbox = emailRepository.findAllByEmail(receiver);

            for (MailBox mailbox: receiverMailbox
            ) {
                if(mailbox.getType().equals(TypeOfMail.INBOX)){

                    mailbox.getMessage().add(emailMessage);
                    emailRepository.save(mailbox);
                }
            }
        }




    }


    @Override
    public MailboxRepository getRepository() {
        return emailRepository;
    }

//    @Override
//    public List<Message> findMessageByEmail(Message message) {
//        MailBox mailBox = new MailBox();
//        mailBox = emailRepository.findAllByEmail(message.getSender());
//
//        return mailBox.getMessage();
//    }

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
