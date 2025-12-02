package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Sidemenu {

    private BorderPane root;//
    private VBox test3;
    private VBox librarycontent;
    private BorderPane panel;

    public Sidemenu(BorderPane root, VBox test3, VBox librarycontent) {
        this.root = root;
        this.test3 = test3;
        this.librarycontent = librarycontent;
        panel = new BorderPane();
        lmenu();
    }


    private void lmenu() {
        VBox leftmenu = new VBox();
        leftmenu.setPrefWidth(256);
        leftmenu.setAlignment(Pos.TOP_LEFT);
        leftmenu.getStyleClass().add("left-menu");
        leftmenu.setSpacing(15);

        ImageView homei = new ImageView(new Image("images/home.png"));
        homei.setFitWidth(32);
        homei.setFitHeight(32);
        Button home = new Button("", homei);
        home.getStyleClass().add("buttonslide");
        home.setOnAction(e -> root.setCenter(test3)); //ну тут по обработки действия он меняет центр


        ImageView libi = new ImageView(new Image("images/library.png"));
        libi.setFitWidth(32);
        libi.setFitHeight(32);
        Button library = new Button("", libi);
        library.getStyleClass().add("buttonslide");
        library.setOnAction(e -> root.setCenter(librarycontent)); //ну тут по обработки действия он меняет центр

        Button favourite = PlaylistsCreator.playlistsbtn("Favourite","fav.png","playlist"); //ну вот как работает наш метод для создание кнопочек че

        Button playlist1 = PlaylistsCreator.playlistsbtn("Playlist","pl1.jpg","playlist");

        Button playlist2 = PlaylistsCreator.playlistsbtn("Playlist","pl2.jpg","playlist");
        leftmenu.getChildren().addAll(home, favourite, playlist1, playlist2, library);
        panel.setLeft(leftmenu);
    }

    public BorderPane getPanel() {
        return panel;
    }
}