package com.mail.sendly.dtos.requests;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
@Setter
@Getter
@AllArgsConstructor
//@Builder
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
