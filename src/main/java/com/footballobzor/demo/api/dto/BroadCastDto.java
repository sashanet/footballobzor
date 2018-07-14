package com.footballobzor.demo.api.dto;

import lombok.Data;

@Data
public class BroadCastDto {

    private String id;

    private String imageUrl;

    private String bitrate;

    private String language;

    private String link;

   // private Set<Match> matches = new HashSet<>();
}
