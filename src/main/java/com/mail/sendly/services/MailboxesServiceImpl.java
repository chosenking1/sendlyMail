package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.MailBoxes;
import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.model.TypeOfMail;
import com.mail.sendly.data.repository.MailboxRepository;
import com.mail.sendly.data.repository.MailboxesRepository;
import com.mail.sendly.dtos.requests.CreateMailbox;
import com.mail.sendly.dtos.requests.CreateMailboxes;
import com.mail.sendly.dtos.requests.SendEmailRequest;
import com.mail.sendly.dtos.responses.SentEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MailboxesServiceImpl implements MailboxesService{
    @Autowired
    private MailboxesRepository mailboxesRepository;

    @Autowired
    MailboxService mailboxService;

    @Autowired
    MessageService messageService;

    @Autowired
    MailboxRepository mailboxRepository;
    @Override
    public SentEmailResponse sendMessage(SendEmailRequest sendEmailRequest) {
        messageService.saveMessage(sendEmailRequest);
        MailBoxes mailBoxes = new MailBoxes();
       List <MailBox> mailBox = new ArrayList<>();

       mailBox = mailboxRepository.findAllByEmail(sendEmailRequest.getSender());
        for (MailBox mailbox: mailBox
        ) {
                mailBoxes = mailboxesRepository.findAllByEmail(mailbox.getEmail());
                mailBoxes.setMails(mailBox);
                mailboxesRepository.save(mailBoxes);
        }

        receiveEmail(sendEmailRequest);


        SentEmailResponse sentEmailResponse = new SentEmailResponse();
        sentEmailResponse.setResponse("Message Sent");
        return sentEmailResponse;

    }

    @Override
    public void saveMailboxes(CreateMailboxes createMailboxes) {
        CreateMailbox createMailbox = new CreateMailbox(TypeOfMail.INBOX, Collections.singletonList(new Message()), createMailboxes.getEmail());
        CreateMailbox createMailboxOutbox = new CreateMailbox(TypeOfMail.SENT, Collections.singletonList(new Message()), createMailboxes.getEmail());

        mailboxService.saveMailbox(createMailbox);
        mailboxService.saveMailbox(createMailboxOutbox);

        MailBoxes mailBoxes = new MailBoxes();
        mailBoxes.setEmail(createMailboxes.getEmail());
        mailBoxes.setMails(createMailboxes.getMailbox());
        mailboxesRepository.save(mailBoxes);
    }

    private void receiveEmail(SendEmailRequest sendEmailRequest){
        List <MailBox> mailBox = new ArrayList<>();
        MailBoxes mailBoxes = new MailBoxes();

        mailBox = mailboxRepository.findAllByEmail(sendEmailRequest.getReceiver());
        for (MailBox mailbox: mailBox
        ) {
            mailBoxes = mailboxesRepository.findAllByEmail(mailbox.getEmail());
            mailBoxes.setMails(mailBox);
            mailboxesRepository.save(mailBoxes);
        }
    }

    //    @Override
//    public void saveMailboxes(Class<CreateMailboxes> createMailboxesClass) {
//
//    }
}
