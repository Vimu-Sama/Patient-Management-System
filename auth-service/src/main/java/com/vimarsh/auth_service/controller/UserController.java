package com.vimarsh.auth_service.controller;

import com.vimarsh.auth_service.dto.UserRequestDTO;
import com.vimarsh.auth_service.dto.UserResponseDTO;
import com.vimarsh.auth_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name= "User Auth APIs")
public class UserController {
    private UserService userService ;

    public UserController(UserService userService){
        this.userService = userService ;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Patient")
    public ResponseEntity<UserResponseDTO> GetUser(@PathVariable UUID id){
        UserResponseDTO userResponseDTO = userService.GetUserById(id) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

    @GetMapping("/{userEmail}")
    @Operation(summary= "Get Patient through Email")
    public ResponseEntity<UserResponseDTO> GetUserByEmail(@PathVariable String userEmail){
        UserResponseDTO userResponseDTO = userService.GetUserByEmail(userEmail) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

//    @PostMapping("{/create}")
//    @Operation(summary= "Create New User")
//    public ResponseEntity<UserResponseDTO>
}
