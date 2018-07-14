package com.footballobzor.demo.service.impl;

import com.footballobzor.demo.persistance.entity.UserEntity;
import com.footballobzor.demo.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        //    UserEntity userEntity = userRepository.findByEmail(username);

        UserEntity user = userRepository.findByEmail(email);

        return user;
    }
}