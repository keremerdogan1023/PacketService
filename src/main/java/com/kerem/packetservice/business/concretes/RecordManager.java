package com.kerem.packetservice.business.concretes;

import com.kerem.packetservice.business.abstracts.RecordService;
import com.kerem.packetservice.business.dto.requests.create.CreateRecordRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateRecordRequest;
import com.kerem.packetservice.business.dto.responses.create.CreatePodcastResponse;
import com.kerem.packetservice.business.dto.responses.create.CreateRecordResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllPodcastsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllRecordsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetPodcastResponse;
import com.kerem.packetservice.business.dto.responses.get.GetRecordResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdatePodcastResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateRecordResponse;
import com.kerem.packetservice.entities.Podcast;
import com.kerem.packetservice.entities.Record;
import com.kerem.packetservice.entities.enums.State;
import com.kerem.packetservice.repository.RecordRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecordManager implements RecordService {
    private final RecordRepository repository;
    private final ModelMapper mapper;
    @Override
    public CreateRecordResponse add(CreateRecordRequest request) {
        Record record = mapper.map(request,Record.class);
        record.setId(0);
        record.setState(State.ACTIVE);
        repository.save(record);
        CreateRecordResponse response = mapper.map(record, CreateRecordResponse.class);
        return response;
    }

    @Override
    public UpdateRecordResponse update(int id, UpdateRecordRequest request) {
        Record record = mapper.map(request, Record.class);
        record.setId(id);
        repository.save(record);
        UpdateRecordResponse response = mapper.map(record, UpdateRecordResponse.class);
        return response;
    }

    @Override
    public GetRecordResponse getById(int id) {
        Record record = repository.findById(id).orElseThrow();
        GetRecordResponse response = mapper.map(record, GetRecordResponse.class);
        return response;
    }

    @Override
    public List<GetAllRecordsResponse> getAll() {
        List<Record> records =repository.findAll();
        List<GetAllRecordsResponse> response = records.stream()
                .map(record -> mapper.map(record, GetAllRecordsResponse.class))
                .toList();
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
