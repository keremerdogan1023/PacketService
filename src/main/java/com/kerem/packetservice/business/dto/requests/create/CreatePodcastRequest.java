package com.kerem.packetservice.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePodcastRequest {
    private String name;
    private int time;
    private String owner;
    private String provider;
}
