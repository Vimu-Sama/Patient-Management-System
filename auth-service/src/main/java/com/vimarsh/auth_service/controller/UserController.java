package com.vimarsh.auth_service.controller;

import com.vimarsh.auth_service.dto.UserRequestDTO;
import com.vimarsh.auth_service.dto.UserResponseDTO;
import com.vimarsh.auth_service.model.User;
import com.vimarsh.auth_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name= "User Auth APIs")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService ;

    public UserController(UserService userService){
        this.userService = userService ;
    }

    @GetMapping
    @Operation(summary = "Get all Users")
    public ResponseEntity<UserResponseDTO[]> GetAllUsers(){
        UserResponseDTO[] userResponseDTO = userService.GetAllUsers() ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get Patient")
    public ResponseEntity<UserResponseDTO> GetUser(@PathVariable UUID id){
        UserResponseDTO userResponseDTO = userService.GetUserById(id) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

    @GetMapping("/email/{userEmail}")
    @Operation(summary= "Get Patient through Email")
    public ResponseEntity<UserResponseDTO> GetUserByEmail(@PathVariable String userEmail){
        UserResponseDTO userResponseDTO = userService.GetUserByEmail(userEmail) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

    @PostMapping("/create")
    @Operation(summary= "Create New User")
    public ResponseEntity<UserResponseDTO> CreateUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO= userService.CreateUser(userRequestDTO);
        log.info("response returned-> {}",userResponseDTO) ;
        return ResponseEntity.ok(userResponseDTO) ;
    }

    @PostMapping("/update")
    @Operation(summary= "Update User")
    public ResponseEntity<UserResponseDTO> UpdateUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.UpdateUser(userRequestDTO) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

    @DeleteMapping("/delete/{userEmail}")
    @Operation(summary= "Delete User via Email")
    public ResponseEntity<UserResponseDTO> DeleteUserByEmail(@PathVariable String userEmail){
        UserResponseDTO userResponseDTO = userService.DeleteUserByEmail(userEmail) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }

    @DeleteMapping("/delete/{userId}")
    @Operation(summary= "Delete User via Id")
    public ResponseEntity<UserResponseDTO> DeleteUserById(@PathVariable String userId){
        UserResponseDTO userResponseDTO = userService.DeleteUserById(userId) ;
        return ResponseEntity.ok().body(userResponseDTO) ;
    }
}
