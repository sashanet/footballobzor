package com.footballobzor.demo.service;

import com.footballobzor.demo.api.dto.MatchRequestDto;
import com.footballobzor.demo.api.dto.MatchResponseDto;

import java.util.List;

public interface MatchService {
    List<MatchResponseDto> findAll();

    MatchResponseDto save(MatchRequestDto requestDto);
}
