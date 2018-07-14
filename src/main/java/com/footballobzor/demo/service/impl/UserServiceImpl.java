package com.footballobzor.demo.service.impl;

import com.footballobzor.demo.api.dto.UserDto;
import com.footballobzor.demo.persistance.entity.UserEntity;
import com.footballobzor.demo.persistance.repository.UserRepository;
import com.footballobzor.demo.service.UserService;
import com.footballobzor.demo.utils.UserConverUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findUserById(String userId) {
        return null;
    }

    @Override
    public UserEntity saveNewUser(UserDto userDto) {
        UserEntity user = UserConverUtils.convert(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}
