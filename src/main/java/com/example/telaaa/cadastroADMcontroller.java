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


public class cadastroADMcontroller implements Cadastro, trocaTela{


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
    private PasswordField codADM;
    @FXML
    public void initialize() {

        btCadastro.setDisable(true);
        nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, senhaUsuario, emailADM, confirmaSenha, codADM, CPFUsuario));
        CPFUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, senhaUsuario, emailADM, confirmaSenha, codADM, CPFUsuario));
        codADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, senhaUsuario, emailADM, confirmaSenha, codADM, CPFUsuario));
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, senhaUsuario, emailADM, confirmaSenha, codADM, CPFUsuario));
        emailADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, senhaUsuario, emailADM, confirmaSenha, codADM, CPFUsuario));
        confirmaSenha.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, senhaUsuario, emailADM, confirmaSenha, codADM, CPFUsuario));


    }
    private void updateButtonState(TextField nomeUsuario, PasswordField senhaUsuario, TextField emailADM, PasswordField confirmaSenha, TextField codADM, TextField CPFUsuario) {
        btCadastro.setDisable(nomeUsuario.getText().isEmpty() || emailADM.getText().isEmpty() || senhaUsuario.getText().isEmpty() || confirmaSenha.getText().isEmpty() || CPFUsuario.getText().isEmpty() || codADM.getText().isEmpty());
    }
    @Override
    public void Cadastro() {




        btCadastro.setOnAction(actionEvent -> {
            try {

                String nome = nomeUsuario.getText();
                String cpf = CPFUsuario.getText();
                String senha = senhaUsuario.getText();
                float cod = Float.parseFloat(codADM.getText());
                String email = emailADM.getText();
                String Csenha = confirmaSenha.getText();

                if (!senha.equals(Csenha)) {
                    showAlert("Erro de Cadastro", "As senhas não coincidem.");
                    senhaUsuario.requestFocus();
                    return;
                }
                Administrador adm = new Administrador(nome, email, senha, Csenha, cod, cpf);
                var usuarioADM = HelloApplication.getInstance().adiministradores;

                usuarioADM.add(adm);
                try {
                    HelloApplication.getInstance().Tela3();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Cliente adicionado com sucesso!");
            } finally {

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
                HelloApplication.getInstance().Tela0();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}









