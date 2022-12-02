package com.example.arraylistapplication;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AddElementController {
    private static String value;
    private static Color backgroundColor;
    private static Boolean testAddExit;


    public static Element addValue() {

        testAddExit = false;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        TextField elementValue = new TextField();
        Label labelElementValue = new Label("Введіть значення елемента:");
        Label labelColorPicker = new Label("Оберіть колір:");
        Button addButton = new Button("Додати значення");
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.rgb(179, 153, 255));

        elementValue.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!elementValue.getText().isEmpty()) {
                int value = elementValue.getLength();
                if (value >= 14) {
                    elementValue.setText(oldValue);
                }
            }
        });

        addButton.setOnAction(e -> {
            if (elementValue.getText().isEmpty()) {
                value = "елемент";
            } else {
                value = elementValue.getText();
            }
            backgroundColor = colorPicker.getValue();
            window.close();
            testAddExit = true;
        });

        labelElementValue.relocate(120, 60);
        elementValue.relocate(120, 80);
        labelColorPicker.relocate(155, 120);
        colorPicker.relocate(130, 140);
        addButton.relocate(105, 200);

        addButton.setStyle("-fx-background-color: #5faeef;" +
                "-fx-background-radius: 10;" +
                " -fx-font-size: 20;" +
                "-fx-text-fill: white;");

        pane.getChildren().addAll(labelElementValue, elementValue, addButton, colorPicker, labelColorPicker);
        Scene scene = new Scene(pane, 400, 300);
        window.setScene(scene);
        window.setTitle("Додати значення до Array List");
        window.showAndWait();

        Element elementAdd;
        if (value == null) {
            elementAdd = new Element("value", Color.rgb(179, 153, 255));
        } else {
            elementAdd = new Element(value, backgroundColor);
        }

        return elementAdd;
    }

    public static Boolean getTest() {
        return testAddExit;
    }
}
