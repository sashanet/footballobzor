package com.footballobzor.demo.service.impl;

import com.footballobzor.demo.api.dto.MatchRequestDto;
import com.footballobzor.demo.api.dto.MatchResponseDto;
import com.footballobzor.demo.persistance.repository.MatchRepository;
import com.footballobzor.demo.service.MatchService;
import com.footballobzor.demo.utils.MatchConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {


    private final MatchRepository matchRepository;
    @Override
    public List<MatchResponseDto> findAll() {
        return matchRepository.findAll().stream().map(MatchConverter::convert).collect(Collectors.toList());
    }

    @Override
    public MatchResponseDto save(MatchRequestDto requestDto) {
        return null;
    }
}
