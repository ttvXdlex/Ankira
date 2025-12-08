package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Sidemenu {

    private final BorderPane root;//
    private final VBox test3;
    private final Library libraryscroll;
    private final PlaylistMenu playlistmenu;
    private final BorderPane panel;

    public Sidemenu(BorderPane root, VBox test3, Library libraryscroll, PlaylistMenu playlistmenu) {
        this.root = root;
        this.test3 = test3;
        this.libraryscroll = libraryscroll;
        this.playlistmenu = playlistmenu;
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
        library.setOnAction(e -> root.setCenter(libraryscroll.getLibscroller())); //ну тут по обработки действия он меняет центр
        leftmenu.getChildren().addAll(home, library);

        for (int i = 0; i < Playlists.getPlaylisters().size(); i++) { //ухты это же ЦИИКЛ, который перебирает наш список
            PlaylistStorage playlist = Playlists.getPlaylisters().get(i);
            Button playlistbox = PlaylistsCreator.playlistsbtn(playlist.text, playlist.url);//вот тута мы создаем кнопку и
            // из списка название и картинку берем для кнопки
            playlistbox.setOnAction(e ->{
                playlistmenu.showMenu(playlist);
                root.setCenter(playlistmenu.getContent());
            });

            leftmenu.getChildren().add(playlistbox); //ну и добавляет что выходит на выходе в левое меню
        }
        panel.setLeft(leftmenu);
    }

    public BorderPane getPanel() {
        return panel;
    }
}