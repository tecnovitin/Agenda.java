package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import obj.Usuario;

import java.io.IOException;

public class Logincontroller implements trocaTela, Login {

    @FXML
    private TextField UsuarioLogin;
    @FXML
    private PasswordField SenhaLogin;
    @FXML
    private Button btLogin;
    @FXML
    private Hyperlink cadas;

    @FXML
    public void initialize() {

        btLogin.setDisable(true);


        UsuarioLogin.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        SenhaLogin.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    @Override
    public void Logar() {
        btLogin.setOnAction(ActionEvent -> {
            String NomeUsuario = UsuarioLogin.getText();
            String Senha = SenhaLogin.getText();
            Boolean Encontrado = false;

            var usuarios = HelloApplication.getInstance().getUsuarios();

            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário cadastrado.");
                return;
            }

            for (Usuario usuario : usuarios) {
                if (NomeUsuario.equals(usuario.getNome()) && Senha.equals(usuario.getSenha())) {
                    Encontrado = true;
                    System.out.println("Encontrado");

                    try {
                        HelloApplication.getInstance().Tela3();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Erro ao Login");
                    }
                    break;
                }
            }
            if (!Encontrado) {
                System.out.println("Não encontrado");
            }
        });
    }

    private void updateButtonState() {

        btLogin.setDisable(UsuarioLogin.getText().isEmpty() || SenhaLogin.getText().isEmpty());
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
