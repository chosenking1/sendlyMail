package com.mail.sendly.services;

import com.mail.sendly.dtos.requests.SendEmailRequest;

public interface MessageService {
    void saveMessage(SendEmailRequest sendEmailRequest);
}
