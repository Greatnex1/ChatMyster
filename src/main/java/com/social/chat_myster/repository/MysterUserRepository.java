package com.social.chat_myster.repository;

import com.social.chat_myster.data.entity.MysterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MysterUserRepository extends JpaRepository<MysterUser, String> {
    @Query("SELECT u FROM MysterUser u WHERE LOWER(u.username) = LOWER(:username)")
    Optional<MysterUser> findByUsername(@Param("username") String username);

    MysterUser findUserByUsernameIgnoreCase(String username);}
