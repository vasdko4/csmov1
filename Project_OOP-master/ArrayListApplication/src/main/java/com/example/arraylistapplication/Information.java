package com.example.arraylistapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Information extends Application {

    public static void aboutDevelopers() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-developers.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Developers");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(715);
        primaryStage.setMaxWidth(715);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxHeight(400);
        primaryStage.show();
    }

    public void start(Stage primaryStage) throws IOException {}

    public static void aboutProgram() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("information.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 660);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Information");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(715);
        primaryStage.setMaxWidth(715);
        primaryStage.setMinHeight(660);
        primaryStage.setMaxHeight(660);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}


