package org.example;


import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.List;

//Тут кароче я решил создат класс де типа мы будем создавать бордер пэйн с музыкай на главном меню типа понял короче ты увидеш в приложении че
public class SongsMain {
    private ScrollPane music; //ПРИКОООЛ существует скроллпэйн он короче автоматом скроллинг добавляет ЗАБАВНАЯ ШТУЧКА
    private final FlowPane tracks;
    private PlayerBar playerBar;

    public SongsMain(PlayerBar playerBar) {
        this.playerBar = playerBar;
        music = new ScrollPane();
        tracks = new FlowPane();
        Music(null);
    }

    private void Music(String searching) {
        tracks.setAlignment(Pos.CENTER);
        tracks.setHgap(50); //ну тут типа растояяния между тем что внутри флоуа задает по горизонту
        tracks.setVgap(50); //тож самое по верту
        tracks.getChildren().clear();

        List<SongStorage> songshow;
        if (searching == null) { //ну типа если серчинг ничему не равен то он задает переменной весь список
            songshow = Songlist.getSonglist();
        }
        else {
            songshow = Songlist.search(searching); //ну или в другом случае чо? Он задает переменной то чему равен серчинг.
        }

        for (int i = 0; i < songshow.size(); i++) { //ухты это же ЦИИКЛ, который перебирает наш список
            SongStorage songlist = songshow.get(i);
            int trackindex = i;
            VBox songbox = Songer.songscreat(songlist.name, songlist.artist, songlist.cover); //вот тута мы создаем вбокс и
            // из списка название и картинку берем для вбокса

            songbox.setOnMouseClicked((event) -> {
                playerBar.tracks(trackindex);
            });

            tracks.getChildren().add(songbox); //ну и добавляет что выходит на выходе в скролпэйн библиотеки
        }

        ScrollPane songscroll = new ScrollPane(tracks); //ну тут ттож понятно тут как раз создается скроллпэйн
        songscroll.setFitToWidth(true); //корочееее он типо растягивает по ширине, иба без этого он автоматом все в лево переносит
        songscroll.setStyle("-fx-background: #2b2b2b;");
        music = songscroll;
    }

    public void searchupdated(String searching) {
        Music(searching); //ну перенаправляет на метод Мюзик с заданной переменой в серче.
    }

    public ScrollPane getMusic() {
        return music;
    }
}
