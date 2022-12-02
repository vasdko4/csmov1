package com.example.arraylistapplication;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class EditElementController {
    private static String value;
    private static Color backgroundColor;
    private static Element changeElements;
    private static ArrayList<Element> arrayList = ArrayListServise.getArrayList();
    private static Boolean changeTest;

    private static int arraySize;


    private static int indexGet;


    public static Element edit() {

        changeTest = false;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        TextField elementSearch = new TextField();
        TextField elementValue = new TextField();
        Label labelElementValue = new Label("Введіть нове значення елемента:");
        Label labelColorPicker = new Label("Оберіть  новий колір:");
        Label labelIndex = new Label("Введіть індекс:");
        Button changebuton = new Button("Додати значення");
        arraySize = arrayList.size();
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.rgb(179, 153, 255));

        elementSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    elementSearch.setText(newValue.replaceAll("[^\\d]", ""));
                }

                if (elementSearch.getText().isEmpty() == false) {
                    int valuetest1 = Integer.parseInt(newValue);
                    if (valuetest1 >= arraySize) {
                        elementSearch.setText(oldValue);
                    }
                }
            }
        });

        elementValue.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (elementValue.getText().isEmpty() == false) {
                    int valuetest2 = elementValue.getLength();
                    if (valuetest2 >= 14) {
                        elementValue.setText(oldValue);
                    }
                }
            }
        });

        changebuton.setOnAction(e -> {
            if (elementSearch.getText().isEmpty()) {
                showMessageDialog(null, "Індекс не може бути пустим!", "Error,index for edit Empty!", ERROR_MESSAGE);
            } else {
                String text1 = elementSearch.getText();
                indexGet = Integer.parseInt(text1);
                if (elementValue.getText().isEmpty()) {
                    value = "елемент";
                } else {
                    value = elementValue.getText();
                }
                backgroundColor = colorPicker.getValue();
                changeTest = true;
                window.close();
            }
        });

        labelIndex.relocate(120, 20);
        elementSearch.relocate(120, 40);
        labelElementValue.relocate(120, 70);
        elementValue.relocate(120, 90);
        labelColorPicker.relocate(120, 120);
        colorPicker.relocate(130, 140);
        changebuton.relocate(105, 180);

        changebuton.setStyle("-fx-background-color: #5faeef;" +
                "-fx-background-radius: 10;" +
                " -fx-font-size: 20;" +
                "-fx-text-fill: white;");

        pane.getChildren().addAll(labelElementValue, elementValue, changebuton, colorPicker, labelColorPicker, elementSearch, labelIndex);
        Scene scene = new Scene(pane, 400, 300);
        window.setScene(scene);
        window.setTitle("Змінити значення елемента в Array List");
        window.showAndWait();
        if (value == null) {
            changeElements = new Element("value", Color.rgb(179, 153, 255));
        } else {
            changeElements = new Element(value, backgroundColor);
        }
        return changeElements;
    }

    public static Boolean getChangeTest() {
        return changeTest;
    }

    public static int getIndexGet() {
        return indexGet;
    }
}
