package com.DevOps2022.agentapplication.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.agentapplication.helper.dto.UserDTO;
import com.DevOps2022.agentapplication.model.User;

public class UserMapper implements MapperInterface<User, UserDTO>{
    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtoList) {
        List<User> users = new ArrayList<>();
        for(UserDTO dto : dtoList){
            users.add(toEntity(dto));
        }
        return users;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setUsername(entity.getUsername());
        return dto;
    }

    @Override
    public List<UserDTO> toDtoList(List<User> entityList) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : entityList){
            userDTOS.add(toDto(user));
        }
        return userDTOS;
    }
}