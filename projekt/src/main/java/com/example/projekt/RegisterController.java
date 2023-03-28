package com.example.projekt;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    public PasswordField passwordRepeatTextfield;
    @FXML
    public PasswordField passwordTextfield;
    @FXML
    public Label topLabel;
    @FXML
    private Button backButton;

    @FXML
    private TextField cityTextfield;

    @FXML
    private TextField countryTextfield;

    @FXML
    private TextField flatNumberTextField;

    @FXML
    private TextField houseNumbertextField;

    @FXML
    private TextField loginTextfield;

    @FXML
    private TextField streetNameTextfield;

    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flatNumberTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    flatNumberTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        houseNumbertextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    houseNumbertextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }


    @FXML
    void changeView(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) backButton.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void register(ActionEvent event) throws IOException {

        if(!loginTextfield.getText().isEmpty()&& !passwordTextfield.getText().isEmpty() && !passwordRepeatTextfield.getText().isEmpty() && !countryTextfield.getText().isEmpty() && !cityTextfield.getText().isEmpty() && !streetNameTextfield.getText().isEmpty() && !houseNumbertextField.getText().isEmpty() && !flatNumberTextField.getText().isEmpty()){
            if(passwordTextfield.getText().matches("^(?=.*[A-Z])(?=.*[!@#$&*-_%^])(?=.*[0-9]).{8,}$")){
                if(passwordTextfield.getText().equals(passwordRepeatTextfield.getText())){
                    UserAccountRepo userAccountRepo = new UserAccountRepo();
                    if(userAccountRepo.findUser(loginTextfield.getText()) == null){
                        System.out.println("logujrmy");

                        AddressRepo addressRepo = new AddressRepo();

                        Address address = new Address(null, countryTextfield.getText(), cityTextfield.getText(), streetNameTextfield.getText(), Integer.valueOf(houseNumbertextField.getText()), Integer.valueOf(flatNumberTextField.getText()));
                        addressRepo.saveAddress(address);

                        UserAccount kamil = new UserAccount(null, loginTextfield.getText(), passwordTextfield.getText(), address);
                        userAccountRepo.saveUser(kamil);

                        Stage stage;
                        Parent root;
                        stage = (Stage) backButton.getScene().getWindow();

                        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                    else {
                        topLabel.setText("Użytkownik o tym loginie już istnieje");
                    }
                }
                else {
                    topLabel.setText("hasło zostało źle powtórzone");
                }
            } else {
                topLabel.setText("wprowadzone hasło jest za słabe");
            }
        } else {
            topLabel.setText("Proszę wprowadzić wszystkie dane");
        }

    }
}
