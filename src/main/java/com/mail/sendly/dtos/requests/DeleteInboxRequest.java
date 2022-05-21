package com.mail.sendly.dtos.requests;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.TypeOfMail;

public class DeleteInboxRequest {
    private TypeOfMail mailType;
    private MailBox mailBox;
}
