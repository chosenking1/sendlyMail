package com.mail.sendly.dtos.requests;

import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.model.TypeOfMail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor

public class SendEmailRequest {

    private String sender;
    private String receiver;
    private String text;

}
