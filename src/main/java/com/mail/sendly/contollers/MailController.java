package com.mail.sendly.contollers;

import com.mail.sendly.dtos.requests.RegisterUserRequest;
import com.mail.sendly.dtos.requests.SendEmailRequest;
import com.mail.sendly.dtos.responses.RegisterUserResponse;
import com.mail.sendly.dtos.responses.SentEmailResponse;
import com.mail.sendly.services.MailboxesService;
import com.mail.sendly.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mailbox")
public class MailController {


        @Autowired
        private MailboxesService mailboxesService;

    @PostMapping("/send")
    public SentEmailResponse sendMessage(@RequestBody SendEmailRequest request)
    {
        return mailboxesService.sendMessage(request);
    }

}
