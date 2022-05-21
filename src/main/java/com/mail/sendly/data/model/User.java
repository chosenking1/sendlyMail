package com.mail.sendly.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@Document("Users")
@NoArgsConstructor
public class User {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @Id
    @NonNull
    @Email
    private String email;

    @NonNull
    private String password;

}
