package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class PlaylistMenu {
    private ScrollPane content;
    private FlowPane tracks;
    private PlayerBar playerBar;

    public PlaylistMenu(PlayerBar playerBar) {
        this.playerBar = playerBar;
        tracks = new FlowPane();

        tracks.setMaxWidth(944);
        tracks.setMaxHeight(760);
        tracks.setAlignment(Pos.CENTER);
        tracks.setHgap(50);
        tracks.setVgap(50);

        content = new ScrollPane(tracks);
        content.setFitToWidth(true);
        content.setStyle("-fx-background: #2b2b2b;");
    }

    public void showMenu(PlaylistStorage playlist) {
        tracks.getChildren().clear(); //очищает треки которые должны отобразиться, чтобы при переключении на другие плейлисты небыло дубликатов

        for (int i = 0; i < playlist.tracks.size(); i++) { //проходится по списку трекам плейлиста
            SongStorage song = playlist.tracks.get(i); //дает работу с треком из списка по индексу
            int trackindex = Songlist.getSonglist().indexOf(song); //берет индекс определенного трека для того чтобы в дальнейшем присвоить его проигрывателю
            VBox songbox = Songer.songscreat(song.name, song.artist, song.cover); //создает вбокс с треком

            songbox.setOnMouseClicked((event) -> {
                playerBar.tracks(trackindex); //передаем для проигрывание трека
            });

            tracks.getChildren().add(songbox);
        }
    }

    public ScrollPane getContent() {
        return content;
    }
}
