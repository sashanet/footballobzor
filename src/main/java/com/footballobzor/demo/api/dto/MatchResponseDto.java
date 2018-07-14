package com.footballobzor.demo.api.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MatchResponseDto {
    private String description;
    private String title;
    private Date startDate;
    private Date finishDate;
    private Boolean deleted;

    private TeamDto homeTeam;
    private TeamDto guestTeam;

    private String id;
    private List<BroadCastDto> broadCastDtos;

}
