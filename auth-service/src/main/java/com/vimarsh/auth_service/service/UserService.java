package com.vimarsh.auth_service.service;

import com.vimarsh.auth_service.dto.UserRequestDTO;
import com.vimarsh.auth_service.dto.UserResponseDTO;
import com.vimarsh.auth_service.model.User;
import com.vimarsh.auth_service.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.lang.System.in;

@Service
public class UserService {

    private final AuthRepository authRepository ;

    public UserService(AuthRepository authRepository) {
        this.authRepository= authRepository ;
    }


    public UserResponseDTO[] GetAllUsers() {
        List<User> users = authRepository.findAll() ;
        int n =users.size() ;
        UserResponseDTO[] userResponseDTOs = new UserResponseDTO[n] ;
        for(int i=0;i<n;i++){
            userResponseDTOs[i].setUserId(users.get(i).getUserId());
            userResponseDTOs[i].setUserName(users.get(i).getUserName());
            userResponseDTOs[i].setUserEmail(users.get(i).getUserEmail());
            userResponseDTOs[i].setUserRole(users.get(i).getRole());
        }
        return userResponseDTOs;
    }

    public UserResponseDTO GetUserById(UUID userId) {
        User user = authRepository.findById(userId).
                orElseThrow(()-> new RuntimeException("User with Id not found"));
        UserResponseDTO userResponseDTO= new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setUserName(user.getUserName());
        return userResponseDTO ;
    }

    public UserResponseDTO GetUserByEmail(String userEmail) {
        User user = authRepository.findByUserEmail(userEmail).
                orElseThrow(()-> new RuntimeException("User with Id not found"));
        UserResponseDTO userResponseDTO= new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setUserName(user.getUserName());
        return userResponseDTO ;
    }

    public UserResponseDTO CreateUser(UserRequestDTO userRequestDTO){
        User user = new User(
                userRequestDTO.getUserName(),
                userRequestDTO.getUserEmail(),
                userRequestDTO.getUserPassword(),
                userRequestDTO.getUserRole()
        ) ;
        user= authRepository.save(user) ;
        return new UserResponseDTO(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getRole()
        );
    }

    public UserResponseDTO UpdateUser(UserRequestDTO userRequestDTO){
        User user= authRepository.findByUserEmail(userRequestDTO.getUserEmail()).
                orElseThrow(()-> new RuntimeException("User was not found")) ;
        user= authRepository.save(user) ;
        return new UserResponseDTO(user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getRole()) ;
    }

    public UserResponseDTO DeleteUserByEmail(String userEmail){
        authRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User was not found"));
        User user= authRepository.deleteByUserEmail(userEmail)
                .orElseThrow(()-> new RuntimeException("Error occured while deleting the user")) ;
        return new UserResponseDTO(user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getRole()) ;
    }

    public UserResponseDTO DeleteUserById(String uid){
        java.util.UUID userId = UUID.fromString(uid) ;
        User user = authRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Error finding user with provided ID"));
        authRepository.deleteById(userId);
        return new UserResponseDTO(user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getRole());
    }
}
