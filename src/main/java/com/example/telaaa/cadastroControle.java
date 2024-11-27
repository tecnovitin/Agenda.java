package com.example.telaaa;

import interfaces.Cadastro;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import obj.Usuario;
import javafx.scene.control.Alert;

public class cadastroControle implements Cadastro, trocaTela {

    @FXML
    private Button btCadastro;
    @FXML
    private TextField nomeUsuario;
    @FXML
    private TextField emailUsuario;
    @FXML
    private PasswordField senhaUsuario;
    @FXML
    private PasswordField confirmaSenha;
    @FXML
    private Hyperlink hyper;

    @FXML
    public void initialize() {

        btCadastro.setDisable(true);


        nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        emailUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        confirmaSenha.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    @Override
    public void Cadastro() {
        btCadastro.setOnAction(actionEvent -> {
            String nome = nomeUsuario.getText();
            String email = emailUsuario.getText();
            String senha = senhaUsuario.getText();
            String Csenha = confirmaSenha.getText();

            if (!senha.equals(Csenha)) {
                showAlert("Erro de Cadastro", "As senhas não coincidem.");
                senhaUsuario.requestFocus();
                return;
            }

            var cadastro = HelloApplication.getInstance().usuarios;

            Usuario cliente = new Usuario(nome, email, senha, Csenha);
            cadastro.add(cliente);
            System.out.println("Cliente adicionado com sucesso!");

            try {
                HelloApplication.getInstance().Tela3();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updateButtonState() {

        btCadastro.setDisable(
                nomeUsuario.getText().isEmpty() ||
                        emailUsuario.getText().isEmpty() ||
                        senhaUsuario.getText().isEmpty() ||
                        confirmaSenha.getText().isEmpty()
        );
    }

    @Override
    public void outraTela() {
        hyper.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela2();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
