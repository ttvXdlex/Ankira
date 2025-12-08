package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/playlists")
@RestController
public class PlaylistsController {
    PlaylistsService playlistsService;

    public PlaylistsController(PlaylistsService playlistsService) {
        this.playlistsService = playlistsService;
    }

    @GetMapping
    public String getPlaylist() {
        return playlistsService.getPlaylist().toString();
    }

    @PostMapping
    public Playlists addPlaylist(@RequestBody Playlists playlists) {
        return playlistsService.addPlaylist(playlists);
    }

    @DeleteMapping("/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        return playlistsService.deletePlaylist(id);
    }


}
