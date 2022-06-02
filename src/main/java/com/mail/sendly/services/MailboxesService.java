package com.mail.sendly.services;

import com.mail.sendly.dtos.requests.CreateMailboxes;
import com.mail.sendly.dtos.requests.SendEmailRequest;
import com.mail.sendly.dtos.responses.SentEmailResponse;

public interface MailboxesService {

//    void saveMailboxes(Class<CreateMailboxes> createMailboxesClass);
    SentEmailResponse sendMessage(SendEmailRequest sendEmailRequest);



    void saveMailboxes(CreateMailboxes createMailboxesClass);
}
