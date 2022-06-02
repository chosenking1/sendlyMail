package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.repository.MailboxRepository;
import com.mail.sendly.data.repository.MessageRepository;
import com.mail.sendly.dtos.requests.SendEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;
@Autowired
    MailboxService mailboxService;
    @Override
    public void saveMessage(SendEmailRequest sendEmailRequest) {
//        mailBox.setEmail(createMailbox.get());
        Message message = new Message();
        message.setSender(sendEmailRequest.getSender());
        message.setReceiver(sendEmailRequest.getReceiver());
        message.setText(sendEmailRequest.getText());
        messageRepository.save(message);

        mailboxService.sendEmail(message);

    }
}
