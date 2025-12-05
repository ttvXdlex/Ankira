package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//нижний плеер бар, пока не робит чисто юишка
public class PlayerBar {
    private final BorderPane musicplayer;

    public PlayerBar() {
        musicplayer = new BorderPane();
        playerbar();
    }

    private void playerbar() {
        ImageView cover = new ImageView(new Image("images/fav.png"));
        cover.setFitHeight(50);
        cover.setFitWidth(50);
        Label title = new Label("Track1T rack1T rack1Tra ck1 asdas ");
        Label artist = new Label("Artist1");

        ImageView previmg = new ImageView(new Image("images/prevplayer.png"));
        ImageView nextimg = new ImageView(new Image("images/nextplayer.png"));
        ImageView playimg = new ImageView(new Image("images/playplayer.png"));
        ImageView pasueimg = new ImageView(new Image("images/pauseplayer.png"));
        ImageView volumeimg = new ImageView(new Image("images/volume.png"));
        previmg.setFitHeight(24);
        previmg.setFitWidth(24);
        nextimg.setFitHeight(24);
        nextimg.setFitWidth(24);
        pasueimg.setFitHeight(24);
        pasueimg.setFitWidth(24);
        playimg.setFitHeight(24);
        playimg.setFitWidth(24);
        volumeimg.setFitHeight(24);
        volumeimg.setFitWidth(24);
        Button prev = new Button("", previmg);
        Button playpause = new Button("", playimg);
        Button next = new Button("", nextimg);
        Slider progress = new Slider();
        progress.setMaxWidth(500);
        progress.setPrefWidth(500);
        progress.setMinWidth(500);
        Button volume = new Button("", volumeimg);
        Slider volumeprogress = new Slider();
        volumeprogress.setMaxWidth(100);
        volumeprogress.setPrefWidth(100);
        volumeprogress.setMinWidth(100);

        VBox textinfo = new VBox(title, artist);
        textinfo.setAlignment(Pos.CENTER_LEFT);

        HBox info = new HBox(cover, textinfo);
        info.setAlignment(Pos.CENTER_LEFT);
        info.setSpacing(10);

        HBox controls = new HBox(prev, playpause, next);
        controls.setSpacing(10);
        controls.setAlignment(Pos.CENTER);
        VBox centercontrols = new VBox(controls, progress);
        centercontrols.setAlignment(Pos.CENTER);


        HBox volumebar = new HBox(volume, volumeprogress);
        volumebar.setAlignment(Pos.CENTER_RIGHT);


        musicplayer.setLeft(info);
        musicplayer.setCenter(centercontrols);
        musicplayer.setRight(volumebar);
    }

    public BorderPane getMusicplayer() {
        return musicplayer;
    }
}
