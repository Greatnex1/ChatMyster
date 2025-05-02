package com.social.chat_myster.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document("chat_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {
    @Id
    private String id;
    private String name;
    private Set<String> participantIds = new HashSet<>();
    private Set<String> adminIds = new HashSet<>();
    private List<ChatRoomMessage> messages = new ArrayList<>();
    private LocalDateTime dateCreated;
    private Instant dateUpdated = Instant.now();
    private boolean isGroup;

}
