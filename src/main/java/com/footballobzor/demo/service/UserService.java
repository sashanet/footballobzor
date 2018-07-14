package com.footballobzor.demo.service;

import com.footballobzor.demo.api.dto.UserDto;
import com.footballobzor.demo.persistance.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity findUserById(String userId);

    UserEntity saveNewUser(UserDto userDto);
}
