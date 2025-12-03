package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Playlister {

    public static VBox playlistulpoad(String text, String url) {

        Label playlistname = new Label(text); //лейбл типа текст
        playlistname.getStyleClass().add("blocksongtext");
        playlistname.setPrefWidth(200);
        playlistname.setAlignment(Pos.CENTER);
        ImageView playlistimage = new ImageView(new Image("images/" + url));
        playlistimage.setFitWidth(250);
        playlistimage.setFitHeight(250);
        VBox playlistcontainer = new VBox(playlistimage); //ну вбокс создает че не понятно
        playlistcontainer.setPrefWidth(250);
        playlistcontainer.setPrefHeight(250);
        playlistcontainer.getStyleClass().add("blocksong");
        playlistcontainer.getChildren().add(playlistname);
        playlistcontainer.setAlignment(Pos.BOTTOM_CENTER);
        return playlistcontainer;
    }
}
