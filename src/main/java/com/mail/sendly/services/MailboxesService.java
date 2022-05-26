package com.mail.sendly.services;

import com.mail.sendly.dtos.requests.CreateMailboxes;

public interface MailboxesService {

//    void saveMailboxes(Class<CreateMailboxes> createMailboxesClass);

    void saveMailboxes(CreateMailboxes createMailboxesClass);
}
