package com.footballobzor.demo.utils;

import org.springframework.beans.BeanUtils;

public class Converter {

    public static  <T, K>  T converter(K source, T t){
        BeanUtils.copyProperties(source, t);
        return t;
    }
}
