package org.example;


import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

//Тут кароче я решил создат класс де типа мы будем создавать бордер пэйн с музыкай на главном меню типа понял короче ты увидеш в приложении че
public class SongsMain {
    private ScrollPane music; //ПРИКОООЛ существует скроллпэйн он короче автоматом скроллинг добавляет ЗАБАВНАЯ ШТУЧКА

    public SongsMain() {
        music = new ScrollPane();
        Music();
    }

    private void Music() {
        FlowPane tracks = new FlowPane(); //ПРИКОООЛ существует флоу пэйн о короже типа автоматом регулирует где че как должны
        //распологаться боксики типа если он заполнил по краю он автоматом переносит, ЗАБАВНАЯ ШТУЧКА
        tracks.setMaxWidth(944);
        tracks.setMaxHeight(760);
        tracks.setAlignment(Pos.CENTER);
        tracks.setHgap(50); //ну тут типа растояяния между тем что внутри флоуа задает по горизонту
        tracks.setVgap(50); //тож самое по верту
        for (int i = 0; i < Songlist.getSonglist().size(); i++) { //ухты это же ЦИИКЛ, который перебирает наш список
            SongStorage songlist = Songlist.getSonglist().get(i);
            VBox songbox = Songer.songscreat(songlist.name, songlist.artist, songlist.cover); //вот тута мы создаем вбокс и
            // из списка название и картинку берем для вбокса
            tracks.getChildren().add(songbox); //ну и добавляет что выходит на выходе в скролпэйн библиотеки
        }

        ScrollPane songscroll = new ScrollPane(tracks); //ну тут ттож понятно тут как раз создается скроллпэйн
        songscroll.setFitToWidth(true); //корочееее он типо растягивает по ширине, иба без этого он автоматом все в лево переносит
        songscroll.setStyle("-fx-background: #2b2b2b;");
        music = songscroll;
    }

    public ScrollPane getMusic() {
        return music;
    }
}
