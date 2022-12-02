package com.example.arraylistapplication;


import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private FlowPane flowPane;

    @FXML
    private ScrollPane scrollPane;

    static final ArrayListServise arrayList = new ArrayListServise();
    static ArrayList<Element> arrayListElements = ArrayListServise.getArrayList();

    @FXML
    protected void onDraw() {
        scrollPane.viewportBoundsProperty().addListener((ov, oldBounds, bounds) -> {
            flowPane.setPrefWidth(bounds.getWidth());
            flowPane.setPrefHeight(bounds.getHeight());
        });

        flowPane.getChildren().clear();
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setVgap(10);
        flowPane.setHgap(10);

        for (int i = 0; i < arrayListElements.size(); i++) {
            Rectangle rect = new Rectangle(100, 60);
            rect.setFill(arrayListElements.get(i).getColor());
            Text text = new Text(arrayListElements.get(i).getElement());
            Text index = new Text(Integer.toString(i));
            index.setTranslateY(-20);
            index.setTranslateX(-40);
            StackPane stack = new StackPane();
            stack.getChildren().addAll(rect, index, text);
            flowPane.getChildren().addAll(stack);
            scrollPane.setContent(flowPane);
        }

    }


    @FXML
    protected void onAddButtonClick() {
        arrayList.onAdd(AddElementController.addValue());
        onDraw();
    }

    @FXML
    protected void onRemoveButtonClick() {
        arrayList.onRemove(DeleteElementController.elementDelets());
        onDraw();
    }

    @FXML
    protected void onEditButtonClick() {
        arrayList.onEdit(EditElementController.edit());
        onDraw();
    }

    @FXML
    protected void onClearButtonClick() {
        arrayList.onClear(ClearElementController.Clears());
        onDraw();
    }

    @FXML
    protected void onSearchButtonClick() {
        SearchElementButtoon.Searchs();
    }

    @FXML
    protected void onSortButtonClick() {
        arrayList.onSort(SortElementController.Sorts());
        onDraw();
    }

    @FXML
    protected void onAboutProgramButtonClick() throws IOException {
        Information.aboutProgram();
    }


    @FXML
    protected void onAboutDevelopersButtonClick() throws IOException {
        Information.aboutDevelopers();
    }

}