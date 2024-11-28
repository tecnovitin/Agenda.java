package com.example.telaaa;

import interfaces.Cadastro;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import obj.Administrador;
import javafx.scene.control.Alert;

import java.io.IOException;

public class cadastroADMcontroller implements Cadastro, trocaTela {

    @FXML
    private Button btCadastro;
    @FXML
    private Button btVoltar;
    @FXML
    private TextField nomeUsuario;
    @FXML
    private TextField emailADM;
    @FXML
    private TextField CPFUsuario;
    @FXML
    private PasswordField confirmaSenha;
    @FXML
    private PasswordField senhaUsuario;
    @FXML
    private TextField codADM;

    @FXML
    public void initialize() {
        // Desabilitar o botão de cadastro até que todos os campos estejam preenchidos
        btCadastro.setDisable(true);
        nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        CPFUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        codADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        emailADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        confirmaSenha.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    private void updateButtonState() {
        btCadastro.setDisable(nomeUsuario.getText().isEmpty() ||
                emailADM.getText().isEmpty() ||
                senhaUsuario.getText().isEmpty() ||
                confirmaSenha.getText().isEmpty() ||
                CPFUsuario.getText().isEmpty() ||
                codADM.getText().isEmpty());
    }

    @Override
    public void Cadastro() {
        btCadastro.setOnAction(actionEvent -> {
            try {
                String nome = nomeUsuario.getText();
                String cpf = CPFUsuario.getText();
                String senha = senhaUsuario.getText();
                // Alteração para tratar o código do administrador como int
                int cod = Integer.parseInt(codADM.getText()); // Converter para inteiro
                String email = emailADM.getText();
                String Csenha = confirmaSenha.getText();

                if (!senha.equals(Csenha)) {
                    showAlert("Erro de Cadastro", "As senhas não coincidem.");
                    senhaUsuario.requestFocus();
                    return;
                }

                // Criando um novo administrador com os dados inseridos
                Administrador adm = new Administrador(nome, email, senha, Csenha, cod, cpf);
                var usuarioADM = HelloApplication.getInstance().adiministradores;

                // Adiciona o novo administrador à lista
                usuarioADM.add(adm);

                try {
                    HelloApplication.getInstance().Tela3(); // Redireciona para a tela principal
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Administrador cadastrado com sucesso!");
            } catch (NumberFormatException e) {
                showAlert("Erro de Cadastro", "O código do administrador deve ser um número válido.");
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

    @FXML
    private void limparCampos() {
        nomeUsuario.clear();
        CPFUsuario.clear();
        codADM.clear();
        senhaUsuario.clear();
        confirmaSenha.clear();
        emailADM.clear();
        nomeUsuario.requestFocus(); // Foco no primeiro campo
    }

    @Override
    public void outraTela() {
        btVoltar.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela0(); // Redireciona para a tela inicial
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
