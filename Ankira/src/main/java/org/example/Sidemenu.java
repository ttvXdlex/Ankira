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


    private Button playlists(String text, String url, String css) {
        ImageView icon = new ImageView(new Image(url));
        icon.setFitWidth(32);
        icon.setFitHeight(32);
        Button buttonlist = new Button(text, icon);
        buttonlist.getStyleClass().add(css);
        buttonlist.setPrefWidth(210);
        buttonlist.setPrefHeight(32);
        buttonlist.setAlignment(Pos.TOP_LEFT);
        return buttonlist;
    }

    private void lmenu() {
        VBox leftmenu = new VBox();
        leftmenu.setPrefWidth(250);
        leftmenu.setAlignment(Pos.TOP_LEFT);
        leftmenu.getStyleClass().add("left-menu");
        leftmenu.setSpacing(30);

        Button home = new Button("Home");
        Button favourite = playlists("Favourite","images/fav.png","favourite");
        Button playlist1 = playlists("Playlist1","images/search.png","favourite");
        Button library = new Button("Your Library");

        leftmenu.getChildren().addAll(home, favourite, playlist1, library);
        panel.setLeft(leftmenu);
    }

    public BorderPane getPanel() {
        return panel;
    }
}