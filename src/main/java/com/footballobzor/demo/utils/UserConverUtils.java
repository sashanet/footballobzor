package com.footballobzor.demo.utils;

import com.footballobzor.demo.api.dto.UserDto;
import com.footballobzor.demo.persistance.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserConverUtils {
    public static UserEntity convert(UserDto userDto){
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(userDto, entity);
        return entity;
    }

    public static UserDto convert(UserEntity entity){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(entity, userDto);
        return userDto;
    }
}
