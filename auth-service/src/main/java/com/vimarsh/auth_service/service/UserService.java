package com.vimarsh.auth_service.service;

import com.vimarsh.auth_service.dto.UserResponseDTO;
import com.vimarsh.auth_service.model.User;
import com.vimarsh.auth_service.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private AuthRepository authRepository ;

    public UserService(AuthRepository authRepository) {
        this.authRepository= authRepository ;
    }

    public UserResponseDTO GetUserById(UUID userId) {
        com.vimarsh.auth_service.model.User user = authRepository.findById(userId).
                orElseThrow(()-> new RuntimeException("User with Id not found"));
        UserResponseDTO userResponseDTO= new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setUserName(user.getUserName());
        return userResponseDTO ;
    }

    public UserResponseDTO GetUserByEmail(String userEmail) {
        com.vimarsh.auth_service.model.User user = authRepository.findByUserEmail(userEmail).
                orElseThrow(()-> new RuntimeException("User with Id not found"));
        UserResponseDTO userResponseDTO= new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setUserName(user.getUserName());
        return userResponseDTO ;
    }
}
