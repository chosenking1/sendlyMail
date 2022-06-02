package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.MailBoxes;
import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.repository.MailboxRepository;
import com.mail.sendly.dtos.requests.*;
import com.mail.sendly.dtos.responses.FindMailResponse;

import java.util.List;

public interface MailboxService {
    void saveMailbox(CreateMailbox createMailbox);

    void sendEmail(Message emailMessage);

    MailboxRepository getRepository();



    List<FindMailResponse> findMessageByEmail(String userEmail);

    String deleteInbox(MailBoxes id, DeleteInboxRequest deleteInbox);

    String deleteInbox(MailBox id, DeleteInboxRequest deleteInbox);

    String deleteInbox(String id, DeleteInboxRequest deleteInbox);

    String deleteOutbox(MailBoxes id, DeleteOutboxRequest deleteOutbox);
    String deleteOutbox(String id, DeleteOutboxRequest deleteOutbox);

    String deleteAllMail(MailBox id, DeleteAllEmails deleteAllEmails);

}
