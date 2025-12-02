package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//тута кароче новый класс с методом для создание кнопочек для плелистов
public class PlaylistsCreator {

    public static Button playlistsbtn(String text, String url, String css) { //то шо короче в скобачках, это переменны которые в основном классе (НЕ В ОСНОВНОМ-ОСНОВНОМ, А В SIDEMENU) ты меняеш под себя там текст се дела ну короче понятно
        ImageView icon = new ImageView(new Image("images/"+url)); //тута корочэ создается переменная и берется название картинки С РАСШИРЕНИЕМ!! которую ты там вписываешь при создании и т.д. кароче пути ненадо если чо.
        icon.setFitWidth(64);
        icon.setFitHeight(64);
        Button buttonlist = new Button(text, icon); //ну тут понятно
        buttonlist.getStyleClass().add(css); //тут тоже понятно
        buttonlist.setPrefWidth(256);
        buttonlist.setPrefHeight(64);
        buttonlist.setAlignment(Pos.TOP_LEFT);
        return buttonlist; //ну возвращает тебе саму кнопку че ты типо не догнал?
    }

}
