package com.example.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    public Button createColor;
    @FXML
    public Button logOut;
    @FXML
    public Button colorMixing;
    @FXML
    public Button allColorsButton;


    public void changeView(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) createColor.getScene().getWindow();
        if(actionEvent.getSource() == createColor) {
            root = FXMLLoader.load(getClass().getResource("colorCreator.fxml"));
        } else if (actionEvent.getSource() == colorMixing) {
            root = FXMLLoader.load(getClass().getResource("ColorMixer.fxml"));
        } else if (actionEvent.getSource() == allColorsButton) {
            root = FXMLLoader.load(getClass().getResource("ColorList.fxml"));
        }
        else {
            UserColors.getInstance().userColors.clear();
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
