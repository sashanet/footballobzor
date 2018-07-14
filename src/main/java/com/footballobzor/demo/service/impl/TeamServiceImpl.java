package com.footballobzor.demo.service.impl;

import com.footballobzor.demo.api.dto.TeamDto;
import com.footballobzor.demo.persistance.entity.Team;
import com.footballobzor.demo.persistance.repository.TeamRepository;
import com.footballobzor.demo.service.TeamService;
import com.footballobzor.demo.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(entity-> Converter.converter(entity, new TeamDto()))
                .collect(Collectors.toList());
    }

    @Override
    public TeamDto save(TeamDto teamDto) {
        Team team = Converter.converter(teamDto, new Team());
        team = teamRepository.save(team);
        return Converter.converter(team, new TeamDto());
    }
}
