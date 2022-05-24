package com.mail.sendly.dtos.requests;

import com.mail.sendly.data.model.MailBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
//@Builder
public class CreateMailboxes {
    private String email;
    private List <MailBox> mailbox;

}
