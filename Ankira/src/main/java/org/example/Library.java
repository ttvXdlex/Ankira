package org.example;


import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


//Тут типа класс с новым контентом короче по планам шобы все плейлисты тут отображались как с треками
public class Library  {
    private BorderPane root;
    private ScrollPane libscroller;
    private PlaylistMenu playlistmenu;

    public Library(BorderPane root, PlaylistMenu playlistmenu) {
        this.root = root;
        this.playlistmenu = playlistmenu;
        libscroller = new ScrollPane();
        LibraryContent();
    }

    private void LibraryContent() {
        FlowPane libscroll = new FlowPane();
        libscroll.setMaxWidth(944);
        libscroll.setMaxHeight(760);
        libscroll.setAlignment(Pos.CENTER);
        libscroll.setHgap(50); //ну тут типа растояяния между тем что внутри флоуа задает по горизонту
        libscroll.setVgap(50); //тож самое по верту
        for (int i = 0; i < Playlists.getPlaylisters().size(); i++) { //ухты это же ЦИИКЛ, который перебирает наш список
            PlaylistStorage playlist = Playlists.getPlaylisters().get(i);
            VBox playlistbox = Playlister.playlistulpoad(playlist.text, playlist.url); //вот тута мы создаем вбокс и
            // из списка название и картинку берем для вбокса
            playlistbox.setOnMouseClicked(event -> {
                playlistmenu.showMenu(playlist);
                root.setCenter(playlistmenu.getContent());
            });
            libscroll.getChildren().add(playlistbox); //ну и добавляет что выходит на выходе в скролпэйн библиотеки
        }
        ScrollPane scrollplaylist = new ScrollPane(libscroll);
        scrollplaylist.setFitToWidth(true);
        scrollplaylist.setStyle("-fx-background: #2b2b2b;");
        libscroller = scrollplaylist;

    }

    public ScrollPane getLibscroller() {
        return libscroller;
    }
}
