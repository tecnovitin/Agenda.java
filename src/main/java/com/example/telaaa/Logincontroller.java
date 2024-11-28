package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Hyperlink LoginAdm; // Hyperlink para alternar para o login ADM

    @FXML
    public void initialize() {
        btLogin.setDisable(true);

        // Listeners para ativar/desativar o botão de login
        UsuarioLogin.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        SenhaLogin.textProperty().addListener((obs, oldText, newText) -> updateButtonState());

        // Alterna para login ADM
        LoginAdm.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela4(); // Vai para login ADM
            } catch (Exception e) {  // Captura a exceção genérica
                e.printStackTrace();
                showAlert("Erro", "Falha ao carregar a tela de login de administrador.");
            }
        });


        // Alterna para a tela de cadastro
        cadas.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela1();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Erro", "Falha ao carregar a tela de cadastro.");
            }
        });
    }

    @Override
    public void Logar() {
        btLogin.setOnAction(actionEvent -> {
            String nomeUsuario = UsuarioLogin.getText().trim();
            String senha = SenhaLogin.getText().trim();
            boolean encontrado = false;

            // Valida se os campos não estão vazios
            if (nomeUsuario.isEmpty() || senha.isEmpty()) {
                showAlert("Erro", "Por favor, preencha todos os campos.");
                return;
            }

            // Obtém a lista de usuários
            var usuarios = HelloApplication.getInstance().getUsuarios();

            if (usuarios.isEmpty()) {
                showAlert("Erro", "Nenhum usuário cadastrado.");
                return;
            }

            // Verifica o login
            for (Usuario usuario : usuarios) {
                if (nomeUsuario.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
                    encontrado = true;
                    try {
                        HelloApplication.getInstance().Tela3(); // Vai para a tela principal
                    } catch (Exception e) {  // Captura qualquer exceção genérica
                        e.printStackTrace();
                        showAlert("Erro", "Falha ao carregar a tela principal.");
                    }
                    break;
                }
            }


            if (!encontrado) {
                showAlert("Erro", "Nome de usuário ou senha incorretos.");
            }
        });
    }

    private void updateButtonState() {
        btLogin.setDisable(UsuarioLogin.getText().isEmpty() || SenhaLogin.getText().isEmpty());
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
        // Já está implementado no initialize()
    }
}
