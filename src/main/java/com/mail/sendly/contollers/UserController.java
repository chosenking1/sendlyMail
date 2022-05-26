package com.mail.sendly.contollers;

import com.mail.sendly.dtos.requests.RegisterUserRequest;
import com.mail.sendly.dtos.responses.RegisterUserResponse;
import com.mail.sendly.services.MailboxesService;
import com.mail.sendly.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Users")
public class UserController {

        @Autowired
        private UserService userService;

        @Autowired
        private MailboxesService mailboxesService;

        @PostMapping("/save")
        public RegisterUserResponse saveUser(@RequestBody RegisterUserRequest request)
        {

            return userService.saveUser(request);
        }

//        @GetMapping("/{keyword}")
//        public List<FindUrlResponse> findUrlByContractedUrl(@PathVariable("keyword") String contractedUrl) {
//            return urlService.findUrlByContractedUrl(contractedUrl);
//        }

}
