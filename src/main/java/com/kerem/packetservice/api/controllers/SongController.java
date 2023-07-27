package com.kerem.packetservice.api.controllers;

import com.kerem.packetservice.business.abstracts.RecordService;
import com.kerem.packetservice.business.abstracts.SongService;
import com.kerem.packetservice.business.dto.requests.create.CreateRecordRequest;
import com.kerem.packetservice.business.dto.requests.create.CreateSongRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateRecordRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateSongRequest;
import com.kerem.packetservice.business.dto.responses.create.CreateRecordResponse;
import com.kerem.packetservice.business.dto.responses.create.CreateSongResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllRecordsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllSongsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetRecordResponse;
import com.kerem.packetservice.business.dto.responses.get.GetSongResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateRecordResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateSongResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/songs")
public class SongController {
    private final SongService service;
    @GetMapping
    public List<GetAllSongsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSongResponse getById(@PathVariable int id) {
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSongResponse add(@RequestBody CreateSongRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateSongResponse update(@PathVariable int id, @RequestBody UpdateSongRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
