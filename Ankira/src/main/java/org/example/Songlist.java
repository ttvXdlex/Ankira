package org.example;

import java.util.ArrayList;
import java.util.List;

public class Songlist {

    static List<SongStorage> songlists = new ArrayList<>();

    static {
        songlists.add(new SongStorage("XXL", "5opka, MellSher", "track1.jpg", "music/XXL.mp3"));
        songlists.add(new SongStorage("IRIS OUT", "Kenshi Yonezu", "fav.png", "music/IRISOUT.mp3"));
        songlists.add(new SongStorage("So so brooks", "so so,Dj os", "fav.png", "music/so_so_brooks.mp3"));
        songlists.add(new SongStorage("ЧСВ", "Lida feat(Cерега пират) ", "fav.png", "music/ЧСВ.mp3"));
        songlists.add(new SongStorage("In the pool", "Kensuki ushio", "fav.png", "music/chainsaw_man.mp3"));
        songlists.add(new SongStorage("Broken games","Fzmz", "fav.png", "music/Broken_games.mp3"));
        songlists.add(new SongStorage("Danger danger", "Fzmz", "fav.png", "music/Fzmz Danger Dange.mp4"));
    }

    public static List<SongStorage> search(String searching) { //здесь метод работующий со списком
        if (searching == null) { //если то что ты вписал в поиске ничему не равно то он выводит весь список
            return songlists;
        }

        if (searching.trim().isEmpty()) { //тут типо тоже самое но с проверкой типо если ты вдруг впишешь пробел то он его удаляет дабы проверить пустой ли там текст или чето есть.
            return songlists;
        }

        List<SongStorage> results = new ArrayList<>();
        String lowtext = searching.toLowerCase(); //здесь задается новой переменной тот же текс что ты вписал только все буквы маленькие

        for (int i = 0; i < Songlist.getSonglist().size(); i++) { //цикл проходящий по всему списку
            SongStorage song = songlists.get(i);
            int check = 0; //создаетяс переменная проверки для того чтобы треки не дублировались

            if (song.name.toLowerCase().contains(lowtext)) { //ну и ранее мы сделали все буквы маленькими а здесь проверка на регистр ну короче не важно какими большими или мелкими ты пишешь
                //он будет считать это за один текст, короче он проверяет чтобы название соответствовало тексу
                check = 1; //если все соответсвует то переменная будет равна 1
            }
            if (song.artist.toLowerCase().contains(lowtext)) { //тоже самое только вдруг если ты вел артиста а не название трека
                check = 1;
            }

            if (check == 1) { //если он равен уже 1 то выводит трек, это все нужно чтобы он не дублировался если будут схожие буквы в названии и в артисте.
                results.add(song);
            }
        }

        return results; //возвращает в конце в список результат

    }


    public static List<SongStorage> getSonglist() {
        return songlists;
    }
}
