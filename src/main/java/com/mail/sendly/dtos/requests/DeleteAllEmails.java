package com.mail.sendly.dtos.requests;

import com.mail.sendly.data.model.MailBox;
import lombok.Data;

@Data
public class DeleteAllEmails {
    private String email;
}
