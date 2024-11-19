package com.example.telaaa;


import interfaces.Cadastro;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import obj.Usuario;


import java.io.IOException;
import java.util.ArrayList;

 public class cadastroControle implements Cadastro, trocaTela {
    public ArrayList<Usuario> listCliente = new ArrayList<>();


     @FXML
     private Button btCadastro;
     @FXML
     private Button btLogin;
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

     @Override
     public void Cadastro() {

        btCadastro.setDisable(true);


         String nome = nomeUsuario.getText();
         String email = emailUsuario.getText();
         String senha = senhaUsuario.getText();
         String Csenha = confirmaSenha.getText();


         nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));
         emailUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));
         confirmaSenha.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));
         senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));


         Usuario Cliente = new Usuario(nome, email, senha, Csenha);


         btCadastro.setOnAction(actionEvent ->
                 listCliente.add(Cliente));
     }

     private void updateButtonState(TextField nomeUsuario, TextField emailUsuario, PasswordField senhaUsuario, PasswordField confirmaSenha) {
         btCadastro.setDisable(nomeUsuario.getText().isEmpty() || emailUsuario.getText().isEmpty() || senhaUsuario.getText().isEmpty() || confirmaSenha.getText().isEmpty());
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





