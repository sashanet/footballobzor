package com.footballobzor.demo.api.dto;

import com.footballobzor.demo.api.enums.UserGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private String id;

    private String email;

    private String name;

    private String password;

    private UserGroup userGroup;

    private boolean deleted = false;

    private Date created;

}
