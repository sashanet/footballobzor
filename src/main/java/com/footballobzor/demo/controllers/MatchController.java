package com.footballobzor.demo.controllers;

import com.footballobzor.demo.api.dto.MatchResponseDto;
import com.footballobzor.demo.api.dto.TeamDto;
import com.footballobzor.demo.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matches/")
@RequiredArgsConstructor
public class MatchController {

    private MatchService matchService;

    @GetMapping()
    public ResponseEntity<List<MatchResponseDto>> findAll(){
        return new ResponseEntity<>(matchService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchResponseDto> save(@RequestBody TeamDto teamDto){
      //  return new ResponseEntity<>(teamService.save(teamDto), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
