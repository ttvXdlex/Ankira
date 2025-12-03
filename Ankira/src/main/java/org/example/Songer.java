package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

//Ну вот тут я сделал метод шобы каробочки кароче делатц как с плейлистами по бырому.
public class Songer {

    public static VBox songscreat(String name, String artist, String cover){
        Label songname = new Label(name + " - " + artist); //лейбл типа текст
        songname.getStyleClass().add("blocksongtext");
        songname.setPrefWidth(200);
        songname.setAlignment(Pos.CENTER);
        ImageView songimage = new ImageView(new Image("images/"+cover));
        songimage.setFitWidth(250);
        songimage.setFitHeight(250);
        ImageView play = new ImageView(new Image("images/play.png"));
        play.setFitWidth(64);
        play.setFitHeight(64);
        play.getStyleClass().add("buttoncover");
        StackPane playpane = new StackPane(songimage,play);
        VBox song = new VBox(playpane); //ну вбокс создает че не понятно
        song.setPrefWidth(250);
        song.setPrefHeight(250);
        song.getStyleClass().add("blocksong");
        song.getChildren().add(songname);
        song.setAlignment(Pos.BOTTOM_CENTER);
        return song;
    }
}
