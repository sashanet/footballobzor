package com.footballobzor.demo.utils;

import com.footballobzor.demo.api.dto.MatchResponseDto;
import com.footballobzor.demo.persistance.entity.Match;

public class MatchConverter {

    public static MatchResponseDto convert(Match match){
        MatchResponseDto dto = new MatchResponseDto();
        dto.setDeleted(match.getDeleted());
        dto.setDescription(match.getDescription());
        //dto.setGuestTeam();
        return dto;
    }
}
