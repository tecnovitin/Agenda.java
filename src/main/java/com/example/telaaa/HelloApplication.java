package com.example.telaaa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;
import obj.Administrador;
import obj.Calendario;
import obj.Usuario;

import java.io.IOException;
import java.util.ArrayList;


public class HelloApplication extends Application {

    ArrayList<Calendario> agendamentos = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Administrador> adiministradores = new ArrayList<>();

    private CalendarioController calendarioController;
    private SplitMenuButton splitMenuButton;
    private cadastroControle cadastroControle;


    private  Stage stage0;
        private static com.example.telaaa.HelloApplication instance;

        @Override
        public  void start( Stage stage0) throws IOException {
            instance = this;
            this.stage0 = stage0;
            Tela0();
            stage0.show();
        }




        public static com.example.telaaa.HelloApplication getInstance(){
            return instance;
        }

        public ArrayList<Calendario> getAgendamentos() {return agendamentos;}
        public  ArrayList<Usuario> getUsuarios(){return usuarios;}
        public  ArrayList<Administrador> getAdiministradores(){return adiministradores;}

        public void Tela0() throws IOException {
            Parent tela0 = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage0.setScene( new Scene(tela0));
        }

        public void Tela1() throws IOException{
                Parent tela1 = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
               stage0.setScene(new Scene(tela1));





        }

        public void Tela2() throws Exception {
            Parent tela2 = FXMLLoader.load(getClass().getResource("cadastroADM.fxml"));
            stage0.setScene(new Scene(tela2));

        }

        public void Tela3() {
        try {
            Parent tela3 = FXMLLoader.load(getClass().getResource("Calendario.fxml"));
            stage0.setScene(new Scene(tela3));
          } catch (IOException e) {
            e.printStackTrace();
         }
       }

          public void Tela4() {
        try {
            Parent tela4 = FXMLLoader.load(getClass().getResource("LoginADM.fxml"));
              stage0.setScene(new Scene(tela4));
             } catch (IOException e) {
            e.printStackTrace();
               }
      }



    public static void main(String[] args) {
            launch();
        }

     }
