package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

//Ну вот тут я сделал метод шобы каробочки кароче делатц как с плейлистами по бырому.
public class Songer {

    public static VBox songscreat(String name, String artist){
        VBox song = new VBox(); //ну вбокс создает че не понятно
        song.setPrefWidth(250);
        song.setPrefHeight(250);
        song.getStyleClass().add("blocksong");

        Label songname = new Label(name + " - " + artist); //лейбл типа текст
        songname.getStyleClass().add("blocksongtext");
        songname.setPrefWidth(200);
        songname.setAlignment(Pos.CENTER);
        song.getChildren().add(songname);
        song.setAlignment(Pos.BOTTOM_CENTER);
        return song;
    }
}
