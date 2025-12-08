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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


public class PlayerBar {
    private final BorderPane musicplayer;
    private ImageView playpauseimg;;
    private ImageView cover;
    private Label title;
    private Label artist;
    private Button playpause, prev, next;
    private Slider progress;
    private Slider volumeprogress;

    private int songnumber;

    private Timer timer;
    private TimerTask timerTask;
    private MediaPlayer mediaPlayer;
    private boolean running = false;
    private boolean offsound = false;

    public void playmedia(){
        if (mediaPlayer != null) {
            mediaPlayer.play(); //запускает плеер
            running = true; //булену задается тру, чтобы обозначить что трек щас играет
            playpauseimg.setImage(new Image("images/pauseplayer.png"));
            beginTimer();
        }
    }


    public void pausemedia(){
        if (mediaPlayer != null) {
            mediaPlayer.pause(); //ставится на паузку
            running = false; //помечается что не играет
            playpauseimg.setImage(new Image("images/playplayer.png"));
            cancelTimer();
        }
    }

    public void previousmedia() {

        if (songnumber > 0) {
            loadsongs(songnumber-1);
            playmedia();
        }
        else {
            loadsongs(songnumber);
            playmedia();
        }

    }

    public void nextmedia() {

        if (songnumber < Songlist.getSonglist().size() - 1 ) {
            loadsongs(songnumber+1);
            playmedia();
        }
        else  {
            loadsongs(songnumber);
            playmedia();
        }

    }

    public void volumemediaoff(){
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0); //ставит звук на ноль
            offsound = true; //помечает что выключен

        }

    }

    public void volumemediaon(){
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volumeprogress.getValue() / 100.0); //если звук включен, то он возвращает значение громкости которое стоит у волум прогресс.
            offsound = false; //помечает что включен.
        }

    }


    public void beginTimer() {
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                if (mediaPlayer != null) {
                    if (running == true) {
                        double currenttime = mediaPlayer.getCurrentTime().toSeconds();
                        double total = mediaPlayer.getTotalDuration().toSeconds();

                        progress.setValue((currenttime / total) * 100);
                    }

                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void cancelTimer() {
        if (timer != null) {
            timer.cancel();
        }

    }


    public PlayerBar() {
        musicplayer = new BorderPane();
        playerbar();
    }


    private void loadsongs(int index){ //метод для загрузки треков по индексу
        songnumber = index; //переменная куда будет сохраняется индекс трека
        SongStorage song = Songlist.getSonglist().get(songnumber); //получает данные трека по индексу

        if (mediaPlayer != null) {
            mediaPlayer.stop(); //останавливает предыдущий трек
        }

        File file = new File("Ankira/src/main/resources/" + song.audiofile);

        Media media = new Media(file.toURI().toString()); //это класс медиа который работает с аудифайлом, тут он получает сам файл который
        //ранее передавался через индекс по списку, после чего переделывает файл в специальный для него путь, потом переделывает его в стринговый путь.
        mediaPlayer = new MediaPlayer(media); //а тут плеер берет сам Медиа, потому что он работает токо с медией, тем самым он получает в себя трек с которым
        //дальше он может работать.



        mediaPlayer.setVolume(volumeprogress.getValue() / 100.0);

        title.setText(song.name); //дает название файла
        artist.setText(song.artist);
        cover.setImage(new Image("images/" + song.cover));
        progress.setValue(0);
    }

    public void tracks(int index){
        loadsongs(index);
        playmedia();

    }

    private void playerbar() {
        cover = new ImageView(new Image("images/defaulttrack.png"));
        cover.setFitHeight(50);
        cover.setFitWidth(50);
        title = new Label("Track1T rack1T rack1Tra ck1 asdas ");
        artist = new Label("Artist1");

        ImageView previmg = new ImageView(new Image("images/prevplayer.png"));
        ImageView nextimg = new ImageView(new Image("images/nextplayer.png"));
        playpauseimg = new ImageView(new Image("images/playplayer.png"));
        ImageView volumeimg = new ImageView(new Image("images/volume.png"));
        previmg.setFitHeight(24);
        previmg.setFitWidth(24);
        nextimg.setFitHeight(24);
        nextimg.setFitWidth(24);
        playpauseimg.setFitHeight(24);
        playpauseimg.setFitWidth(24);
        volumeimg.setFitHeight(24);
        volumeimg.setFitWidth(24);
        prev = new Button("", previmg);
        playpause = new Button("", playpauseimg);
        next = new Button("", nextimg);
        progress = new Slider();
        progress.setMaxWidth(500);
        progress.setPrefWidth(500);
        progress.setMinWidth(500);
        Button volume = new Button("", volumeimg);
        volumeprogress = new Slider();
        volumeprogress.setMaxWidth(100);
        volumeprogress.setPrefWidth(100);
        volumeprogress.setMinWidth(100);
        volumeprogress.setValue(40);

        prev.setOnAction(e -> previousmedia());

        next.setOnAction(e -> nextmedia());

        volumeprogress.valueProperty().addListener((ov, oldv, newv) -> {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(newv.doubleValue() / 100.0); //устанавливает громкость, коотрая равна новому измененому значению слайдера, которая переобразовывается
                //в двойное значение (с запятой) и делится на 100, потому что громкость измеряется от 0 до 1.0
            }
        });


        progress.setOnMousePressed(e -> { //если кликнуть на прогресс баре
            if (mediaPlayer != null) {
                double newtime = (progress.getValue() / 100.0) * mediaPlayer.getTotalDuration().toSeconds(); //создает двойное значение ввиде переменой нью тайм, которое равняется
                //полученному значению прогрессу(слайдера, которое после умножается на полученную общую длительность трека в секундах, чтобы понять на какой секунде сейчас надо перематать трек.
                mediaPlayer.seek(Duration.seconds(newtime)); // перематывает на новое заданное время
            }
        });

        progress.setOnMouseDragged(e -> { //тоже самое  но если двигать ползунок а не кликать.
            if (mediaPlayer != null) {
                double newtime = (progress.getValue() / 100.0) * mediaPlayer.getTotalDuration().toSeconds();
                mediaPlayer.seek(Duration.seconds(newtime));
            }
        });

        volume.setOnAction(e -> {
            if(offsound == true){
                volumemediaon();//если звук выключен
            }
            else {
                volumemediaoff();//если включен
            }
        });

        playpause.setOnAction(e -> {
            if (running) {
                pausemedia(); //если играет то паузка
            }
            else {
                playmedia();
            }
        });


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
