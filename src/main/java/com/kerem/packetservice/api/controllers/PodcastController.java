package com.kerem.packetservice.api.controllers;

import com.kerem.packetservice.business.abstracts.AudiobookService;
import com.kerem.packetservice.business.abstracts.PodcastService;
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
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/podcasts")
public class PodcastController {
    private final PodcastService service;
    @GetMapping
    public List<GetAllPodcastsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPodcastResponse getById(@PathVariable int id) {
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePodcastResponse add(@RequestBody CreatePodcastRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePodcastResponse update(@PathVariable int id, @RequestBody UpdatePodcastRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
