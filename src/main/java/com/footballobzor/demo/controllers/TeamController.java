package com.footballobzor.demo.controllers;

import com.footballobzor.demo.api.dto.TeamDto;
import com.footballobzor.demo.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams/")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping()
    public ResponseEntity<List<TeamDto>> findAll(){
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamDto> save(@RequestBody TeamDto teamDto){
        return new ResponseEntity<>(teamService.save(teamDto), HttpStatus.OK);
    }
}
