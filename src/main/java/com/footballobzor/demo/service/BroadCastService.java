package com.footballobzor.demo.service;

import com.footballobzor.demo.api.dto.BroadCastDto;

import java.util.List;

public interface BroadCastService {
    List<BroadCastDto> getAllBroadcasts();

    BroadCastDto save(BroadCastDto broadCastDto);
}
