package com.footballobzor.demo.utils;

import com.footballobzor.demo.api.dto.FileDto;
import com.footballobzor.demo.persistance.entity.FileEntity;
import org.springframework.beans.BeanUtils;

public class FileConvertUtils {
    public static FileEntity convert(FileDto fileDto){
        FileEntity entity = new FileEntity();
        BeanUtils.copyProperties(fileDto, entity);
        return entity;
    }

    public static FileDto convert(FileEntity entity){
        FileDto fileDto = new FileDto();
        BeanUtils.copyProperties(entity, fileDto);
        return fileDto;
    }
}
