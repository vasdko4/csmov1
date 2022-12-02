package com.example.arraylistapplication;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SortElementController {

    private static Boolean statusSort;

    public static Boolean Sorts() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        Label Sort = new Label("Відсортувати ArrayList за?");
        Button butonsortOF = new Button("За зростанням");
        Button butonsortON = new Button("За cпаданням");

        butonsortOF.setOnAction(e -> {
            statusSort = false;
            window.close();
        });

        butonsortON.setOnAction(e -> {
            statusSort = true;
            window.close();
        });

        Sort.relocate(80, 60);
        butonsortOF.relocate(40, 200);
        butonsortON.relocate(230, 200);

        Sort.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 20;"/**/);
        butonsortON.setStyle("-fx-background-color: #5faeef;" +
                "-fx-background-radius: 10;" +
                " -fx-font-size: 20;" +
                "-fx-text-fill: white;");
        butonsortOF.setStyle("-fx-background-color: #5faeef;" +
                "-fx-background-radius: 10;" +
                " -fx-font-size: 20;" +
                "-fx-text-fill: white;");
        Sort.setStyle(" -fx-font-size: 20;");
        
        pane.getChildren().addAll(Sort, butonsortOF, butonsortON);
        Scene scene = new Scene(pane, 400, 300);
        window.setScene(scene);
        window.setTitle("Сортування елементів");
        window.showAndWait();

        return statusSort;
    }

    public static Boolean getStatusSort() {
        return statusSort;
    }
}
