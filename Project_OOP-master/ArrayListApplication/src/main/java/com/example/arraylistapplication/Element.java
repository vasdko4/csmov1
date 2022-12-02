package com.example.arraylistapplication;

import javafx.scene.paint.Color;

public class Element implements Comparable<Element> {
    private Color color;
    private String valueOfElement;


    public Element(String valueOfElement, Color color) {

        if (color == null) {
            throw new IllegalArgumentException("Об'єкт не може бути null");
        }

        if (valueOfElement.isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути пустим");
        }
        this.valueOfElement = valueOfElement;
        this.color = color;
    }

    @Override
    public int compareTo(Element o1) {
        try {
           int get1 =Integer.parseInt(this.getElement());
            int get2 =Integer.parseInt(o1.getElement());
            return  get1-get2;
        } catch (Exception e) {
            return this.getElement().compareTo(o1.getElement());
        }
    }



    public String getElement() {
        return valueOfElement;
    }

    public void setValueOfElement(String element) {
        if (valueOfElement.isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути пустим");
        }

        this.valueOfElement = element;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Об'єкт не може бути null");
        }

        this.color = color;
    }

    @Override
    public String toString() {
        return  valueOfElement + " " + color;
    }

}

