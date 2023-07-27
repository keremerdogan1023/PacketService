package com.kerem.packetservice.business.dto.responses.update;

import com.kerem.packetservice.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSongResponse {
    private int id;
    private String name;
    private int time;
    private State state;
    private String owner;
    private String provider;
}
