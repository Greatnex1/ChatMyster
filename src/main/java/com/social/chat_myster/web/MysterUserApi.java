package com.social.chat_myster.web;

import com.social.chat_myster.dto.ApiResponse;
import com.social.chat_myster.dto.MysterUserDto;
import com.social.chat_myster.dto.SignUpDto;
import com.social.chat_myster.exception.MysterUserException;
import com.social.chat_myster.service.implementation.MysterUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.ZonedDateTime;

import static com.social.chat_myster.constants.UrlConstant.URL_CONSTANT;

@AllArgsConstructor
@RestController
@RequestMapping(URL_CONSTANT + "/users")
@Tag(name="Chat Myster User Endpoint",
        description = "This class implements user's registration on the application"
)
public class MysterUserApi {

    private MysterUserService userService;

    @PostMapping("/register")
    @Operation(summary= "Create a new user")
    public ResponseEntity<ApiResponse<MysterUserDto>> createAccount(@RequestBody SignUpDto userDto) throws MysterUserException {
     MysterUserDto mysterUserDto =   userService.createMysterUser(userDto);
        ApiResponse<MysterUserDto> response = ApiResponse.<MysterUserDto>builder()
                .isSuccessful(true)
                .statusCode(HttpStatus.CREATED.value())
                .message("Myster user created successfully")
                .timeStamp(ZonedDateTime.now())
                .build();
       return new ResponseEntity<>(response.created(mysterUserDto,"Myster User Onboarded"), HttpStatus.CREATED);
    }
}
