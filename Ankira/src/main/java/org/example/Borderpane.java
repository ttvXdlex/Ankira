package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Borderpane {
    private BorderPane panel;

    public Borderpane() {
        panel = new BorderPane();
        setupLayout();
    }

    private void setupLayout() {
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
        panel.setLeft(leftmenu);
    }

    public BorderPane getPanel() {
        return panel;
    }
}