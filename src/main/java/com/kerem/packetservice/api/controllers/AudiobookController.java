package com.kerem.packetservice.api.controllers;

import com.kerem.packetservice.business.abstracts.AudiobookService;
import com.kerem.packetservice.business.dto.requests.create.CreateAudiobookRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateAudiobookRequest;
import com.kerem.packetservice.business.dto.responses.create.CreateAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllAudiobooksResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateAudiobookResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/audiobooks")
public class AudiobookController {
    private final AudiobookService service;
    @GetMapping
    public List<GetAllAudiobooksResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetAudiobookResponse getById(@PathVariable int id) {
        return service.getById(id);
    }
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAudiobookResponse add(@Valid @RequestBody CreateAudiobookRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateAudiobookResponse update(@PathVariable int id, @RequestBody UpdateAudiobookRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}






