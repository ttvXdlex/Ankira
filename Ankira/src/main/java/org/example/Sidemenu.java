package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Sidemenu {
    private BorderPane panel;

    public Sidemenu() {
        panel = new BorderPane();
        lmenu();
    }

    private void lmenu() {
        VBox leftmenu = new VBox();
        leftmenu.setPrefWidth(250);
        leftmenu.setAlignment(Pos.TOP_LEFT);
        leftmenu.getStyleClass().add("left-menu");
        leftmenu.setSpacing(30);

        Button home = new Button("Home");
        ImageView favico = new ImageView(new Image("images/fav.png"));
        favico.setFitWidth(32);
        favico.setFitHeight(32);
        Button favourite = new Button("Favourite", favico);
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