package com.kerem.packetservice.business.abstracts;

import com.kerem.packetservice.business.dto.requests.create.CreatePodcastRequest;
import com.kerem.packetservice.business.dto.requests.create.CreateRecordRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdatePodcastRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateRecordRequest;
import com.kerem.packetservice.business.dto.responses.create.CreatePodcastResponse;
import com.kerem.packetservice.business.dto.responses.create.CreateRecordResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllPodcastsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllRecordsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetPodcastResponse;
import com.kerem.packetservice.business.dto.responses.get.GetRecordResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdatePodcastResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateRecordResponse;
import com.kerem.packetservice.entities.enums.State;

import java.util.List;

public interface RecordService {
    CreateRecordResponse add(CreateRecordRequest request);
    UpdateRecordResponse update(int id, UpdateRecordRequest request);
    GetRecordResponse getById(int id);
    List<GetAllRecordsResponse> getAll();
    void delete(int id);
    //void changeState(int id, State state);
}
