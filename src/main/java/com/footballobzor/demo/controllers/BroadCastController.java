package com.footballobzor.demo.controllers;

import com.footballobzor.demo.api.dto.BroadCastDto;
import com.footballobzor.demo.api.dto.UserDto;
import com.footballobzor.demo.service.BroadCastService;
import com.footballobzor.demo.utils.UserConverUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/broadcasts/")
@RequiredArgsConstructor
public class BroadCastController {
    private final BroadCastService broadCastService;

    @GetMapping()
    public ResponseEntity<List<BroadCastDto>> findAll(){
        return new ResponseEntity<>(broadCastService.getAllBroadcasts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BroadCastDto> save(@RequestBody BroadCastDto broadCastDto){
       return new ResponseEntity<>(broadCastService.save(broadCastDto), HttpStatus.OK);
    }
}
