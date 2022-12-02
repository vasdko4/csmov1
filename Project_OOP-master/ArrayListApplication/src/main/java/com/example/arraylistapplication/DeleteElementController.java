package com.example.arraylistapplication;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;


public class DeleteElementController {

    private static int elementSearchDelete;
    private static int arraySize;
    private static ArrayList<Element> arrayList = ArrayListServise.getArrayList();

    public static int elementDelets() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        TextField elementDelete = new TextField();
        Label Delete = new Label("Який елемент ви хочете видалити?");
        Button butonDelete = new Button("Видалити");
        Label textDelet = new Label("Введіть Індекс:");

        elementDelete.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    elementDelete.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (elementDelete.getText().isEmpty() == false) {
                    int value = Integer.parseInt(newValue);
                    arraySize = arrayList.size();
                    if (value >= arraySize) {
                        elementDelete.setText(oldValue);
                    }
                }
            }
        });

        arraySize = arrayList.size();
        elementSearchDelete = arraySize;

        butonDelete.setOnAction(e -> {
            if (elementDelete.getText().isEmpty()) {
                showMessageDialog(null, "Індекс не може бути пустим!Введіть індекс.", "Error,index for delete Empty!", ERROR_MESSAGE);
            } else {
                String text1 = elementDelete.getText();
                elementSearchDelete = Integer.parseInt(text1);
                window.close();
            }
        });

        Delete.relocate(80, 60);
        elementDelete.relocate(140, 100);
        butonDelete.relocate(130, 150);
        textDelet.relocate(40, 100);

        Delete.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 14;"/**/);
        textDelet.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 14;"/**/);
        butonDelete.setStyle("-fx-background-color: #5faeef;" +
                "-fx-background-radius: 10;" +
                " -fx-font-size: 20;" +
                "-fx-text-fill: white;");
        elementDelete.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 14;"/**/);


        pane.getChildren().addAll(Delete, textDelet, butonDelete, elementDelete);
        Scene scene = new Scene(pane, 400, 300);
        window.setScene(scene);
        window.setTitle("Видалити");
        window.showAndWait();
        return elementSearchDelete;
    }

}


