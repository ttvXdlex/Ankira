package org.example;


import java.util.ArrayList;
import java.util.List;


//это коорче типа СПИИСОК плейлистов, я перенес эти плейлисты в список понял, так удобнее будет и
//посути теперь кнопки и в библиотеки они подсасываются от сюда
public class Playlists {

    static List<PlaylistStorage> playlisters = new ArrayList<>();

    static  {
        PlaylistStorage favourite = new PlaylistStorage("Favourite","fav.png"); //юзаю хранилище шобы вписывать название и юрл картинки
        favourite.addtrack(Songlist.getSonglist().get(0));
        favourite.addtrack(Songlist.getSonglist().get(2));
        favourite.addtrack(Songlist.getSonglist().get(1));
        favourite.addtrack(Songlist.getSonglist().get(4));
        favourite.addtrack(Songlist.getSonglist().get(5));
        favourite.addtrack(Songlist.getSonglist().get(6));
        favourite.addtrack(Songlist.getSonglist().get(10));
        favourite.addtrack(Songlist.getSonglist().get(12));
        playlisters.add(favourite);

        PlaylistStorage playlist1 = new PlaylistStorage("Playlist","pl1.jpg");
        playlist1.addtrack(Songlist.getSonglist().get(0));
        playlisters.add(playlist1);

        PlaylistStorage test = new PlaylistStorage("Tes2s","pl3.jpg");
        test.addtrack(Songlist.getSonglist().get(1));
        playlisters.add(test);

        PlaylistStorage test2 = new PlaylistStorage("Martin Onga","Marti.jpg");
        test2.addtrack(Songlist.getSonglist().get(7));
        test2.addtrack(Songlist.getSonglist().get(8));
        test2.addtrack(Songlist.getSonglist().get(4));
        playlisters.add(test2);
    }

    public static List<PlaylistStorage> getPlaylisters() {
        return playlisters;
    }//ну выдает плейлисты ты типо не понял или че

}


