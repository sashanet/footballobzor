package com.footballobzor.demo.controllers;

import com.footballobzor.demo.api.dto.UserDto;
import com.footballobzor.demo.service.UserService;
import com.footballobzor.demo.utils.UserConverUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public List<UserDto> findAll(Authentication authResult){
        return userService.getAllUsers().stream().map(UserConverUtils::convert).collect(Collectors.toList());
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, consumes = "application/json")
    public UserDto signUp(@RequestBody UserDto user){
        return UserConverUtils.convert(userService.saveNewUser(user));
    }

}
