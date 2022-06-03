package com.mail.sendly.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor

public class SendEmailRequest {

    private String sender;
    private List <String> receiver;
    private String text;

}
