package com.social.chat_myster.service.implementation;

import com.social.chat_myster.data.entity.MysterUser;
import com.social.chat_myster.data.enums.Role;
import com.social.chat_myster.dto.MysterUserDto;
import com.social.chat_myster.dto.SignUpDto;
import com.social.chat_myster.dto.response.UserDetailResponse;
import com.social.chat_myster.exception.MysterUserException;
import com.social.chat_myster.repository.MysterUserRepository;
import com.social.chat_myster.service.interfaces.MysterUserUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class MysterUserService implements MysterUserUseCase {

    private final MysterUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MysterUserDto createMysterUser(SignUpDto registerUser) throws MysterUserException {

         ensureUsernameIsUniqueAndPasswordMatches(registerUser);

        registerUser.validateSignUpData();

      MysterUser newUser = buildMysterNewUser(registerUser);

      return buildMysterUserDto(newUser);
    }

    private void ensureUsernameIsUniqueAndPasswordMatches(SignUpDto registerUser) throws MysterUserException {
        Optional<MysterUser> existingUser = userRepository.findByUsername(registerUser.username());

        if (existingUser.isPresent()) {
            throw new MysterUserException("A myster user with this username already exists!", HttpStatus.CONFLICT);
        }
        if (!registerUser.password().equals(registerUser.confirmPassword())) {
            throw new IllegalArgumentException("Password does not match");
        }
    }

    private MysterUser buildMysterNewUser(SignUpDto registerUser) throws MysterUserException {
        MysterUser newUser = MysterUser.builder()
                .firstname(registerUser.firstname())
                .lastname(registerUser.lastname())
                .email(registerUser.email())
                .username(registerUser.username())
                .password(passwordEncoder.encode(registerUser.password()))
                .phoneNumber(registerUser.phoneNumber())
                .role(Role.valueOf(registerUser.role()))
                .dateCreated(ZonedDateTime.now())
                .build();
        log.info("A Myster User with username {} registered successfully", newUser.getUsername());
        userRepository.save(newUser);
        return newUser;
    }
private MysterUserDto buildMysterUserDto(MysterUser newUser){
            return MysterUserDto.builder()
            .id(newUser.getId())
            .email(newUser.getEmail())
            .firstname(newUser.getFirstname())
            .lastname(newUser.getLastname())
            .phoneNumber(newUser.getPhoneNumber())
            .username(newUser.getUsername())
            .role(String.valueOf(newUser.getRole()))
            .dateCreated(ZonedDateTime.now())
            .build();
}

    @Override
    public MysterUser findUserByUsername(String username) throws MysterUserException {
        MysterUser existingUser = userRepository.findByUsername(username).orElseThrow(()->
                new MysterUserException("User with this username not found", HttpStatus.NOT_FOUND));
        return existingUser;
    }

    @Override
    public MysterUser loadUser(String username) {
        return userRepository.findUserByUsernameIgnoreCase(username);
    }

    @Override
    public List<UserDetailResponse> getUsersDetails(Collection<String> userIds) {
        List<MysterUser> users = userRepository.findAllById(userIds);
        return users.stream()
                .map(this::getUserDetail)
                .collect(Collectors.toList());
    }

    private UserDetailResponse getUserDetail(MysterUser user) {
        return UserDetailResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }


    @Override
    public List<MysterUser> findAllUsers() {
        return userRepository.findAll();
    }


//    @Override
//    public void verifyUser(String token) throws MysterUserException {
//
//    }

}