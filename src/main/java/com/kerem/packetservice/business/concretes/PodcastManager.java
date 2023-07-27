package com.kerem.packetservice.business.concretes;

import com.kerem.packetservice.business.abstracts.PodcastService;
import com.kerem.packetservice.business.dto.requests.create.CreatePodcastRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdatePodcastRequest;
import com.kerem.packetservice.business.dto.responses.create.CreateAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.create.CreatePodcastResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllAudiobooksResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllPodcastsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.get.GetPodcastResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateAudiobookResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdatePodcastResponse;
import com.kerem.packetservice.entities.Audiobook;
import com.kerem.packetservice.entities.Podcast;
import com.kerem.packetservice.entities.enums.State;
import com.kerem.packetservice.repository.PodcastRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PodcastManager implements PodcastService {
    private final PodcastRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreatePodcastResponse add(CreatePodcastRequest request) {
        Podcast podcast = mapper.map(request,Podcast.class);
        podcast.setId(0);
        podcast.setState(State.ACTIVE);
        repository.save(podcast);
        CreatePodcastResponse response = mapper.map(podcast, CreatePodcastResponse.class);
        return response;
    }

    @Override
    public UpdatePodcastResponse update(int id, UpdatePodcastRequest request) {
        Podcast podcast = mapper.map(request, Podcast.class);
        podcast.setId(id);
        repository.save(podcast);
        UpdatePodcastResponse response = mapper.map(podcast, UpdatePodcastResponse.class);
        return response;
    }

    @Override
    public GetPodcastResponse getById(int id) {
        Podcast podcast = repository.findById(id).orElseThrow();
        GetPodcastResponse response = mapper.map(podcast, GetPodcastResponse.class);
        return response;
    }

    @Override
    public List<GetAllPodcastsResponse> getAll() {
        List<Podcast> podcasts =repository.findAll();
        List<GetAllPodcastsResponse> response = podcasts.stream()
                .map(podcast -> mapper.map(podcast, GetAllPodcastsResponse.class))
                .toList();
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    public void changeState(int id, State state) {

    }
}
