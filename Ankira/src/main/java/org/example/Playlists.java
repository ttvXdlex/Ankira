package org.example;


import java.util.ArrayList;
import java.util.List;


//это коорче типа СПИИСОК плейлистов, я перенес эти плейлисты в список понял, так удобнее будет и
//посути теперь кнопки и в библиотеки они подсасываются от сюда
public class Playlists {

    static List<PlaylistStorage> playlisters = new ArrayList<>();

    static  {
        playlisters.add(new PlaylistStorage("Favourite","fav.png")); //юзаю хранилище шобы вписывать название и юрл картинки
        //посути тут и создаются плейлисты.
        playlisters.add(new PlaylistStorage("Playlist","pl1.jpg"));
        playlisters.add(new PlaylistStorage("Playlist","pl2.jpg"));
        playlisters.add(new PlaylistStorage("Tes2s","pl3.jpg"));

    }

    public static List<PlaylistStorage> getPlaylisters() {
        return playlisters;
    }//ну выдает плейлисты ты типо не понял или че

}


