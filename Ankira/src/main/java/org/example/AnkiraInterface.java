package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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



        Sidemenu leftmenu = new Sidemenu();
        Search search = new Search();

        root.setCenter(search.getSearchtop());
        root.setLeft(leftmenu.getPanel());


        Scene scene = new Scene(root, 1200, 760);
        stage.setScene(scene);
        scene.getStylesheets().add("style/style.css");
        stage.show();

        stage.setOnCloseRequest(event -> {
            System.exit(0); // полностью завершает приложение
        });
    }
}
