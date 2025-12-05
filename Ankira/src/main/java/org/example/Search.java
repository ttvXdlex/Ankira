package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Search {
    private final BorderPane searchtop;
    private final SongsMain songsMain;

    public Search(SongsMain songsMain) {
        this.songsMain = songsMain;
        searchtop = new BorderPane();
        search();
    }

    private void search() {
        TextField textField = new TextField();
        textField.setPromptText("What do you want play?");
        textField.getStyleClass().add("text-field");

        ImageView searchimg = new ImageView(new Image("images/search.png"));
        searchimg.setFitHeight(25);
        searchimg.setFitWidth(25);
        Button searchButton = new Button("",searchimg);
        searchButton.getStyleClass().add("search-Button");

        searchButton.setOnAction(e -> {
            String searching = textField.getText();
            songsMain.searchupdated(searching);
        }); //Тут при нажатии на кнопку поиска, создается перемена, которой задается то, что было вписано вполе, после чего через метод в сонг мэин проверяется задавая ему эту переменную
        //ну типа дальше в сонг мэин чекниш емае

        HBox text = new HBox(0, textField, searchButton);
        text.setAlignment(Pos.CENTER); // выравниваем элементы HBox по центру
        text.setPrefHeight(50);

        VBox searchbar = new VBox(text);
        searchbar.setAlignment(Pos.TOP_CENTER);

        searchtop.setTop(searchbar);
    }

    public BorderPane getSearchtop() {
        return searchtop;
    }
}
