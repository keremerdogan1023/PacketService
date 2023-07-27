package com.kerem.packetservice.business.dto.requests.create;

import com.kerem.packetservice.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSongRequest {
    private String name;
    private int time;
    private String owner;
    private String provider;
}

