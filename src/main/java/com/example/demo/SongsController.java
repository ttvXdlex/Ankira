package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/songs")
@RestController
public class SongsController {
    SongsService songsService;

    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

    @GetMapping
    public ResponseEntity<List<Songs>> getAllSongs() {
        List<Songs> songs = songsService.getSong()
    }

    @PostMapping
    public Songs addSong(@RequestBody Songs songs) {
        return songsService.addSong(songs);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return songsService.deleteSong(id);
    }


}
