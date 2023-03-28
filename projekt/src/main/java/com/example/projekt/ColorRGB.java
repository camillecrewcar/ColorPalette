package com.example.projekt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorRGB {
    private int red;
    private int green;
    private int blue;
    private String name;

    private Rectangle rect;
    private Button deleteButton;
    private Button updateButton;
    private String colorOwner;

    public ColorRGB(String name, int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
        rect = new Rectangle();
        rect.setFill(Color.rgb(red,green,blue));
        rect.setHeight(20.0);
        rect.setWidth(147.0);
        deleteButton = new Button();
        updateButton = new Button();

    }
    public ColorRGB(String name, int red, int green, int blue, String owner) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
        rect = new Rectangle();
        rect.setFill(Color.rgb(red,green,blue));
        rect.setHeight(20.0);
        rect.setWidth(147.0);
        deleteButton = new Button();
        updateButton = new Button();
        colorOwner = owner;

    }

    public ColorRGB() {
        red = 0;
        green = 0;
        blue = 0;
        name = "";
        rect = new Rectangle();
        rect.setFill(Color.rgb(red,green,blue));
        rect.setHeight(20.0);
        rect.setWidth(147.0);
        deleteButton = new Button();
        updateButton = new Button();
        colorOwner="";
    }

    static int comparePoints(ColorRGB colorRGB1, ColorRGB colorRGB2){
        int comparePoints = 0;
        comparePoints += Math.abs(colorRGB1.getRed() - colorRGB2.getRed());
        comparePoints += Math.abs(colorRGB1.getGreen() - colorRGB2.getGreen());
        comparePoints += Math.abs(colorRGB1.getBlue() - colorRGB2.getBlue());
        return comparePoints;
    }

    public String getColorOwner() {
        return colorOwner;
    }

    public void setColorOwner(String colorOwner) {
        this.colorOwner = colorOwner;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
        rect.setFill(Color.rgb(red,green,blue));
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
        rect.setFill(Color.rgb(red,green,blue));
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
        rect.setFill(Color.rgb(red,green,blue));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        rect.setFill(Color.rgb(red,green,blue));
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
