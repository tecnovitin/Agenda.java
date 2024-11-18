package com.example.telaaa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {

        private  Stage stage0;
        private static com.example.telaaa.HelloApplication instance;

        @Override
        public  void start( Stage stage0) throws IOException {
            instance = this;
            this.stage0 = stage0;
            Tela1();
            stage0.show();
        }
        public static com.example.telaaa.HelloApplication getInstance(){
            return instance;
        }


        public void Tela1() throws IOException{
                Parent tela1 = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
               stage0.setScene(new Scene(tela1));





        }

        public void Tela2() throws Exception {
            Parent tela2 = FXMLLoader.load(getClass().getResource("cadastroADM.fxml"));
            stage0.setScene(new Scene(tela2));

        }


        public static void main(String[] args) {
            launch();
        }

    }
