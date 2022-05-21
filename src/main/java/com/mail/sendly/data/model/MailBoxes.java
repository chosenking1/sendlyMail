package com.mail.sendly.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@Document("mail")
@NoArgsConstructor
public class MailBoxes {
    @Id
    private String email;
    @NonNull
    private List<MailBox> mails;

}
