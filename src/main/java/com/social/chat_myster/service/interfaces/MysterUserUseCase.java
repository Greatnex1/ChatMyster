package com.social.chat_myster.service.interfaces;

import com.social.chat_myster.data.entity.MysterUser;
import com.social.chat_myster.dto.MysterUserDto;
import com.social.chat_myster.dto.SignUpDto;
import com.social.chat_myster.exception.MysterUserException;

import java.util.List;

public interface MysterUserUseCase {
MysterUserDto createMysterUser(SignUpDto registerUser) throws MysterUserException;
    MysterUserDto findUserById(String userId) throws MysterUserException;
    List<MysterUserDto> findAllUsers();
//    MysterUserDto updateUserProfile(String id, UpdateRequest updateRequest) throws MysterUserException;
    MysterUser findUserByEmail(String email) throws MysterUserException;
    void verifyUser(String token) throws MysterUserException;
}
