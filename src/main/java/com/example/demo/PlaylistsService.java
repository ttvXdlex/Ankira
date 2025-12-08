package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistsService {

    PlaylistsRepository playlistsRepository;

    public PlaylistsService(PlaylistsRepository playlistsRepository) {
        this.playlistsRepository = playlistsRepository;
    }

    public List<Playlists> getPlaylist() {
        return playlistsRepository.findAll();
    }

    public Playlists addPlaylist(Playlists playlists) {
        return playlistsRepository.save(playlists);
    }

    public String deletePlaylist(Long id) {
        playlistsRepository.deleteById(id);
        return "It was successfully deleted";
    }
}
