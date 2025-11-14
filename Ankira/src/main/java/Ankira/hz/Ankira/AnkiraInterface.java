package Ankira.hz.Ankira;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AnkiraInterface extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ankira");
        stage.setResizable(false);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #191919");
        TextField textField = new TextField();
        textField.setPromptText("What do you want play?");
        textField.getStyleClass().add("text-field");

        Button searchButton = new Button("Search 🔍");
        searchButton.getStyleClass().add("search-Button");

//        searchButton.setOnAction(e -> {
//            String query = searchField.getText(); // получаем текст из поля
//            System.out.println("Ищем: " + query);
//        });

        HBox text = new HBox(10, textField, searchButton);
        text.setAlignment(Pos.CENTER); // выравниваем элементы HBox по центру
        text.setPrefHeight(50);

        VBox vbox = new VBox(text);
        vbox.setAlignment(Pos.TOP_CENTER);

        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 1200, 760);


        stage.setScene(scene);
        scene.getStylesheets().add("style/style.css");
        stage.show();
        stage.setOnCloseRequest(event -> {
            System.exit(0); // полностью завершает приложение
        });
    }
}