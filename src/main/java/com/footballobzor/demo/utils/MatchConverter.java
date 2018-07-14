package com.footballobzor.demo.utils;

import com.footballobzor.demo.api.dto.BroadCastDto;
import com.footballobzor.demo.api.dto.MatchResponseDto;
import com.footballobzor.demo.api.dto.TeamDto;
import com.footballobzor.demo.persistance.entity.Match;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

public class MatchConverter {

    public static MatchResponseDto convert(Match match){
        MatchResponseDto dto = new MatchResponseDto();
        dto.setDeleted(match.getDeleted());
        dto.setDescription(match.getDescription());
        dto.setGuestTeam(Converter.converter(match.getTeam2(), new TeamDto()));
        dto.setHomeTeam(Converter.converter(match.getTeam1(), new TeamDto()));
        dto.setBroadCastDtos(match.getBroadcasts()
                .stream()
                .map(broadcast -> Converter.converter(broadcast, new BroadCastDto()))
                .collect(Collectors.toList()));
        dto.setId(match.getId());
        dto.setFinishDate(getFinishDate(match.getStartDate()));

        return dto;
    }

    private static Date getFinishDate(Date startDate){
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(startDate); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 2); // adds two hour
       return cal.getTime();
    }
}
