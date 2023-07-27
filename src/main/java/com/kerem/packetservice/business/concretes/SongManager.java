package com.kerem.packetservice.business.concretes;

import com.kerem.packetservice.business.abstracts.SongService;
import com.kerem.packetservice.business.dto.requests.create.CreateSongRequest;
import com.kerem.packetservice.business.dto.requests.update.UpdateSongRequest;
import com.kerem.packetservice.business.dto.responses.create.CreateSongResponse;
import com.kerem.packetservice.business.dto.responses.get.GetAllSongsResponse;
import com.kerem.packetservice.business.dto.responses.get.GetSongResponse;
import com.kerem.packetservice.business.dto.responses.update.UpdateSongResponse;
import com.kerem.packetservice.entities.Song;
import com.kerem.packetservice.entities.enums.State;
import com.kerem.packetservice.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SongManager implements SongService {
    private final SongRepository repository;
    private final ModelMapper mapper;
    @Override
    public CreateSongResponse add(CreateSongRequest request) {
        Song song = mapper.map(request,Song.class);
        song.setId(0);
        song.setState(State.ACTIVE);
        repository.save(song);
        CreateSongResponse response = mapper.map(song, CreateSongResponse.class);
        return response;
    }

    @Override
    public UpdateSongResponse update(int id, UpdateSongRequest request) {
        Song song = mapper.map(request, Song.class);
        song.setId(id);
        repository.save(song);
        UpdateSongResponse response = mapper.map(song, UpdateSongResponse.class);
        return response;
    }

    @Override
    public GetSongResponse getById(int id) {
        Song song = repository.findById(id).orElseThrow();
        GetSongResponse response = mapper.map(song, GetSongResponse.class);
        return response;
    }

    @Override
    public List<GetAllSongsResponse> getAll() {
        List<Song> songs =repository.findAll();
        List<GetAllSongsResponse> response = songs.stream()
                .map(song -> mapper.map(song, GetAllSongsResponse.class))
                .toList();
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
