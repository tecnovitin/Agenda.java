package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import obj.Administrador;

public class loginADMcontroller implements Login, trocaTela {

    @FXML
    private TextField nomeUsuario;
    @FXML
    private PasswordField senhaUsuario;
    @FXML
    private TextField codigoADM;
    @FXML
    private Button btLogin;
    @FXML
    private Hyperlink cadas;

    @FXML
    public void initialize() {
        btLogin.setDisable(true);

        nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        codigoADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    @Override
    public void Logar() {
        btLogin.setOnAction(ActionEvent -> {
            String NomeUsuario = nomeUsuario.getText();
            String Senha = senhaUsuario.getText();
            String Codigo = codigoADM.getText();
            Boolean Encontrado = false;

            var administradores = HelloApplication.getInstance().getAdiministradores();

            if (administradores.isEmpty()) {
                System.out.println("Nenhum administrador cadastrado.");
                return;
            }

            for (Administrador administrador : administradores) {
                if (NomeUsuario.equals(administrador.getNome()) && Senha.equals(administrador.getSenha()) && Codigo.equals(String.valueOf(administrador.getCodigo()))) {
                    Encontrado = true;
                    System.out.println("Administrador encontrado");

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
                showAlert("Erro de Login", "Nome de usuário, senha ou código de administrador incorretos.");
            }
        });
    }

    private void updateButtonState() {
        btLogin.setDisable(nomeUsuario.getText().isEmpty() || senhaUsuario.getText().isEmpty() || codigoADM.getText().isEmpty());
    }

    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void outraTela() {
        cadas.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela4(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
