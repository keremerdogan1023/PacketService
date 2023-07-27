package com.kerem.packetservice.business.dto.responses.get;

import com.kerem.packetservice.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetRecordResponse {
    private int id;
    private String name;
    private int time;
    private State state;
    private String owner;
}