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
        VBox track1 = Songer.songscreat("Trek1", "Artist1", "fav.png"); // ну тут понятно короче
        VBox track2 = Songer.songscreat("Trek2", "Artist2", "fav.png");
        VBox track3 = Songer.songscreat("Trek3", "Artist3", "fav.png");
        VBox track4 = Songer.songscreat("Trek4", "Artist4", "fav.png");
        VBox track5 = Songer.songscreat("Trek5", "Artist5", "fav.png");
        VBox track6 = Songer.songscreat("Trek6",  "Artist6", "fav.png");
        VBox track7 = Songer.songscreat("Trek7",  "Artist7", "fav.png");
        tracks.getChildren().addAll(track1, track2, track3, track4, track5, track6, track7);

        ScrollPane songscroll = new ScrollPane(tracks); //ну тут ттож понятно тут как раз создается скроллпэйн
        songscroll.setFitToWidth(true); //корочееее он типо растягивает по ширине, иба без этого он автоматом все в лево переносит
        songscroll.setStyle("-fx-background: #2b2b2b;");
        music = songscroll;
    }

    public ScrollPane getMusic() {
        return music;
    }
}
