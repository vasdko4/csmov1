package com.example.arraylistapplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IllegalStateException, IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 600);
        primaryStage.setTitle("ArrayList");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(600);
        Platform.runLater(primaryStage::show);
    }

    public static void main(String[] args) {
        launch();
    }
}