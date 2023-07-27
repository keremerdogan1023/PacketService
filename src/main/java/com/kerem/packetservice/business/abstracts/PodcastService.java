package com.kerem.packetservice.business.abstracts;

import com.kerem.packetservice.business.dto.requests.create.CreateAudiobookRequest;
import com.kerem.packetservice.business.dto.requests.create.CreatePodcastRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateAudiobookRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdatePodcastRequest;
import com.kerem.packetservice.business.dto.responses.create.CreateAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.create.CreatePodcastResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllAudiobooksResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllPodcastsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.get.GetPodcastResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdatePodcastResponse;
import com.kerem.packetservice.entities.enums.State;

import java.util.List;

public interface PodcastService {
    CreatePodcastResponse add(CreatePodcastRequest request);
    UpdatePodcastResponse update(int id, UpdatePodcastRequest request);
    GetPodcastResponse getById(int id);
    List<GetAllPodcastsResponse> getAll();
    void delete(int id);
    void changeState(int id, State state);
}
