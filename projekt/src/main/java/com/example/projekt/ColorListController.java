package com.example.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ColorListController implements Initializable {
    @FXML
    public TableColumn colorOwnerColunm;
    @FXML
    private TableColumn blue;
    @FXML
    TableView tab;

    @FXML
    private TableColumn green;

    @FXML
    private Button menuButton;

    @FXML
    private TableColumn name;

    @FXML
    private TableColumn red;
    private ArrayList<Colors> list;
    @FXML
    private TableColumn sample;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cellFactories();
        ColorsRepo colorsRepo = new ColorsRepo();

        list = colorsRepo.findAllColors();
        for (Colors color:
             list) {
            System.out.println(color.getUser().getLogin());
            tab.getItems().add(new ColorRGB(color.getName(),color.getRed(),color.getGreen(),color.getBlue(),color.getUser().getLogin()));
        }

    }

    public void changeView(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) menuButton.getScene().getWindow();
        if(actionEvent.getSource() == menuButton) {

            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    void cellFactories(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        red.setCellValueFactory(new PropertyValueFactory<>("red"));
        green.setCellValueFactory(new PropertyValueFactory<>("green"));
        blue.setCellValueFactory(new PropertyValueFactory<>("blue"));
        sample.setCellValueFactory(new PropertyValueFactory<>("rect"));
        colorOwnerColunm.setCellValueFactory(new PropertyValueFactory<>("colorOwner"));

    }

}
