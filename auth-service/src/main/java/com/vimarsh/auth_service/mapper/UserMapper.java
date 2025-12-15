package com.vimarsh.auth_service.mapper;

import com.vimarsh.auth_service.dto.UserResponseDTO;
import com.vimarsh.auth_service.model.User;

public class UserMapper {
    public static UserResponseDTO toDTO(User user){
        return new UserResponseDTO(user.getUserId(),
                user.getUserName(),
                user.getUserName(),
                user.getRole());
    }
}
