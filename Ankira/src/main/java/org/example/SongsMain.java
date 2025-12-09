package org.example;


import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class SongsMain {
    private ScrollPane music;
    private final FlowPane tracks;
    private PlayerBar playerBar;

    public SongsMain(PlayerBar playerBar) {
        this.playerBar = playerBar;
        music = new ScrollPane();
        tracks = new FlowPane();
        Music(null);
    }

    private void Music(String searching) {
        tracks.setAlignment(Pos.CENTER);
        tracks.setHgap(50); //ну тут типа растояяния между тем что внутри флоуа задает по горизонту
        tracks.setVgap(50); //тож самое по верту
        tracks.getChildren().clear();

        List<SongStorage> songshow;
        if (searching == null) { //ну типа если серчинг ничему не равен то он задает переменной весь список
            songshow = Songlist.getSonglist();
        }
        else {
            songshow = Songlist.search(searching); //ну или в другом случае чо? Он задает переменной то чему равен серчинг.
        }

        for (int i = 0; i < songshow.size(); i++) { //ухты это же ЦИИКЛ, который перебирает наш список
            SongStorage songlist = songshow.get(i);
            int trackindex = i;
            VBox songbox = Songer.songscreat(songlist.name, songlist.artist, songlist.cover); //вот тута мы создаем вбокс и
            // из списка название и картинку берем для вбокса

            songbox.setOnMouseClicked((event) -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    playerBar.tracks(trackindex);
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    addPlaylist(event, songlist, songbox);
                }
            });

            tracks.getChildren().add(songbox); //ну и добавляет что выходит на выходе в скролпэйн библиотеки
        }

        ScrollPane songscroll = new ScrollPane(tracks); //ну тут ттож понятно тут как раз создается скроллпэйн
        songscroll.setFitToWidth(true); //корочееее он типо растягивает по ширине, иба без этого он автоматом все в лево переносит
        songscroll.setStyle("-fx-background: #2b2b2b;");
        music = songscroll;
    }

    // ну кароч это МЕЕЕЕЕЕТОД для показа меню с плаклмстами
    private void addPlaylist(javafx.scene.input.MouseEvent event, SongStorage song, VBox songbox) {
        ContextMenu contextMenu = new ContextMenu();

        // НУ типа ну это ну тут мы вроде как создаем меню для плейлистов
        for (int i = 0; i < Playlists.getPlaylisters().size(); i++) {
            PlaylistStorage playlist = Playlists.getPlaylisters().get(i);
            MenuItem menuItem = new MenuItem("Add in: " + playlist.text);

            menuItem.setOnAction(e -> {
                if (!playlist.tracks.contains(song)) {
                    playlist.addtrack(song);
                }
            });

            contextMenu.getItems().add(menuItem);
        }

        // Показываем менюшку в месте клика
        contextMenu.show(songbox, event.getScreenX(), event.getScreenY());
    }

    public void searchupdated(String searching) {
        Music(searching); //ну перенаправляет на метод Мюзик с заданной переменой в серче.
    }

    public ScrollPane getMusic() {
        return music;
    }
}