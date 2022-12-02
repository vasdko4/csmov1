package com.example.arraylistapplication;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;


public class SearchElementButtoon {



    private static int s;
    private static int indexSerch;
    private static ArrayList<Element> arrayList = ArrayListServise.getArrayList();

    public static void Searchs() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        TextField elementSearch = new TextField();
        Label Serch = new Label("Знайти:");
        Label Serchs = new Label("Пошук:");
        Button butonserch = new Button("Пошук");
        StackPane elementFound = new StackPane();

        elementSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    elementSearch.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (elementSearch.getText().isEmpty()==false) {
                    int value = Integer.parseInt(newValue);
                    s = arrayList.size();
                    if (value >= s) {
                        elementSearch.setText(oldValue);
                    }
                }
            }

        });

        butonserch.setOnAction(e -> {
            if (elementSearch.getText().isEmpty()) {
                showMessageDialog(null, "Індекс не може бути пустим!Введіть індекс.", "Eror,index for search Empty!", ERROR_MESSAGE);
            } else {
                String text1 = elementSearch.getText();
                indexSerch = Integer.parseInt(text1);

                Rectangle rect = new Rectangle(100, 60);
                rect.setFill(arrayList.get(indexSerch).getColor());
                Text text = new Text((String) arrayList.get(indexSerch).getElement());
                Text index = new Text(Integer.toString(indexSerch));
                index.setTranslateY(-20);
                index.setTranslateX(-40);
                elementFound.getChildren().addAll(rect, index, text);
            }
        });

        Serchs.relocate(40, 100);
        Serch.relocate(40, 60);
        elementSearch.relocate(100, 60);
        butonserch.relocate(280, 60);
        elementFound.relocate(100, 100);

        Serch.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 14;"/**/);
        Serchs.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 14;"/**/);
        butonserch.setStyle("-fx-background-color: #008000;" +
                "-fx-background-radius: 14;" +
                " -fx-font-size: 14;" +
                "-fx-text-fill: white;");
        elementSearch.setStyle("-fx-background-radius: 14;" +
                " -fx-font-size: 14;"/**/);

        pane.getChildren().addAll(Serchs, Serch, elementSearch, butonserch, elementFound);
        Scene scene = new Scene(pane, 400, 300);
        window.setScene(scene);
        window.setTitle("Пошук");
        window.showAndWait();
    }

}


