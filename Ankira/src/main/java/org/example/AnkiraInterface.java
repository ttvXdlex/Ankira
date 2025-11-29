package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class AnkiraInterface extends Application {
    StackPane root = new StackPane();
    @Override
    public void start(Stage stage) {
        stage.setTitle("Ankira");
        stage.setResizable(false);

        root.setStyle("-fx-background-color: #191919");

        TextField textField = new TextField();
        textField.setPromptText("What do you want play?");
        textField.getStyleClass().add("text-field");

        Button searchButton = new Button("Search ");
        searchButton.getStyleClass().add("search-Button");


        HBox text = new HBox(10, textField, searchButton);
        text.setAlignment(Pos.CENTER); // выравниваем элементы HBox по центру
        text.setPrefHeight(50);

        VBox vbox = new VBox(text);
        vbox.setAlignment(Pos.TOP_CENTER);

        Borderpane borderpane = new Borderpane();

        root.getChildren().addAll(borderpane.getPanel(), vbox);

        Scene scene = new Scene(root, 1200, 760);
        stage.setScene(scene);
        scene.getStylesheets().add("style/style.css");
        stage.show();

        stage.setOnCloseRequest(event -> {
            System.exit(0); // полностью завершает приложение
        });
    }
}
