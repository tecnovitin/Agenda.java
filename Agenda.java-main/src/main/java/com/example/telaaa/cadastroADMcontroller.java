package com.example.telaaa;


import interfaces.Cadastro;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import obj.Adiministrador;

import java.io.IOException;
import java.util.ArrayList;




public class cadastroADMcontroller implements Cadastro, trocaTela {


        ArrayList<obj.Adiministrador> listADM = new ArrayList<>();


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


        @Override
        public void Cadastro() {

            btCadastro.setDisable(true);
            String nome = nomeUsuario.getText();
            String cpf = CPFUsuario.getText();
            String senha = senhaUsuario.getText();
            float cod = Float.parseFloat(codADM.getText());
            String email = emailADM.getText();
            String Csenha = confirmaSenha.getText();


            nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, CPFUsuario, senhaUsuario, codADM, emailADM, confirmaSenha));
            CPFUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, CPFUsuario, senhaUsuario, codADM,emailADM,confirmaSenha));
            codADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, CPFUsuario, senhaUsuario, codADM, emailADM,confirmaSenha));
            senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, CPFUsuario, senhaUsuario, codADM,emailADM,confirmaSenha));
            emailADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, CPFUsuario, senhaUsuario, codADM,emailADM,confirmaSenha));
            confirmaSenha.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, CPFUsuario, senhaUsuario, codADM,emailADM,confirmaSenha));
            Adiministrador adm = new Adiministrador(nome, email, senha,Csenha, cod, cpf);


            btCadastro.setOnAction(actionEvent ->
                    listADM.add(adm));
        }

        private void updateButtonState(TextField nomeUsuario, TextField emailUsuario, PasswordField senhaUsuario, TextField emailADM, TextField adm, PasswordField confirmaSenha) {
            btCadastro.setDisable(nomeUsuario.getText().isEmpty() || emailUsuario.getText().isEmpty() || senhaUsuario.getText().isEmpty() || confirmaSenha.getText().isEmpty());
        }


    @Override
    public void outraTela() {
        btVoltar.setOnAction(actionEvent -> {
            try{
                HelloApplication.getInstance().Tela0();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}







