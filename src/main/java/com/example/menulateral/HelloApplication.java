package com.example.menulateral;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale locale = new Locale("es_Es");
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.menu",locale);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"),bundle);
        Scene scene = new Scene(fxmlLoader.load(), 400, 450);
        stage.setTitle("Hello!");
        stage.setMinWidth(400);
        stage.setMinHeight(450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}