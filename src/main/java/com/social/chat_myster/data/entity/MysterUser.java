package com.social.chat_myster.data.entity;

import com.social.chat_myster.data.enums.Role;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class MysterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String password;
    private String phoneNumber;
    private String confirmPassword;
    @Column(unique= true)
    private String username;
    private String myUsername;
    @Enumerated(EnumType.STRING)
    private Role role;
    private ZonedDateTime dateCreated;

}
