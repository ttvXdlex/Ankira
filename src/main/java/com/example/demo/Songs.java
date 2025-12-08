package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Songs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String artist;
    String iname;
    String audiopath;

    @ManyToMany(mappedBy = "songs")
    private List<Playlists> playlists;


    public Songs(Long id, String audiopath, String iname, String artist, String name) {
        this.id = id;
        this.audiopath = audiopath;
        this.iname = iname;
        this.artist = artist;
        this.name = name;
    }

    public Songs() {}

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getAudiopath() {
        return audiopath;
    }

    public void setAudiopath(String audiopath) {
        this.audiopath = audiopath;
    }

    public List<Playlists> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlists> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString(){
        return "Id: " + id + " name: " + name + " artist: " + artist + " iname: " + iname + " audiopath: " + audiopath + "\n";
    }

}

