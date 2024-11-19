package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;

import java.awt.event.ActionEvent;
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
    @FXML
    private Hyperlink cadas;

    @Override
    public void Logar() {
   String NomeUsuario = UsuarioLogin.getText();
   String Senha = SenhaUsuario.getText();





    }

    @Override
    public void outraTela() {
        cadas.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela1();
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        });

    }
}