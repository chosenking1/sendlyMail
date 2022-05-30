package com.mail.sendly.dtos.requests;

import com.mail.sendly.data.model.Message;
import com.mail.sendly.data.model.TypeOfMail;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
//@Builder
public class CreateMailbox {
    private TypeOfMail typeOfMail;
    private List<Message> messages;
}
