package Ankira.hz.Ankira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;

@SpringBootApplication
public class AnkiraApplication {

    public static void main(String[] args) {

        // 1. Запускаем Spring Boot в отдельном потоке
        new Thread(() -> SpringApplication.run(AnkiraApplication.class, args)).start();

        // 2. Запускаем JavaFX GUI
        Application.launch(AnkiraInterface.class, args);
    }
}
