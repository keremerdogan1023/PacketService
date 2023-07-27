package com.kerem.packetservice.business.abstracts;

import com.kerem.packetservice.business.dto.requests.create.CreateSongRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateSongRequest;
import com.kerem.packetservice.business.dto.responses.create.CreateSongResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllSongsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetSongResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateSongResponse;

import java.util.List;

public interface SongService {
    CreateSongResponse add(CreateSongRequest request);
    UpdateSongResponse update(int id, UpdateSongRequest request);
    GetSongResponse getById(int id);
    List<GetAllSongsResponse> getAll();
    void delete(int id);
}
