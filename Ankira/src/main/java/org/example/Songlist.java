package org.example;

import java.util.ArrayList;
import java.util.List;

public class Songlist {

    static List<SongStorage> songlists = new ArrayList<>();

    static {
        songlists.add(new SongStorage("XXL", "5opka, MellSher", "XXL.jpg", "music/XXL.mp3"));
        songlists.add(new SongStorage("IRIS OUT", "Kenshi Yonezu", "Iris_Out.png", "music/IRISOUT.mp3"));
        songlists.add(new SongStorage("So so brooks", "so so,Dj os", "SOSO.jpg", "music/so_so_brooks.mp3"));
        songlists.add(new SongStorage("ЧСВ", "Lida feat(Cерега пират) ", "ЧСВ.jpg", "music/ЧСВ.mp3"));
        songlists.add(new SongStorage("In the pool", "Kensuki ushio", "inthepool.jpg", "music/chainsaw_man.mp3"));
        songlists.add(new SongStorage("Broken games","Fzmz", "Bk.jpg", "music/Broken_games.mp3"));
        songlists.add(new SongStorage("Danger danger", "Fzmz", "Dd.jpg", "music/Fzmz Danger Dange.mp4"));
        songlists.add(new SongStorage("Философская песня о пуле","Egor Letov", "pesnya.jpg", "music/pesnya.mp3"));
        songlists.add(new SongStorage("Waste my time","OliverTree", "Wmt.png", "music/Waste_My_Time.mp3"));
        songlists.add(new SongStorage("FEIN","Travis Scott, Playboy Carti", "FEIN.jpg", "music/FEIN.mp3"));
        songlists.add(new SongStorage("BFM","Asteria, kets4eki, Britney Manson", "BFM.jpg", "music/BFM.mp3"));
        songlists.add(new SongStorage("Rule","Ado", "Rule.jpg", "music/RuLe.mp3"));
        songlists.add(new SongStorage("Its Going Down Now","ATLUS", "Igdn.jpg", "music/Igdn.mp3"));
        songlists.add(new SongStorage("Burning","Hitsujibungaku", "Burning.png", "music/Burning.mp3"));
        songlists.add(new SongStorage("I Want Things To Be Beautiful "," Devi McCallion", "Iwant.jpg", "music/Iwant.mp3"));
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
