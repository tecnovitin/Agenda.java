package com.example.telaaa;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage1) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
            stage1.setScene(new Scene(root));
            stage1.show();


    }
    public static void main(String[] args) {
        launch();
    }

}