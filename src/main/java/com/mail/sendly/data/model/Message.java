package com.mail.sendly.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@Document("message")
@NoArgsConstructor
public class Message {
    @Id
    private String id;
    @NonNull
    private String sender;
    private LocalDateTime creationTime;
    private String receiver;
    private boolean isRead = false;
    private String text;

}
