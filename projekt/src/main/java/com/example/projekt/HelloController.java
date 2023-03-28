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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    public Button registerButton;
    @FXML
    public PasswordField passwordTextField;
    @FXML
    public TextField loginTextField;
    @FXML
    public Label topLabel;
    @FXML
    private Button submit;


    @FXML
    private void changeView(ActionEvent event) throws Exception {
        Stage stage;
        Parent root = null;
        stage = (Stage) submit.getScene().getWindow();
            if(event.getSource() == submit) {

                UserAccountRepo userAccountRepo = new UserAccountRepo();

                if(userAccountRepo.findUser(loginTextField.getText()) == null){
                    topLabel.setText("nie ma użytkownika o takim loginie");

                } else {
                    UserColors.getInstance().currentUser = userAccountRepo.findUser(loginTextField.getText());
                    if (Objects.equals(UserColors.getInstance().currentUser.getPassword(), passwordTextField.getText())){
                        ColorsRepo colorsRepo = new ColorsRepo();

                        for (Colors color:
                             colorsRepo.findColors(UserColors.getInstance().currentUser.getId())) {
                            UserColors.getInstance().userColors.add(new ColorRGB(color.getName(),color.getRed(),color.getGreen(),color.getBlue()));
                        }

                        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                    else {
                        topLabel.setText("Niepoprawne hasło");
                    }
                }

            } else if (event.getSource() == registerButton){
                root = FXMLLoader.load(getClass().getResource("register.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

    }


}