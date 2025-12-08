package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Playlists {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String iname;
    @ManyToMany
    @JoinTable(
            name = "playlists_songs",
            joinColumns = @JoinColumn(name = "playlists_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Songs> songs;

    public Playlists(Long id, String name, String iname) {
        this.id = id;
        this.name = name;
        this.iname = iname;
    }

    public Playlists() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public void addSong(Songs song) {
        this.songs.add(song);
        song.getPlaylists().add(this);
    }

    @Override
    public String toString(){
        return "Id: " + id + " name: " + name + " iname: " + iname + "\n";
    }

}

