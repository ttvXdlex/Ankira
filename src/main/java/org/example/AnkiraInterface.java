package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



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


        Button searchButton = new Button("Search ");
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


        VBox leftmenu = new VBox();
        leftmenu.setPrefWidth(250);
        leftmenu.getStyleClass().add("left-menu");
        leftmenu.setSpacing(30);
        leftmenu.setAlignment(Pos.TOP_LEFT);

        Button home = new Button("Home");
        ImageView img = new ImageView(new Image("images/fav.jpg"));
        img.setFitWidth(32);
        img.setFitHeight(32);
        Button favourite = new Button("Favourite", img);
        favourite.getStyleClass().add("favourite");
        favourite.setPrefWidth(210);
        favourite.setPrefHeight(32);
        favourite.setAlignment(Pos.TOP_LEFT);
        Button library = new Button("Your Library");
        leftmenu.getChildren().addAll(home, favourite, library);
        BorderPane panel = new BorderPane();
        panel.setLeft(leftmenu);
        root.getChildren().add(panel);
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