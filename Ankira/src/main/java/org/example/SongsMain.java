package org.example;


import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
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
        FlowPane test24 = new FlowPane(); //ПРИКОООЛ существует флоу пэйн о короже типа автоматом регулирует где че как должны
        //распологаться боксики типа если он заполнил по краю он автоматом переносит, ЗАБАВНАЯ ШТУЧКА
        test24.setMaxWidth(944);
        test24.setMaxHeight(760);
        test24.setAlignment(Pos.CENTER);
        test24.setHgap(50); //ну тут типа растояяния между тем что внутри флоуа задает по горизонту
        test24.setVgap(50); //тож самое по верту
        VBox test = Songer.songscreat("Trek1", "Artist1"); // ну тут понятно короче
        VBox test2 = Songer.songscreat("Trek2", "Artist2");
        VBox test33 = Songer.songscreat("Trek3", "Artist3");
        VBox test4 = Songer.songscreat("Trek4", "Artist4");
        VBox test5 = Songer.songscreat("Trek5", "Artist5");
        VBox test6 = Songer.songscreat("Trek6",  "Artist6");
        VBox test7 = Songer.songscreat("Trek7",  "Artist7");
        test24.getChildren().addAll(test, test2, test33, test4, test5, test6, test7);

        ScrollPane songscroll = new ScrollPane(test24); //ну тут ттож понятно тут как раз создается скроллпэйн
        songscroll.setFitToWidth(true); //корочееее он типо растягивает по ширине, иба без этого он автоматом все в лево переносит
        songscroll.setStyle("-fx-background: #2b2b2b;");
        music = songscroll;
    }

    public ScrollPane getMusic() {
        return music;
    }
}
