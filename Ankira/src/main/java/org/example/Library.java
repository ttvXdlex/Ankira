package org.example;


import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

//Тут типа класс с новым контентом короче по планам шобы все плейлисты тут отображались как с треками
public class Library  {
    private ScrollPane libscroller;

    public Library() {
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
        VBox playlist = Playlister.playlistulpoad("Favourite","fav.png");
        libscroll.getChildren().addAll(playlist);
        ScrollPane scrollplaylist = new ScrollPane(libscroll);
        scrollplaylist.setFitToWidth(true);
        scrollplaylist.setStyle("-fx-background: #2b2b2b;");
        libscroller = scrollplaylist;

    }

    public ScrollPane getLibscroller() {
        return libscroller;
    }
}
