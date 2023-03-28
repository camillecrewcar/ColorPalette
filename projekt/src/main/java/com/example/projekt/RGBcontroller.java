package com.example.projekt;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class RGBcontroller implements Initializable{
    @FXML
    public Label greenLabel;
    @FXML
    public Slider blueSlider;
    @FXML
    public Label blueLabel;
    @FXML
    public Rectangle outputColor;
    @FXML
    public Button menuButton;
    @FXML
    public Label warningTextfield;
    @FXML
    public TableColumn deleteButtons;
    @FXML
    public TextField changeNameTextfield;
    @FXML
    public TextField changeRedTextField;
    @FXML
    public TextField changeGreenTextfield;
    @FXML
    public TextField changeBlueTextfield;
    @FXML
    public Button submitChangeButton;
    @FXML
    public HBox changePanel;
    @FXML
    private Slider redSlider;
    @FXML
    Slider greenSlider;
    @FXML
    private Label redLabel;
    @FXML
    TableView tab;
    @FXML
    TableColumn name;
    @FXML
    TableColumn red;
    @FXML
    TableColumn green;
    @FXML
    TableColumn blue;
    @FXML
    TableColumn sample;
    int currentRed;
    int currentGreen;
    int currentBlue;
    @FXML
    TextField namePrompt;
    int aktualnieEdytowany = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSliders();
        cellFactories();
        deleteColumn();
        updateColumn();
        changeRedTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    changeRedTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        changeGreenTextfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    changeGreenTextfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        changeBlueTextfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    changeBlueTextfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        changeRedTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(Objects.equals(newValue, "")){
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(0,Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                } else if (Integer.parseInt(newValue)>255){
                    changeRedTextField.setText("255");
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                }
                else {
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                }
            }
        });
        changeGreenTextfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(Objects.equals(newValue, "")){
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),0,Integer.parseInt(changeBlueTextfield.getText())));

                } else if (Integer.parseInt(newValue)>255){
                    changeGreenTextfield.setText("255");
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                }
                else {
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                }
            }
        });
        changeBlueTextfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(Objects.equals(newValue, "")){
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),0));

                } else if (Integer.parseInt(newValue)>255){
                    changeBlueTextfield.setText("255");
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                }
                else {
                    UserColors.getInstance().userColors.get(aktualnieEdytowany).getRect().setFill(Color.rgb(Integer.parseInt(changeRedTextField.getText()),Integer.parseInt(changeGreenTextfield.getText()),Integer.parseInt(changeBlueTextfield.getText())));

                }
            }
        });
        if(UserColors.getInstance().userColors != null){
            tab.getItems().addAll(UserColors.getInstance().userColors);
        }
    }
    void cellFactories(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        red.setCellValueFactory(new PropertyValueFactory<>("red"));
        green.setCellValueFactory(new PropertyValueFactory<>("green"));
        blue.setCellValueFactory(new PropertyValueFactory<>("blue"));
        sample.setCellValueFactory(new PropertyValueFactory<>("rect"));
    }
    void deleteColumn(){
        TableColumn actionCol = new TableColumn();

        actionCol.setCellValueFactory(new PropertyValueFactory<>("deleteButton"));

        Callback<TableColumn<ColorRGB, Button>, TableCell<ColorRGB, Button>> cellFactory
                = //
                new Callback<TableColumn<ColorRGB, Button>, TableCell<ColorRGB, Button>>() {
                    @Override
                    public TableCell call(final TableColumn<ColorRGB, Button> param) {
                        final TableCell<ColorRGB, Button> cell = new TableCell<ColorRGB, Button>() {

                            final Button btn = new Button("Usuń");

                            @Override
                            public void updateItem(Button item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {

                                        ColorsRepo colorsRepo = new ColorsRepo();
                                        System.out.println("usuniety kolor: " + getTableView().getItems().get(getIndex()).getName());
                                        colorsRepo.removeColor(colorsRepo.findColor(UserColors.getInstance().currentUser.getId(),getTableView().getItems().get(getIndex()).getName()));
                                        tab.getItems().remove(getTableView().getItems().get(getIndex()));


                                        UserColors.getInstance().userColors.remove(getIndex());

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);

        tab.getColumns().add(actionCol);
    }
    void updateColumn(){
        TableColumn actionCol = new TableColumn();
        actionCol.setCellValueFactory(new PropertyValueFactory<>("updateButton"));

        Callback<TableColumn<ColorRGB, Button>, TableCell<ColorRGB, Button>> cellFactory
                = //
                new Callback<TableColumn<ColorRGB, Button>, TableCell<ColorRGB, Button>>() {
                    @Override
                    public TableCell call(final TableColumn<ColorRGB, Button> param) {
                        final TableCell<ColorRGB, Button> cell = new TableCell<ColorRGB, Button>() {

                            final Button btn = new Button("Edytuj");

                            @Override
                            public void updateItem(Button item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        changePanel.setVisible(true);
                                        aktualnieEdytowany = getIndex();

                                        changeNameTextfield.setText(UserColors.getInstance().userColors.get(getIndex()).getName());
                                        changeRedTextField.setText(String.valueOf(UserColors.getInstance().userColors.get(getIndex()).getRed()));
                                        changeGreenTextfield.setText(String.valueOf(UserColors.getInstance().userColors.get(getIndex()).getGreen()));
                                        changeBlueTextfield.setText(String.valueOf(UserColors.getInstance().userColors.get(getIndex()).getBlue()));

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);

        tab.getColumns().add(actionCol);
    }

    void setSliders(){
        currentRed = 0;
        currentGreen = 0;
        currentBlue = 0;
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            currentRed = newValue.intValue();
            redLabel.setText(String.valueOf(newValue.intValue()));
            outputColor.setFill(Color.rgb(currentRed,currentGreen,currentBlue));
        });


        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            currentGreen = newValue.intValue();
            greenLabel.setText(String.valueOf(newValue.intValue()));
            outputColor.setFill(Color.rgb(currentRed,currentGreen,currentBlue));
        });
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            currentBlue = newValue.intValue();
            blueLabel.setText(String.valueOf(currentBlue));
            outputColor.setFill(Color.rgb(currentRed,currentGreen,currentBlue));
        });
    }
    public void addColor(ActionEvent actionEvent) {
        changePanel.setVisible(false);
        if (!namePrompt.getText().isEmpty() && namePrompt.getText().length() <= 15){
            ColorsRepo colorsRepo = new ColorsRepo();
            if(colorsRepo.findColor(UserColors.getInstance().currentUser.getId(),namePrompt.getText()) == null){
                warningTextfield.setVisible(false);
                ColorRGB color = new ColorRGB(namePrompt.getText(),currentRed,currentGreen,currentBlue);
                UserColors.getInstance().userColors.add(color);

                colorsRepo.saveColor(new Colors(null,namePrompt.getText(),currentRed,currentGreen,currentBlue,UserColors.getInstance().currentUser));

                tab.getItems().add(color);
                namePrompt.setText("");
            } else {
                warningTextfield.setVisible(true);
                warningTextfield.setText("już masz kolor o tej nazwie");
            }

        }
        else {
            warningTextfield.setText("Nazwa jest pusta lub za dluga");
            warningTextfield.setVisible(true);
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

    public void submitChange(ActionEvent actionEvent) {

        System.out.println(UserColors.getInstance().userColors.get(aktualnieEdytowany).getName());
        ColorsRepo colorsRepo = new ColorsRepo();
        if (!changeNameTextfield.getText().isEmpty()&&!changeRedTextField.getText().isEmpty()&&!changeGreenTextfield.getText().isEmpty()&&!changeBlueTextfield.getText().isEmpty()){
            if(Integer.valueOf(changeRedTextField.getText())<256 && Integer.valueOf(changeRedTextField.getText()) >= 0 && Integer.valueOf(changeBlueTextfield.getText())<256 && Integer.valueOf(changeBlueTextfield.getText()) >= 0 && Integer.valueOf(changeGreenTextfield.getText())<256 && Integer.valueOf(changeGreenTextfield.getText()) >= 0){
                warningTextfield.setVisible(false);
                Colors colors = colorsRepo.findColor(UserColors.getInstance().currentUser.getId(),UserColors.getInstance().userColors.get(aktualnieEdytowany).getName());
                colors.setName(changeNameTextfield.getText());
                colors.setRed(Integer.valueOf(changeRedTextField.getText()));
                colors.setGreen(Integer.valueOf(changeGreenTextfield.getText()));
                colors.setBlue(Integer.valueOf(changeBlueTextfield.getText()));
                colorsRepo.updateColor(colors);

                UserColors.getInstance().userColors.get(aktualnieEdytowany).setName(changeNameTextfield.getText());
                UserColors.getInstance().userColors.get(aktualnieEdytowany).setRed(Integer.valueOf(changeRedTextField.getText()));
                UserColors.getInstance().userColors.get(aktualnieEdytowany).setGreen(Integer.valueOf(changeGreenTextfield.getText()));
                UserColors.getInstance().userColors.get(aktualnieEdytowany).setBlue(Integer.valueOf(changeBlueTextfield.getText()));

                tab.refresh();
                changePanel.setVisible(false);
            }else {
                warningTextfield.setText("pola sa zle uzuplenione");
                warningTextfield.setVisible(true);
            }

        } else {
            warningTextfield.setText("Wszystkie pola muszą być uzupełnione");
            warningTextfield.setVisible(true);
        }


    }

}
