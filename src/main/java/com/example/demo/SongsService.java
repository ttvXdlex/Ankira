package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService {

    SongsRepository songsRepository;

    public SongsService(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    public List<Songs> getSong() {
        return songsRepository.findAll();
    }

    public Songs addSong(Songs songs) {
        return songsRepository.save(songs);
    }

    public String deleteSong(Long id) {
        songsRepository.deleteById(id);
        return "It was successfully deleted";
    }
}
