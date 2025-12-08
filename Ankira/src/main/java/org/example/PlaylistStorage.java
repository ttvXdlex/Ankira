package org.example;

import java.util.ArrayList;
import java.util.List;

//чисто класс хранилище для текста и юрлшки плейлистов
public class PlaylistStorage {
    public String text;
    public String url;
    public List<SongStorage> tracks; //список треков плейлиста

    public PlaylistStorage(String text, String url) {
        this.text = text;
        this.url = url;
        this.tracks = new ArrayList<>();
    }

    public void addtrack(SongStorage track) {
        tracks.add(track); //добавляет треки в плейлист
    }
}

