package com.footballobzor.demo.service.impl;

import com.footballobzor.demo.api.dto.BroadCastDto;
import com.footballobzor.demo.persistance.entity.BroadcastEntity;
import com.footballobzor.demo.persistance.repository.BroadCastRepository;
import com.footballobzor.demo.service.BroadCastService;
import com.footballobzor.demo.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BroadCastServiceImpl implements BroadCastService {

    private final BroadCastRepository broadCastRepository;

    @Override
    public List<BroadCastDto> getAllBroadcasts() {
        List<BroadcastEntity> broadcastEntities = broadCastRepository.findAll();

        return broadcastEntities.stream()
                .map(entity-> Converter.converter(entity, new BroadCastDto()))
                .collect(Collectors.toList());
    }

    @Override
    public BroadCastDto save(BroadCastDto broadCastDto) {
      BroadcastEntity entity = Converter.converter(broadCastDto, new BroadcastEntity());
        entity = broadCastRepository.save(entity);
        return Converter.converter(entity, new BroadCastDto());
    }
}
