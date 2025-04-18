package com.social.chat_myster.repository;

import com.social.chat_myster.data.entity.MysterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MysterUserRepository extends JpaRepository<MysterUser, String> {
    Optional<MysterUser> findByEmail(String email);
}
