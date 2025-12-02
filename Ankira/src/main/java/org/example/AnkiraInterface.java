package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class AnkiraInterface extends Application {
    BorderPane root = new BorderPane();
    @Override
    public void start(Stage stage) {
        stage.setTitle("Ankira");
        stage.setResizable(false);

        root.setStyle("-fx-background-color: #191919");

        Scene scene = new Scene(root, 1200, 760);

        Library library = new Library(); //короче вот тут вот мы создаем новый обьект из класса либрали
        VBox librarycontent = library.LibraryContent(); //ну тута саздаем новый вбокс шариш? Юзает метод из класса


        Search search = new Search();
        SongsMain music = new SongsMain();

        VBox test3 = new VBox(); //тут кароч создается новая коробочка по вертикали шобы обьединить поисковик и песенки,
        //чтобы оба засунуть по центру в наш бордерпэээээээээээээээээээйн
        test3.getChildren().addAll(search.getSearchtop(), music.getMusic()); //ну тут панятна типа ну добавляем их ну короче ты понял
        VBox.setVgrow(music.getMusic(), Priority.ALWAYS); //это короче тип очень важно, оно по вертикали дает заполнить определенный слой до конца вертикали
        // , ну тут типа слой с музыкой если ты не понял но ты понял короче


        Sidemenu leftmenu = new Sidemenu(root, test3, librarycontent); //НОВИНКА!!!! Тут короче добавлены приколы которые должны
        //передаться в класс SideMenu, чисто для того шобы работало переключение между Домиком и Библиотекой.


        root.setCenter(test3);
        root.setLeft(leftmenu.getPanel());


        stage.setScene(scene);
        scene.getStylesheets().add("style/style.css");
        stage.show();

        stage.setOnCloseRequest(event -> {
            System.exit(0); // полностью завершает приложение
        });
    }

}
