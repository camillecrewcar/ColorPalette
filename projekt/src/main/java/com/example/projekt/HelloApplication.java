package com.example.projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root;
        try(Session session = Connect.openSession()) {
            System.out.println("połączono");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        UserColors.getInstance().userColors = new ArrayList<>();

    }

    public static void main(String[] args) {
        launch();
    }

}