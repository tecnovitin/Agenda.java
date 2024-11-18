package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Logincontroller implements trocaTela, Login {

    @FXML
    private TextField UsuarioLogin;
    @FXML
    private PasswordField SenhaUsuario;
    @FXML
    private Button btLogin;
    @FXML
    private Button btClique;

    @Override
    public void Logar() {
   String NomeUsuario = UsuarioLogin.getText();
   String Senha = SenhaUsuario.getText();





    }

    @Override
    public void outraTela() {

    }
}