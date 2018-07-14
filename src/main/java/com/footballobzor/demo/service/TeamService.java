package com.footballobzor.demo.service;

import com.footballobzor.demo.api.dto.TeamDto;

import java.util.List;

public interface TeamService {
    List<TeamDto> getAllTeams();

    TeamDto save(TeamDto teamDto);
}
