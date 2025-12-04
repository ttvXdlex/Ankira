package org.example;

import java.util.ArrayList;
import java.util.List;

public class Songlist {

    static List<SongStorage> songlists = new ArrayList<>();

    static {
        songlists.add(new SongStorage("Track 1","Artist 1", "fav.png"));
        songlists.add(new SongStorage("Track 2","Artist 2", "fav.png"));
        songlists.add(new SongStorage("Track 3","Artist 3", "fav.png"));
        songlists.add(new SongStorage("Track 4","Artist 4", "fav.png"));
        songlists.add(new SongStorage("Track 5","Artist 5", "fav.png"));
        songlists.add(new SongStorage("Track 6","Artist 6", "fav.png"));
        songlists.add(new SongStorage("Track 7","Artist 7", "fav.png"));
    }

    public static List<SongStorage> getSonglist() {
        return songlists;
    }
}
