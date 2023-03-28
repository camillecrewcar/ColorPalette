package com.example.projekt;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorListItemController implements Initializable {

    @FXML
    private Text blue;

    @FXML
    private Text green;

    @FXML
    private Text name;

    @FXML
    private Text red;

    @FXML
    private Rectangle sample;


    public void setData(ColorRGB colorRGB){
        name.setText(colorRGB.getName());
        red.setText(String.valueOf(colorRGB.getRed()));
        green.setText(String.valueOf(colorRGB.getGreen()));
        blue.setText(String.valueOf(colorRGB.getBlue()));
        sample.setWidth(32);
        sample.setHeight(32);
        sample.setFill(Color.rgb(colorRGB.getRed(),colorRGB.getGreen(), colorRGB.getBlue()));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
